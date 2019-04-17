package gui;
/*
Written by Henry G and An T for VAR padctrl 4/16/2019
Template frame, nothing to see here move along
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Template extends JFrame implements ActionListener {

    //Constants

    public final Color BACKGROUND_COLOR = new Color(95,95,95);
    public final Font DEFAULT_FONT = new Font("Trebuchet MS",Font.PLAIN,20);

    //Declarations
    
    public JButton nextButton;
    public JButton returnButton;
    public JButton exitButton;
    public JPanel textPanel;
    public JPanel navigationButtonPanel;
    public JPanel buttonPanel;
    
    public Template() {

        //Formatting
        
        super("Template");
        this.setBounds(100,50,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        
        //Constructing buttons
        
        nextButton = new JButton("Next");
        returnButton = new JButton("Return");
        exitButton = new JButton("Exit Application");
        returnButton.addActionListener(this);
        exitButton.addActionListener(this);
        nextButton.addActionListener(this);
        
        //Constructing textPanel
        
        textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(BACKGROUND_COLOR);
        
        //Constructing navigationButtonPanel
        
        navigationButtonPanel = new JPanel(new FlowLayout());
        navigationButtonPanel.setBackground(BACKGROUND_COLOR);
        
        navigationButtonPanel.add(nextButton);
        navigationButtonPanel.add(returnButton);
        navigationButtonPanel.add(exitButton);
        
        //Constructing buttonPanel
        
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        buttonPanel.add(navigationButtonPanel,BorderLayout.EAST);
        
        //Adding to frame
        
        this.add(textPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    //For testing purposes only
    
//    public static void main(String[] args) {
//        
//        Template testObject = new Template();
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("Next")) {
            
        }
        else if (command.equals("Return")) {
            
            this.dispose();
        }
        else if (command.equals("Exit Application")) {
            
            System.exit(0);
        }
    }
}
