package gui;
/*
Written by Henry G and An T for var padctrl 5/2/2019
NoGo reminder for status of various depots
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NoGoWarning extends Template implements ActionListener {


    //Constants
    private final Color NO_GO_COLOR = new Color(255,0,0);

    //Declaring Objects
    private JPanel textPanel = new JPanel(new BorderLayout());
    private JLabel warningLabel = new JLabel("ALL POSITIONS ARE NOT GO FOR "
            + "LAUNCH!",SwingConstants.CENTER);

    public NoGoWarning(){

        //Formatting
        this.setTitle("No Go Reminder");
        this.setBounds(500,400,500,160);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Formatting labels
        warningLabel.setFont(WARNING_FONT);
        warningLabel.setForeground(Color.WHITE);

        //Formatting textPanel
        textPanel.add(warningLabel, BorderLayout.CENTER);
        textPanel.setBackground(NO_GO_COLOR);

        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(exitButton);
        navigationButtonPanel.setBackground(NO_GO_COLOR);

        //Modifying button panel
        buttonPanel.remove(navigationButtonPanel);
        buttonPanel.add(navigationButtonPanel, BorderLayout.CENTER);

        //Adding to frame and setting visible
        this.add(textPanel);

        this.setVisible(true);
    }

    //Testing Only
    public static void main(String[] args) {
        NoGoWarning ngw = new NoGoWarning();

    }

    /*@Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("Exit Application")){
            this.dispose();
        }
    }*/
}
