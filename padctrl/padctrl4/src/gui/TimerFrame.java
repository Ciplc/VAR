package gui;
/*
Frame which counts down time given by input and also counts up time after the fact
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.ThreadTimer;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

public class TimerFrame extends Template implements ActionListener {

    //Declaring Counter
    static int counter = 10;

    private JButton start = new JButton("Start TImer");
    private JLabel state = new JLabel(String.valueOf(counter));
    private JPanel testPanel = new JPanel(new BorderLayout());

    //Setup frame
    public TimerFrame(){

        testPanel.add(start, BorderLayout.SOUTH);
        testPanel.add(state, BorderLayout.NORTH);

        this.add(testPanel);
        this.setVisible(true);
    }

    //Testing only
    public static void main(String[] args){

        TimerFrame tf = new TimerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();
        ThreadTimer t = new ThreadTimer();

        if(command.equals("Start Timer")){
            //ThreadTimer t = new ThreadTimer(10);

            //Making a new TimerTask
//            TimerTask timerTask = new TimerTask() {
//
//                @Override
//                public void run() {
//                    if(counter <= 0){
//                        System.out.println("Timer is at: " + counter);
//                        counter++;
//                    }
//                    if(counter > 0){
//                        System.out.println("Timer is at: " + counter);
//                        counter --;
//                    }
//                }
//            }; //End of the TimerTask declaration

//            Timer timer = new Timer("Countdown Timer");
//            timer.scheduleAtFixedRate(timerTask, 0,1000);
            state.setText(String.valueOf(t.getState()));
        }

        this.validate();
        this.repaint();
    }
}
