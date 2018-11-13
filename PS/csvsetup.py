import csv

def set():

	headers = [
	
		'Time',	
		'Pressure',
		'Temperature from Pressure',
		'Temperature from Humidity',
		'Humidity',
		'Accelerometer X',
		'Accelerometer Y',
		'Accelerometer Z',
		'Gyroscope X',
		'Gyroscope Y',
		'Gyroscope Z',
		'Compass X',
		'Compass Y',
		'Compass Z',
		'Pitch',
		'Roll',
		'Yaw'
	
	]

	with open("data.csv", 'a') as f:

		writer = csv.writer(f)
		writer.writerows([headers])

	print("Complete")
