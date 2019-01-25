# Developed by Henry Graham for VAR under the MIT license
# Records data from the sense hat and outputs it a csv file.
# importing sensehat, csv, and time
# sense_emu is the sensehat -v for emulation on a RPI
# sense_hat is the non emulated -v
from sense_emu import SenseHat
import csv
import datetime
import csvsetup as setup
import sys
import picamera
import json

# initializing sensehat
sense = SenseHat()
# initialize camera
camera = picamera.PiCamera()

# config IMU sensor https://pythonhosted.org/sense-hat/api/#imu-sensor
sense.set_imu_config(True, True, True)


# get environmental data from the sensehat
def get_enviro():
    pressure = sense.get_pressure()
    tempPress = sense.get_temperature_from_pressure()
    tempHumid = sense.get_temperature_from_humidity()
    humidity = sense.get_humidity()

    # format results into a 'csv'
    enviro_results = [

        pressure,
        tempPress,
        tempHumid,
        humidity

    ]

    return enviro_results


# get IMU data from the sensehat
def get_imu():
    accelraw = sense.get_accelerometer_raw()

    accelx = accelraw['x']  # change data into a friendlier format
    accely = accelraw['y']
    accelz = accelraw['z']

    gyroraw = sense.get_gyroscope_raw()

    gyrox = gyroraw['x']  # change data into a friendlier format
    gyroy = gyroraw['y']
    gyroz = gyroraw['z']

    compassraw = sense.get_compass_raw()

    compassx = compassraw['x']  # change data into a friendlier format
    compassy = compassraw['y']
    compassz = compassraw['z']

    orientationraw = sense.get_orientation_degrees()

    pitch = orientationraw['pitch']  # change data into a friendlier format
    roll = orientationraw['roll']
    yaw = orientationraw['yaw']

    # format results into a 'csv'
    imu_results = [

        accelx,
        accely,
        accelz,
        gyrox,
        gyroy,
        gyroz,
        compassx,
        compassy,
        compassz,
        pitch,
        roll,
        yaw

    ]

    return imu_results


# setup csv output file to include headers if new.
def csv_setup(argv):
    if argv == 'a':
        print("Append mode")
        return "Complete"
    elif argv == 'n':
        print("New mode")
        setup.setheaders()
        return "Complete"
    else:
        print("No argument specified/Incorrect argument specified, running in append mode")
        return "Complete"


# get data from gatherer methods and write it
def get_data():
    # call gatherer methods
    enviro_res = get_enviro()
    imu_res = get_imu()

    # Get datetime (accuracy unconfirmed)
    time = datetime.datetime.now()

    # put results into a single list

    results = [

        time,
    ]

    results.extend(enviro_res)
    results.extend(imu_res)

    # open data.csv and output findings
    with open("data.csv", 'a') as f:
        # initializing csv writer object to write to f
        writer = csv.writer(f)
        writer.writerows([results])


# Modify once program is being used properly
# loop program to 100 entries
def loop():
    counter = 1
    # loop to 100
    while counter < 101:
        print(counter)
        get_data()
        counter = counter + 1
    # TODO implement timing with RTC


# Recording Stuff below
# Read runs from json file
def read_run():
    with open('runnum.json') as f:
        data = json.loads(f.read())
    return data["runs"]


# Dump run number into json file
def dump_run():

    #  Read from the JSON file and add 1 to returned value
    data = {'runs': read_run() + 1}
    with open('runnum.json', 'w') as f:
        json.dump(data, f)


# Start video recording
def start_recording():

    # TODO finish implementing video recording to file.
    #  See https://picamera.readthedocs.io/en/release-1.13/recipes1.html#recording-over-multiple-files

    # filename = now + '.h264'
    camera.start_recording('run_' + read_run() + '.h264')


# Stop the recording and update runs
def stop_recording():

    camera.stop_recording()
    dump_run()


# Initialize script
if __name__ == "__main__":

    # If an arg is provided run it else run with arg foo to force append mode.
    # If more than 1 arg is provided throw error and stop
    if len(sys.argv) == 2:

        stat = csv_setup(sys.argv[1])
        if stat == "Complete":
            loop()

    elif len(sys.argv) == 1:

        stat = csv_setup("foo")
        if stat == "Complete":
            loop()
    else:
        print("Error command line arguments are limited to 1 or less")
        exit(0)

    # set camera resolution then start it up.
    camera.resolution(1920, 1080)
    camera.start_preview()
