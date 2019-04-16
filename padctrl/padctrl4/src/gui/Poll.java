package gui;
/*
Written by An T and Henry G for VAR padctrl
Poll frame for padctrl, will poll user for status of various depts.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import backend.poll;

public class Poll extends Template implements ActionListener {

    //Declaration of buttons for poll
    private JButton payloadButton = new JButton("Payload Ready?");
    private JButton recoveryButton = new JButton("Recovery Ready?");
    private JButton motorButton = new JButton("Motor Ready?");

    private JPanel buttonPanel;

    public Poll(){

        //Setting Title
        this.setTitle("Launch Poll");

        //Adding Action Listeners
        payloadButton.addActionListener(this);
        recoveryButton.addActionListener(this);
        motorButton.addActionListener(this);

    }

    public static void main(String[] args){

    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
