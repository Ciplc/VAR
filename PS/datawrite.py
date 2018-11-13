#importing sensehat, csv, and time
#sense_emu is the sensehat -v for emulation on a RPI
#sense_hat is the non emulated -v
from sense_emu import SenseHat
import csv
import time
import datetime
import csvsetup as setup
import sys

#initializing sensehat opject
sense = SenseHat()

#config IMU sensor https://pythonhosted.org/sense-hat/api/#imu-sensor
sense.set_imu_config(True, True, True)

#get environmental data from the sensehat
def get_enviro():


	pressure = sense.get_pressure()
	tempPress = sense.get_temperature_from_pressure()
	tempHumid = sense.get_temperature_from_humidity()
	humidity = sense.get_humidity()

	#format results into a 'csv'
	enviro_results = [

		pressure,
		tempPress,
		tempHumid,
		humidity

	]

	return enviro_results
#get IMU data from the sensehat

def get_IMU():

	accelraw = sense.get_accelerometer_raw()

	accelx = accelraw['x']	#change data into a friendlier format
	accely = accelraw['y']
	accelz = accelraw['z']

	gyroraw = sense.get_gyroscope_raw()

	gyrox = gyroraw['x']	#change data into a friendlier format
	gyroy = gyroraw['y']
	gyroz = gyroraw['z']
	
	compassraw = sense.get_compass_raw()
	
	compassx = compassraw['x']	#change data into a friendlier format
	compassy = compassraw['y']
	compassz = compassraw['z']
	
	orientationraw = sense.get_orientation_degrees()
	
	pitch = orientationraw['pitch']	#change data into a friendlier format
	roll = orientationraw['roll']
	yaw = orientationraw['yaw']

    #format results into a 'csv'
	IMU_results = [

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
	
	return(IMU_results)
        
def csv_setup(argv):

	if(argv == 'a'):
            print("1")
            print("Append mode")
            return("Complete")
	elif(argv == 'n'):
            print("2")
            print("New mode")
            setup()
            return("Complete")
	else:
            print("3")
            print("No argument specified, running in append mode")
            return("Complete")



#get data from gatherer methods and write it
def get_data():

	#call gatherer methods
	enviro_res = get_enviro()
	IMU_res = get_IMU()

	#Get datetime (accuracy unconfirmed)
	time = datetime.datetime.now()

	#put results into a single list

	results = [

		time,
	]

	results.extend(enviro_res)
	results.extend(IMU_res)

        #open data.csv and output findings
	with open("data.csv", 'a') as f:

        #initializing csv writer object to write to f
            writer = csv.writer(f)
            writer.writerows([results])


def loop():
    
    counter = 1
    #loop to 100
    while(counter < 101):
        
        print(counter)
        get_data()
        counter = counter + 1


if __name__ == "__main__":

	stat = csv_setup(sys.argv[1:])
	if(stat == "Complete"):
		loop()
