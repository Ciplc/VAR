#include <Wire.h>
#include <Adafruit_GFX.h>
#include "Adafruit_LEDBackpack.h"

Adafruit_7segment matrix = Adafruit_7segment();
int time = 120;
int countdownState = 0;

void setup() {
  // put your setup code here, to run once:
  #ifndef __AVR_ATtiny85__
  Serial.begin(9600);
  Serial.println("PadControl Revision 2");
  #endif
  matrix.begin(0x70);
  

}

void loop() {
  // put your main code here, to run repeatedly:

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
  
 }
 else{

  matrix.println(9999);
 
 }

matrix.writeDisplay();
delay(1000);


}
