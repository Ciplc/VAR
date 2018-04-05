#include <SevSeg.h>

int ledPin = 13;
int abortButton = 2;
int abortState = 0;

void setup() {
  // put your setup code here, to run once:

  pinMode(ledPin, OUTPUT);
  pinMode(abortButton, INPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  abortState = digitalRead(abortButton);

  if (abortState == HIGH) {

    digitalWrite(ledPin, HIGH)
    
  } else {}

  
}
