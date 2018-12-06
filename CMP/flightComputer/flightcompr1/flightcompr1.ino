/* Developed by Henry G for VAR under the MIT license
*/

//Include required libraries
#include <SPI.h>
#include <SD.h>
#include <Servo.h>


//Declare pins here
const int CSpin = 10;
//Blank string for writing with
String dataS = "";


void setup(){

    // Open Serial comms. 
    Serial.begin(9600);
    //Wait for serial to open
    while(!Serial){
        ;
    }

    Serial.print("Init. SD card");

    //If card isn't detected throw
    if(!SD.begin(CSpin)){

        Serial.println("SD card not detected/failed");
        while(1);
    }

    //No errors proced
    Serial.println("Card init.");

    //init pinmodes here
}

void loop(){

    /*
    Record data here
    */
    int res1, res2, res3 = 0;
    //Make file available
    //File outFile = SD.open("log.csv", FILE_WRITE);

    dataS = String(res1) + "," + String(res2) + "," + String(res3);

    /*
    //if file is open, print
    if(outFile){
        outFile.println(dataS);
        outFile.close();
        //Print to serial to log
        Serial.println(dataS);
    //Throw error if file error
    }else{
        Serial.println("error with file");
    }
    */

   //Output to log
   output(dataS);

}

static output(String data){

    //open file
    File outFile = SD.open("log.csv", FILE_WRITE);
    //if file is open, print
    if(outFile){
        //Output to file then close file
        outFile.println(data);
        outFile.close();
        //Print to serial
        Serial.println(data);
    }
    else{
        //Pass error to serial
        Serial.println("error with file");
    }
}

void findInverse(){

    //TODO find inverse of a given point

}

void thrust(){

    //TODO thrust

}
