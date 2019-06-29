package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class TimerPanel extends JPanel{

    private Timer timer;
    private long startTime = -1;
    private long totalTime = 500;

    private JLabel label1;

    public TimerPanel(){
        setLayout(new BorderLayout());
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(startTime < 0){
                    startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long clockTime = now - startTime;
                if(clockTime >= totalTime){
                    clockTime = totalTime;
                    timer.stop();
                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss");
                label1.setText(df.format(totalTime - clockTime));
            }
        });
        timer.setInitialDelay(0);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!timer.isRunning()){
                    startTime = -1;
                    timer.start();
                }
            }
        });
        label1 = new JLabel("...");
        add(label1);
    }
}
