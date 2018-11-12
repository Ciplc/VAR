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

#get data from the SenseHat
def get_data():

    pressure = sense.get_pressure()
    temperature = sense.get_temperature()
    accelraw = sense.get_accelerometer_raw()

    #accelraw is in the format z,y,x in Gs
    accelx = accelraw['x']
    accely = accelraw['y']
    accelz = accelraw['z']

    #change results into a more friendly format for writing
    results = [

        time,
        pressure,
        temperature,
        accelz,
        accely,
        accelx

    ]

    with open("data.csv", 'a') as f:

        #initializing csv writer object to write to f
        writer = csv.writer(f)
        writer.writerows([results])


while True:

    get_data()
    time.sleep(2)
