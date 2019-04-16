/*
Written by An T for VAR padctrl 4/15/2019
Class for the welcome frame of Pad Control application
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener {
    
    //Constants
    
    private final Color BACKGROUND_COLOR = new Color(95,95,95);
    private final Font DEFAULT_FONT = new Font("Trebuchet MS",Font.PLAIN|Font.BOLD,20);
    private final java.net.URL LOGO_IMAGE = getClass().getResource("VAR.png");
    private final ImageIcon VAR_LOGO = new ImageIcon(new ImageIcon(LOGO_IMAGE).getImage(
        ).getScaledInstance(223,224,Image.SCALE_DEFAULT));

    //Object declaration
    
    private JLabel welcomeLabel;
    private JLabel instructionLabel;
    private JLabel instructionContLabel;
    private JLabel imageLabel;
    private JButton loginButton;
    private JButton exitButton;
    private JPanel descriptionPanel;
    private JPanel buttonPanel;
    
    //Constructor
    
    public Welcome() {
        
        //Formatting frame
        
        super("VAR Pad Controller");
        this.setBounds(100,50,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //Formatting and constructing welcomeLabel
        
        welcomeLabel = new JLabel("Welcome to the VAR Pad Controller!",SwingConstants.CENTER);
        welcomeLabel.setFont(DEFAULT_FONT);
        welcomeLabel.setForeground(Color.WHITE);
        
        //Formatting and constructing instructionLabel
        
        instructionLabel = new JLabel("To begin initial launch procedures, please enter your",SwingConstants.CENTER);
        instructionLabel.setFont(DEFAULT_FONT);
        instructionLabel.setForeground(Color.WHITE);
        
        //Formatting and constructing instructionContLabel
        
        instructionContLabel = new JLabel("credentials in the next frame by pressing the 'Login' button.",SwingConstants.CENTER);
        instructionContLabel.setFont(DEFAULT_FONT);
        instructionContLabel.setForeground(Color.WHITE);
        
        //Constructing imageLabel
        
        imageLabel = new JLabel(VAR_LOGO);
        imageLabel.setBackground(BACKGROUND_COLOR);
        
        //Constructing buttons
        
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit Application");
        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        //Constructing and formatting descriptionPanel
        
        descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(BACKGROUND_COLOR);
        
        descriptionPanel.add(welcomeLabel,BorderLayout.NORTH);
        descriptionPanel.add(instructionLabel,BorderLayout.CENTER);
        descriptionPanel.add(instructionContLabel,BorderLayout.SOUTH);
        
        //Constructing and formatting buttonPanel
        
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);
        
        //Add to frame
        
        this.add(descriptionPanel,BorderLayout.NORTH);
        this.add(imageLabel,BorderLayout.CENTER);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Welcome welcomeObject = new Welcome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("Login")) {
            
        }   
        else if (command.equals("Exit Application")) {
            
            System.exit(0);
        }    
    }
    
}
