package backend;
/*
Written by Henry G for VAR
TimerTask to be called from TimerFrame
 */
import java.util.TimerTask;
import java.util.Timer;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadTimer extends TimerTask{
    static int counter = 3;
    boolean downState = true;
    public static void main(String [] args) {
        Timer timer = new Timer("MyTimer");
        timer.scheduleAtFixedRate(new ThreadTimer(), 0, 1000);
    }

    @Override
    public void run() {

        if(counter > 0 && downState){
            System.out.println("Timer is at: " + counter);
            counter --;
        }else if(counter == 0) {
            System.out.println("Timer is at: " + counter);
            downState = false;
            counter ++;
        }
        if(counter < 0){
                System.out.println("Timer is at: " + counter);
                counter++;
            }

    }

    public int getState(){
        return counter;
    }
}
