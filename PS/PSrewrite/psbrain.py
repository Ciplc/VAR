# Developed by Henry G for VAR under the MIT license
# Records data from the sense hat and outputs it a csv file.
# Also records from a camera
# sense_emu is the sensehat -v for emulation on a RPI
# sense_hat is the non emulated -v
from sense_emu import SenseHat
import datetime
import sys
import picamera
import json
import csv
import os


class CSVSetup:

    def setheaders(self):
        """Sets headers for data.csv if a new file is to be used"""
        headers = [
            'Time', 'Pressure', 'Temperature from Pressure',
            'Temperature from Humidity', 'Humidity',
            'Accelerometer X', 'Accelerometer Y',
            'Accelerometer Z', 'Gyroscope X',
            'Gyroscope Y', 'Gyroscope Z', 'Compass X',
            'Compass Y', 'Compass Z', 'Pitch', 'Roll', 'Yaw'
        ]

        # open csv file for heading
        with open("data.csv", 'a') as f:
            writer = csv.writer(f)
            writer.writerows([headers])

        print("Wrote Headers")
        return "Complete"


class DataWrite:
    def __init__(self):
        self.sense = SenseHat()
        self.sense.set_imu_config(True, True, True)

    def get_data(self):
        """Gets data from environmental sensors and IMU sensors and formats it for writing to a CSV"""
        # get environmental data from the sensehat
        def get_enviro():
            """Gets environmental data and formats it in the form:

            pressure, temperature_pressure, temperature_humidity, humidity
            """
            pressure = self.sense.get_pressure()
            temp_press = self.sense.get_temperature_from_pressure()
            temp_humid = self.sense.get_temperature_from_humidity()
            humidity = self.sense.get_humidity()

            enviro_results = [
                pressure, temp_press,
                temp_humid, humidity
            ]

            return enviro_results

        # get IMU data from the sensehat
        def get_imu():
            """Gets IMU data and formats it in the form:

            accelX, accelY, accelZ, gyroX, gyroY, gyroZ, compassX, compassY, compassZ, orientationX, orientationY,
            orientationZ
            """
            # get raw data from IMU sensors
            accelraw = self.sense.get_accelerometer_raw()
            gyroraw = self.sense.get_gyroscope_raw()
            compassraw = self.sense.get_compass_raw()
            orientationraw = self.sense.get_orientation_degrees()

            imu_results = [
                accelraw['x'], accelraw['y'], accelraw['z'],
                gyroraw['x'], gyroraw['y'], gyroraw['z'],
                compassraw['x'], compassraw['y'], compassraw['z'],
                orientationraw['pitch'], orientationraw['roll'],
                orientationraw['yaw']
            ]

            return imu_results

        enviro_res = get_enviro()
        imu_res = get_imu()
        time = datetime.datetime.now()
        results = [time, ]
        results.extend(enviro_res)
        results.extend(imu_res)

        return results

    def write_data(self):

        with open('data.csv', 'a') as f:
            writer = csv.writer(f)
            writer.writerows(self.get_data())


class Camera:
    def __init__(self):
        self.camera = picamera.PiCamera()

    def read_run(self):

        with open('runnum.json') as f:
            data = json.loads(f.read())
            return data['runs']

    def dump_run(self):

        data = {'runs': self.read_run() + 1}
        with open('runum.json', 'w') as f:
            json.dump(data, f)

    def stop_test(self):

        for file in os.listdir('./'):
            if file.endswith('.varstp'):
                self.stop_recording()

    def start_recording(self):

        self.camera.start_recording('run_' + self.read_run() + '.h264')

    def stop_recording(self):

        self.camera.stop_recording()
        self.dump_run()


def main():

    camera = Camera()
    csvsetup = CSVSetup()

    if sys.argv[2] == 'n':
        stat = csvsetup.setheaders()
        if stat == "Complete":
            # TODO implement RTC loop
            pass
    elif sys.argv[2] == 'a':
        # TODO implement RTC loop
        pass
    else:
        print("Error command line arguments are limited to a or n")
        exit(0)

    camera.camera.resolution(1920, 1080)
    camera.start_recording()


if __name__ == '__main__':
    main()
