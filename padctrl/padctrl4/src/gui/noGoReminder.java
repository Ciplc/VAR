package gui;
/*
Written by Henry G for var padctrl 5/1/2019
NoGo reminder for status of various depots
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class noGoReminder extends Template implements ActionListener {

    //Declaring Objects
    private JPanel boosterPanel = new JPanel(new BorderLayout());
    private JPanel guidancePanel = new JPanel(new BorderLayout());
    private JPanel rangePanel = new JPanel(new BorderLayout());
    private JPanel flightPanel = new JPanel(new BorderLayout());

    public noGoReminder(){

        //Formatting
        this.setTitle("No Go Reminder");
        this.setBounds(500,400,500,160);

        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(returnButton);

        //Modifying button panel
        buttonPanel.remove(navigationButtonPanel);
        buttonPanel.add(navigationButtonPanel, BorderLayout.CENTER);
    }

    //Testing Only
    public static void main(String[] args) {
        noGoReminder ngr = new noGoReminder();

    }
}
