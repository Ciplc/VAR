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

public class Poll extends JFrame implements ActionListener {

    //Style Consts
    private final Color BACKGROUND_COLOR = new Color(0,200,0);
    private final Font DEFAULT_FONT = new Font("Calibri",Font.PLAIN,20);


    //Declaration of buttons for poll
    private JButton payloadButton = new JButton("Payload Ready?");
    private JButton recoveryButton = new JButton("Recovery Ready?");
    private JButton motorButton = new JButton("Motor Ready?");

    private JPanel buttonPanel;

    public Poll(){

        //Formatting
        super("Launch Poll");
        this.setBounds(100,50,900,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(BACKGROUND_COLOR);
        this.setLayout(new GridBagLayout());

        //Adding Action Listeners
        payloadButton.addActionListener(this);
        recoveryButton.addActionListener(this);
        motorButton.addActionListener(this);

    }

    public static void main(String[] Arg){

    }

    @Override
    public void actionPerformed(ActionEvent e){

        
    }
}
