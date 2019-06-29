package gui;
/*
Written by Henry G for VAR pad 5/4/2019
Frame which counts down time given by input and also counts up time after the fact
 */

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerFrame {

    public static void main(String[] args) {
        new TimerFrame();
    }

    public TimerFrame() {
        EventQueue.invokeLater(new Runnable() { //Invoke the timer as a runnable
            @Override
            public void run() {

                // Setup the frame and repack it
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    // Creates a JPanel to add the timer stuff too, add a button for holding in here
    public class TestPane extends JPanel {

        // Declare timer obj and set the start time and duration, make duration variable to UI
        private Timer timer;
        private long startTime = -1;
        private long duration = 50000;
        private JLabel label;

        // Constructor for the Panel
        public TestPane() {
            setLayout(new GridBagLayout());


            // This timer works by setting the system time to a var then tracking time since it set that time then
            // Subtracting it from the start sys time to get the current time
            timer = new Timer(10, new ActionListener() { // Set timer method to obj and
                @Override                                        // and override the actionPerformed
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {                         // if start time is less than 0 set the start time to
                        startTime = System.currentTimeMillis();  // the current sys time in MS
                    }
                    long now = System.currentTimeMillis();       // The current sys time
                    long clockTime = now - startTime;            // The time on the clock
                    if (clockTime >= duration) {                 // If clock time passes duration stop the timer
                        clockTime = duration;
                        timer.stop();
                    }

                    SimpleDateFormat df = new SimpleDateFormat("mm:ss");    // Format the output in Min:Sec
                    label.setText(df.format(duration - clockTime));             // Set the label to current time
                }
            });
            timer.setInitialDelay(0);                            // Set the delay on the timer
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!timer.isRunning()) {                    // If the timer is not running start it
                        startTime = -1;
                        timer.start();
                    }
                }
            });
            label = new JLabel("Click on start.");       // Setup initial label
            add(label);
        }
    }
}