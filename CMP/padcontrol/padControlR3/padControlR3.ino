/*
    Developed by Henry Graham for the VAR CMP program
    Distributed under the MTI license, see license file.

    Pad control program, designed to be run on Arduino (Board Num)
*/
#include <Wire.h>
#include <Adafruit_GFX.h>
#include "Adafruit_LEDBackpack.h"

//Declaring the 7seg display as an obj
Adafruit_7segment matrix = Adafruit_7segment();

//Declare pins
int startPin = 9;
int abortPin = 8;
int launchPin = 7;

//Status check bools
boolean startState = false;
boolean abortState = false;
boolean launchState = false;
boolean upTime = false;
boolean downTime = true;

//Time counting
int time = 120;

//Setup Loop
void setup(){

    //Set required pins to their required modes
    pinMode(abortPin, INPUT);
    pinMode(launchPin, OUTPUT);
    pinMode(startPin, INPUT);

    //Begin serial conv., output PDC Rev. ver.
    #ifndef __AVR_ATtiny85__
    Serial.begin(9600);
    Serial.println("PadControl Revision 3");
    #endif

    //initialize matrix
    matrix.begin(0x70);
}


void loop(){

    //Waits for start button to be pressed to ensure no
    //accidental starts
    if(digitalRead(startPin) == HIGH){

            startState == true;

    }

    //Checks if startState is TRUE so that countdown can begin
    if(startState == true){

        //Checks if it is time to count down
        if(downTime == true){

            //Counts down 1 second at a time
            matrix.println(time - 1);
            time = time - 1;

        }

        //When launch acc., start counting uptime.
        if(time == 0){

            downTime = false;
            upTime = true;
            launchState = true;

        }

        //Checks if it is time to count up.
        if(upTime == true){
            
            //Counts up 1 second at a time
            matrix.println(time + 1);
            time = time + 1;

        }

        //If launchState is met trigger a launch
        if(launchState == true){

            digitalWrite(launchPin, HIGH);

        }

    //Else print error code for no start.
    }else{

        matrix.println(8888);

    }

    //Check if the abort button is being pressed
    if(digitalRead(abortPin) == HIGH){

        //Set abortState to true, output error to serial and code to matrix
        abortState = true;
        Serial.println("ABORT DETECTED");
        matrix.print(9999);
        exit;

    }

    //Refresh the 7seg display 
    matrix.writeDisplay();

    //Delay in X miliseconds
    delay(100);
}
