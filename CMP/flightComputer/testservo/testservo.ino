// Test servo movement

//Pull in servo lib
#include <Servo.h>

Servo servo1; //declare servo objects to work with
Servo servo2;

int servopos1 = 0; // Store servo pos
int servopos2 = 0;


void setup() {
  servo1.attach(10);
  servo2.attach(9);
  
}


void loop() {

  for (servopos1 = 0; servopos1 <=180; servopos1 +=1){
    servo1.write(servopos1);
    delay(15);
  }

  for (servopos2 = 0; servopos2 <=180; servopos2 +=1){
    servo2.write(servopos2);
    delay(15);
  }

}


void moveservo1() {

  
}


void moveservo2() {
  
}
