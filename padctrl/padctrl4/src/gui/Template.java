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
    
    private JLabel placeholderLabel;
    private JButton placeholderButton;
    private JButton returnButton;
    private JButton exitButton;
    private JPanel placeholderPanel;
    private JPanel buttonPanel;
    
    public Template(){

        //Formatting
        
        super("Template");
        this.setBounds(100,50,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());

        //Constructing and formatting placeholderLabel
        
        placeholderLabel = new JLabel ("placeholder",SwingConstants.CENTER);
        placeholderLabel.setFont(DEFAULT_FONT);
        placeholderLabel.setForeground(Color.WHITE);
        
        //Constructing buttons
        
        placeholderButton = new JButton("placeholder");
        returnButton = new JButton("Return");
        exitButton = new JButton("Exit Application");
        placeholderButton.addActionListener(this);
        returnButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        //Constructing placeholderPanel
        
        placeholderPanel = new JPanel(new BorderLayout());
        placeholderPanel.setBackground(BACKGROUND_COLOR);
        
        placeholderPanel.add(placeholderLabel,BorderLayout.NORTH);
        
        //Constructing buttonPanel
        
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        buttonPanel.add(placeholderButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(exitButton);
        
        //Adding to frame
        
        this.add(placeholderPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Template testObject = new Template();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("placeholder")) {
            
        }
        else if (command.equals("Return")) {
            
            this.dispose();
        }
        else if (command.equals("Exit Application")) {
            
            System.exit(0);
        }
    }
}
