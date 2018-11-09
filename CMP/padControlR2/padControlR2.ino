#include <Wire.h>
#include <Adafruit_GFX.h>
#include "Adafruit_LEDBackpack.h"

Adafruit_7segment matrix = Adafruit_7segment();
int time = 120;
int countdownState = 0;
int launchPin = 7;
int launchState = 0;
bool abortState = false;
int abortPin = 8;
int abortLoopState = 0;
int startPin = 9;
bool startState = false;
void setup() {

  pinMode(abortPin, INPUT);
  pinMode(launchPin, OUTPUT);
  #ifndef __AVR_ATtiny85__
  Serial.begin(9600);
  Serial.println("PadControl Revision 2");
  #endif
  matrix.begin(0x70);
  

}
//Looping code
void loop() {

  matrix.print(0000);

//if button is pressed and poll is TRUE
if(digitalRead(startPin) == HIGH || startState == true){

  startState == true;
  
if(countdownState == 0){

  //Countdown 1 second each loop
  if(time == 1){
    countdownState = 1;
  }

  //Display time then --time
  matrix.println(time - 1);
  time = time - 1;
  
  }
 else if(countdownState == 1){

  //After time has gone passed 0 count uptime.
  matrix.print(time + 1);
  time = time + 1;

  //If first time around, power --> PAD
  if(launchState == 0){
    
    launchState = 1;
    digitalWrite(launchPin, HIGH);
  }
  
 }
 else{

  //General Error code
  matrix.print(8888);
 
 }

//Output to display
matrix.writeDisplay();


//Honestly don't remember what this does but it works so leave it for now.
if(abortLoopState != 9){

  
  abortLoopState = abortLoopState + 1;
  Serial.println(abortLoopState);

  //Delay 1 second in ms
  delay(100);

//Abort immediately 
if(digitalRead(abortPin) == HIGH){
  
   abortState = true;
   Serial.println("ABORT DETECTED");
   matrix.println(9999);
   exit;
   
    }
   }
  }
}
