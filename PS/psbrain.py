# Developed by Henry G for VAR under the MIT license
# Records data from the sense hat and outputs it a csv file.
# Also records from a camera
# sense_emu is the sensehat -v for emulation on a RPI
# sense_hat is the non emulated -v
from sense_hat import SenseHat
import datetime
import sys
import picamera
import json
import csv
import os
import time


# Sets headers for a new .csv file
class CSVSetup:

    @staticmethod
    def setheaders():
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


# Writes data to a csv file in a preset format seen below
class DataWrite:

    def __init__(self):
        self.sense = SenseHat()
        self.sense.set_imu_config(True, True, True)

    def get_data(self):
        """Gets data from environmental sensors and IMU sensors

        and formats it for writing to a CSV with time as the first item
        """
        # get environmental data from the sensehat
        def get_enviro():
            """Gets environmental data and formats it in the form:

            pressure, temperature_pressure, temperature_humidity, humidity
            """
            # Get readings from each sensor
            pressure = self.sense.get_pressure()
            temp_press = self.sense.get_temperature_from_pressure()
            temp_humid = self.sense.get_temperature_from_humidity()
            humidity = self.sense.get_humidity()

            # Format the readings
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

            # Format raw data into a usable list
            imu_results = [
                accelraw['x'], accelraw['y'], accelraw['z'],
                gyroraw['x'], gyroraw['y'], gyroraw['z'],
                compassraw['x'], compassraw['y'], compassraw['z'],
                orientationraw['pitch'], orientationraw['roll'],
                orientationraw['yaw']
            ]

            return imu_results

        # Get data from sensors and add time then append together
        enviro_res = get_enviro()
        imu_res = get_imu()
        current_time = str(datetime.datetime.now())
        results = [current_time, ]
        results.extend(enviro_res)
        results.extend(imu_res)

        return results

    def write_data(self):
        """Writes data to data.csv in append mode as to not delete headers or previous data"""
        with open('data.csv', 'a') as f:
            writer = csv.writer(f)
            writer.writerows(self.get_data())


# Camera class which aids in the basic operations of the picamera
class Camera:

    def __init__(self):
        self.camera = picamera.PiCamera()

    @staticmethod
    def read_run():
        """Reads the number of runs from runnum.json in order to have file extensions in an ordered fashion"""
        with open('runnum.json') as f:
            data = json.loads(f.read())
            return str(data['runs'])

    def dump_run(self):
        """Dumps the number of runs plus one into runnum.json"""
        data = {'runs': int(self.read_run()) + 1}
        with open('runnum.json', 'w') as f:
            json.dump(data, f)

    def stop_test(self):
        """Tests to see if a file with the extension of .varstp is in the toplevel directory"""
        # If there is a file in the running dir with a .varstp extension stop recording
        for file in os.listdir('./'):
            if file.endswith('.varstp'):
                self.stop_recording()
                print("terminated")

    def start_recording(self):
        """Starts the picamera recording with the file format of run_runnum.h264"""
        self.camera.start_recording('run_' + self.read_run() + '.h264')

    def stop_recording(self):
        """Stops recording from the picamera and updates the runnum with dump_run"""
        self.camera.stop_recording()
        self.dump_run()


class CommandLineArgsInvalid:
    """Raised when there are too many or not enough command line args"""
    pass


def main():

    # Defining objects to work with
    camera = Camera()
    csvsetup = CSVSetup()

    # If the arg in place two is -n set headers up
    try:
        if sys.argv[2] == 'n':
            stat = csvsetup.setheaders()
            if stat == "Complete":
                # TODO implement RTC loop
                pass
        elif sys.argv[2] == 'a':  # If arg in place two is -a just append
            # TODO implement RTC loop
            pass
        else:  # If neither n nor a is set fail out
            raise CommandLineArgsInvalid
    except CommandLineArgsInvalid:
        print("Error command line arguments are limited to a or n only")
        exit(0)

    # Set camera resolution and start recording
    camera.camera.resolution(1920, 1080)
    camera.start_recording()
    loop()


def main2():
    csvsetup = CSVSetup()
    
    csvsetup.setheaders()
    
    loop()
    
    
def loop():
    camera = Camera()
    
    camera.camera.resolution = (1920, 1080)
    camera.start_recording()
    data = DataWrite()

    while True:
        time.sleep(10)
        data.write_data()
        camera.stop_test()


if __name__ == '__main__':
    main2()
