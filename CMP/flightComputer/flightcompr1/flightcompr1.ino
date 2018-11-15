/* Developed by <user> for VAR under the MIT license
*/

//Include required libraries
#include <SPI.h>
#include <SD.h>

void setup(){

    // Open Serial comms. 
    Serial.begin(9600);
    //Wait for serial to open
    while(!Serial){
        ;
    }

    Serial.print("Init. SD card");

    //If card isn't detected throw
    if(!SD.begin(chipSelect)){

        Serial.println("SD card not detected/failed")
        while(1);
    }

    //No errors proced
    Serial.println("Card init.")

    //Init pinmodes here
}

void loop(){

    //Blank string for writing with
    String dataS = "";
    /*
    Record data here
    */

   //Make file available
   File outFile = SD.open("log.txt", FILE_WRITE);
    /*

    Check how to output to csv assuming similar method

    */

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
}