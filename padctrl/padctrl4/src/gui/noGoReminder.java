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
    private JPanel boosterPanel = new JPanel(new BorderLayout());
    private JPanel guidancePanel = new JPanel(new BorderLayout());
    private JPanel rangePanel = new JPanel(new BorderLayout());
    private JPanel flightPanel = new JPanel(new BorderLayout());
    private JPanel compositePanel = new JPanel((new FlowLayout()));

    private JLabel boosterNoLabel = new JLabel("Booster No");
    private JLabel guidanceNoLabel = new JLabel("Guidance No");
    private JLabel rangeNoLabel = new JLabel("Range No");
    private JLabel flightNoLabel = new JLabel("Flight No");


    public noGoReminder(){

        //Formatting
        this.setTitle("No Go Reminder");
        this.setBounds(500,400,500,160);

        //Booster Panel
        boosterPanel.add(boosterNoLabel, BorderLayout.EAST);
        boosterPanel.setBackground(NO_GO_COLOR);

        //Guidance Panel
        guidancePanel.add(guidanceNoLabel, BorderLayout.EAST);
        guidancePanel.setBackground(NO_GO_COLOR);

        //Range Panel
        rangePanel.add(rangeNoLabel, BorderLayout.EAST);
        rangePanel.setBackground(NO_GO_COLOR);

        //Flight Panel
        flightPanel.add(flightNoLabel, BorderLayout.EAST);
        flightPanel.setBackground(NO_GO_COLOR);

        //Composite Panel
        compositePanel.add(boosterPanel);
        compositePanel.add(guidancePanel);
        compositePanel.add(rangePanel);
        compositePanel.add(flightPanel);
        compositePanel.setBackground(BACKGROUND_COLOR);

        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(returnButton);

        //Modifying button panel
        buttonPanel.remove(navigationButtonPanel);
        buttonPanel.add(navigationButtonPanel, BorderLayout.CENTER);

        //Adding to frame and setting visible
        this.add(compositePanel);

        this.setVisible(true);
    }

    //Testing Only
    public static void main(String[] args) {
        noGoReminder ngr = new noGoReminder();

    }

    /*@Override
    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();

        if(command.equals("Exit Application")){
            this.dispose();
        }
    }*/
}
