package backend;
/*
Written by Henry G for VAR
TimerTask to be called from TimerFrame
 */
import java.util.TimerTask;
import java.util.Timer;

public class ThreadTimer extends TimerTask {

    //Declare counter to count down from
    private static int counter;

    public ThreadTimer(int timerStartValue){

        counter = timerStartValue;
        Timer timer = new Timer("Countdown Timer");
        timer.scheduleAtFixedRate(new ThreadTimer(counter), 0, 1000);
    }

//    //Testing only
//    public static void main(String[] args){
//      ThreadTimer t = new ThreadTimer(10);
//
//    }

    @Override
    public void run(){
        if(counter <= 0){
            System.out.println("Timer is at: " + counter);
            counter++;
        }
        if(counter > 0){
            System.out.println("Timer is at: " + counter);
            counter --;
        }
    }

    public int getCounter(){
        return counter;
    }
}
