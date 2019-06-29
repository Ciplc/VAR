/*
Written by An T for VAR padctrl 4/15/2019
Class for the welcome frame of Pad Control application
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends Template implements ActionListener {
    
    //Constants
    
    private final java.net.URL LOGO_IMAGE = getClass().getResource("VAR.png");
    private final ImageIcon VAR_LOGO = new ImageIcon(new ImageIcon(LOGO_IMAGE).getImage(
        ).getScaledInstance(223,224,Image.SCALE_DEFAULT));

    //Object declaration
    
    private JLabel welcomeLabel;
    private JLabel instructionLabel;
    private JLabel instructionContLabel;
    private JLabel imageLabel;
    
    //Constructor
    
    public Welcome() {
        
        //Formatting frame
        
        this.setTitle("VAR Pad Controller");
        this.setBounds(100,50,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //Formatting and constructing welcomeLabel
        
        welcomeLabel = new JLabel("Welcome to the VAR Pad Controller!"
                ,SwingConstants.CENTER);
        welcomeLabel.setFont(DEFAULT_FONT);
        welcomeLabel.setForeground(Color.WHITE);
        
        //Formatting and constructing instructionLabel
        
        instructionLabel = new JLabel("To begin initial launch procedures, "
                + "please press the next",SwingConstants.CENTER);
        instructionLabel.setFont(DEFAULT_FONT);
        instructionLabel.setForeground(Color.WHITE);
        
        //Formatting and constructing instructionContLabel
        
        instructionContLabel = new JLabel("button found on the bottom "
                + "right.",SwingConstants.CENTER);
        instructionContLabel.setFont(DEFAULT_FONT);
        instructionContLabel.setForeground(Color.WHITE);
        
        //Constructing imageLabel
        
        imageLabel = new JLabel(VAR_LOGO);
        imageLabel.setBackground(BACKGROUND_COLOR);
        
        //Adding to textPanel
        
        textPanel.add(welcomeLabel,BorderLayout.NORTH);
        textPanel.add(instructionLabel,BorderLayout.CENTER);
        textPanel.add(instructionContLabel,BorderLayout.SOUTH);
        
        //Add to frame
        
        this.add(textPanel,BorderLayout.NORTH);
        this.add(imageLabel,BorderLayout.CENTER);
        
        //Remove from buttonPanel
        
        navigationButtonPanel.remove(returnButton);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Welcome welcomeObject = new Welcome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("Next")) {
            
            Input inputFrame = new Input();
            this.dispose();
        }
        else if (command.equals("Exit Application")) {
            
            System.exit(0);
        }
    }
    
}
