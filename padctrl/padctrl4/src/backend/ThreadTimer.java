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
    public int counter = 3;
    private boolean downState = true;

    //Testing Only
    public static void main(String [] args) {
        Timer timer = new Timer("MyTimer");
        timer.scheduleAtFixedRate(new ThreadTimer(), 0, 1000);
    }

    @Override
    public void run() {

        if(counter >= 1 && !downState){
            System.out.println("Timer is at: " + counter);
            counter++;
        }
        
        if(counter > 0 && downState){
            System.out.println("Timer is at: " + counter);
            counter --;
        }else if(counter == 0) {
            System.out.println("Timer is at: " + counter);
            downState = false;
            counter ++;
        }

    }

    public void startTimer(){
        Timer timer = new Timer("Countdown Timer");
        timer.scheduleAtFixedRate(new ThreadTimer(), 0, 1000);
    }

    public int getState(){
        return counter;
    }
}
