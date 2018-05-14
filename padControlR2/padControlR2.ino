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

void setup() {

  pinMode(abortPin, INPUT);
  pinMode(launchPin, OUTPUT);
  #ifndef __AVR_ATtiny85__
  Serial.begin(9600);
  Serial.println("PadControl Revision 2");
  #endif
  matrix.begin(0x70);
  

}

void loop() {
 

if(countdownState == 0){
  
  if(time == 1){
    countdownState = 1;
  }
  
  matrix.println(time - 1);
  time = time - 1;
  
  }
 else if(countdownState == 1){

  matrix.print(time + 1);
  time = time + 1;
  if(launchState == 0){
    
    launchState = 1;
    digitalWrite(HIGH, launchPin);
  }
  
 }
 else{

  matrix.println(8888);
 
 }

matrix.writeDisplay();
if(abortLoopState != 9){
  
  abortLoopState = abortLoopState + 1;
    Serial.println(abortLoopState);
    
  delay(100);
  
if(digitalRead(abortPin) == HIGH){
  
   abortState = true;
   Serial.println("ABORT DETECTED");
   matrix.println(9999);
   exit;
   
    }
  }
 

}
