package gui;
/*
Written by Henry G for var padctrl 5/1/2019
NoGo reminder for status of various depots
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class noGoReminder extends Template implements ActionListener {

    //Constants
    
    private final Color NO_GO_COLOR = new Color(255,0,0);
    
    //Declaring Objects
    private JLabel textLabel = new JLabel("All positions are NOT go "
            + "for launch.",SwingConstants.CENTER);
    private JPanel textPanel = new JPanel(new BorderLayout());

    public noGoReminder(){

        //Formatting
        this.setTitle("No Go Reminder");
        this.setBounds(500,400,500,160);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(NO_GO_COLOR);
        
        //Formatting textLabel
        textLabel.setFont(WARNING_FONT);
        textLabel.setForeground(Color.WHITE);
        
        //Formatting and adding to notificationPanel
        textPanel.setBackground(NO_GO_COLOR);
        textPanel.add(textLabel,BorderLayout.CENTER);
        
        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(exitButton);
        navigationButtonPanel.setBackground(NO_GO_COLOR);

        //Modifying button panel
        buttonPanel.remove(navigationButtonPanel);
        buttonPanel.add(navigationButtonPanel, BorderLayout.CENTER);
        buttonPanel.setBackground(NO_GO_COLOR);
        
        //Adding to frame
        this.add(textPanel,BorderLayout.CENTER);
    }

    //Testing Only
    public static void main(String[] args) {
        noGoReminder ngr = new noGoReminder();

    }
}
