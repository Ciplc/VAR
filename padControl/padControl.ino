#include <SevSeg.h>
SevSeg sevseg; //Display Controller

//Pin Variables
int abortButton = A0;
int ledPin = 13;

//Variables
int abortState;
int ignitionTimer = 120;
void setup() {
  // put your setup code here, to run once:

}

void loop() {

 delay(1000);
 ignitionTimer = ignitionTimer -1;
 
 abortState = digitalRead(abortButton);

 if(abortState == HIGH){

  digitalWrite(ledPin, HIGH);
  //Write to single display with error code.
  abort();
  
 }
}
