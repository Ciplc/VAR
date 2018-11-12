#importing sensehat, csv, and time
#sense_emu is the sensehat -v for emulation on a RPI
#sense_hat is the non emulated -v
from sense_emu import SenseHat
import csv
import time

#initializing sensehat opject
sense = SenseHat()

#config IMU sensor https://pythonhosted.org/sense-hat/api/#imu-sensor
sense.set_imu_config(False, False, True)

#opening csv file for future use
open("data.csv", 'a') as f

#get data from the SenseHat
def get_data():

    pressure = sense.get_pressure()
    temperature = sense.get_temperature()
    accelraw = sense.get_accelerometer_raw()

    #change results into a more friendly format for writing
    results = [

        time,
        pressure,
        temperature,
        accelraw,           #accelraw is in the format x,y,z in Gs

    ]

    write_data(results)


def write_data(dict: results):

    #initializing csv writer object to write to f
    writer = csv.writer(f)
    writer.writerows([results])
