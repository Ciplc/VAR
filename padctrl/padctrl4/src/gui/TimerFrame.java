package gui;
/*
Written by Henry G for VAR pad 5/4/2019
Frame which counts down time given by input and also counts up time after the fact
 */
/*
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
    boolean counting = false;
    private JButton start = new JButton("Start Timer");
    private JLabel state = new JLabel(String.valueOf(counter));
    private JPanel testPanel = new JPanel(new BorderLayout());

    //Setup frame
    public TimerFrame(){

        testPanel.add(start, BorderLayout.SOUTH);
        testPanel.add(state, BorderLayout.NORTH);
        start.addActionListener(this);
        this.add(testPanel);
        this.setVisible(true);
    }

    //Testing only
    public static void main(String[] args){

        TimerFrame tf = new TimerFrame();
    }

    public void refreshLabel(ThreadTimer t){

        while(counting){
            state.setText(String.valueOf(t.getState()));
            System.out.println(t.getState());
            this.validate();
            this.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();

        if(command.equals("Start Timer")){

            ThreadTimer t = new ThreadTimer();
            t.startTimer();
            counting = true;
            //refreshLabel(t);

            while(counting){
                state.setText(String.valueOf(t.getState()));
                System.out.println(t.getState());
                this.validate();
                this.repaint();
            }
        }
        if(command.equals("Exit Application")){
            System.exit(0);
        }

        this.validate();
        this.repaint();
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class TimerFrame extends Template implements ActionListener {
/*
    double timeLeft=5000;
    ActionListener countDown=new ActionListener() {
        public void actionPerformed(ActionEvent e){

            timeLeft--;
            SimpleDateFormat df=new SimpleDateFormat("mm:ss");
            timeLabel.setText(df.format(timeLeft));
            System.out.println(timeLeft);
            if(timeLeft<=0){
                timer.stop();
            }
        }
    }; //End ActionLister decleration
    Timer timer=new Timer(1, countDown);

    private JLabel timeLabel = new JLabel();
    private JPanel testPanel = new JPanel(new BorderLayout());
*/
    private TimerPanel tp = new TimerPanel();

    public TimerFrame(){

        this.add(tp);
        this.setVisible(true);

    }


    public static void main(String[] args){
        TimerFrame tf = new TimerFrame();
    }
}
