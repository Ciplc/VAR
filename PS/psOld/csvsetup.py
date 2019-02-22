# Developed by Henry Graham for VAR under the MIT license
# Puts header on csv file if requested
import csv


def setheaders():
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
    # open csv file for heading
    with open("data.csv", 'a') as f:
        writer = csv.writer(f)
        writer.writerows([headers])
    # task complete outputting to terminal
    print("Complete")
