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

        state.setText(String.valueOf(t.getState()));
        System.out.println(t.getState());
        this.validate();
        this.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();

        if(command.equals("Start Timer")){

            ThreadTimer t = new ThreadTimer();
            state.setText(String.valueOf(t.getState()));
            System.out.println(t.getState());
        }

        this.validate();
        this.repaint();
    }
}
