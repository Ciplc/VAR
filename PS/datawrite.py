#importing sensehat, csv, and time
#sense_emu is the sensehat -v for emulation on a RPI
#sense_hat is the non emulated -v
from sense_emu import SenseHat
import csv
import time

#initializing sensehat opject
sense = SenseHat()
counter = 0
#config IMU sensor https://pythonhosted.org/sense-hat/api/#imu-sensor
sense.set_imu_config(True, True, True)

#get environmental data from the sensehat
def get_enviro():


	pressure = sense.get_pressure()
	tempPress = sense.get_temperature_from_pressure()
	tempHumid = sense.get_temperature_from_humidity()
	humidity = sense.get_humidity()

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
        
        
#get data from gatherer methods and write it
def get_data():

	#call gatherer methods
	enviro_res = get_enviro()
	IMU_res = get_IMU()

	#put results into a single list
	results = []
	results.extend(enviro_res)
	results.extend(IMU_res)
    	#open data.csv and output findings
	with open("data.csv", 'a') as f:

        #initializing csv writer object to write to f
            writer = csv.writer(f)
            writer.writerows([results])

#loop to 20
while(counter < 101):
    
    print(counter)
    get_data()
    counter = counter + 1
