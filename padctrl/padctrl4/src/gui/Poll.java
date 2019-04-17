package gui;
/*
Written by An T and Henry G for VAR padctrl 4/16/2019
Poll frame for padctrl, will poll user for status of various depts.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Poll extends Template implements ActionListener {

    //Constants
    
    private final Font BUTTON_FONT = new Font("Trebuchet MS",Font.PLAIN,15);
    
    //Declaration of labels
    
    private JLabel boosterLabel = new JLabel("Boosters Engineer: ", 
            SwingConstants.RIGHT);
    private JLabel guidanceLabel = new JLabel("Guidance Engineer: ", 
            SwingConstants.RIGHT);
    private JLabel rangeLabel = new JLabel("Range Safety: ",
            SwingConstants.RIGHT);
    private JLabel flightLabel = new JLabel("Flight: ",
            SwingConstants.RIGHT);

    //Declaration of radio buttons for polling
    
    private JRadioButton awaitingBoosterButton = new JRadioButton("AWAITING STATUS");
    private JRadioButton goBoosterButton = new JRadioButton("GO");
    private JRadioButton noGoBoosterButton = new JRadioButton("NO GO");
    private JRadioButton awaitingGuidanceButton = new JRadioButton("AWAITING STATUS");
    private JRadioButton goGuidanceButton = new JRadioButton("GO");
    private JRadioButton noGoGuidanceButton = new JRadioButton("NO GO");
    private JRadioButton awaitingRangeButton = new JRadioButton("AWAITING STATUS");
    private JRadioButton goRangeButton = new JRadioButton("GO");
    private JRadioButton noGoRangeButton = new JRadioButton("NO GO");
    private JRadioButton awaitingFlightButton = new JRadioButton("AWAITING STATUS");
    private JRadioButton goFlightButton = new JRadioButton("GO");
    private JRadioButton noGoFlightButton = new JRadioButton("NO GO");
    private ButtonGroup pollingBoosterGroup = new ButtonGroup();
    private ButtonGroup pollingGuidanceGroup = new ButtonGroup();
    private ButtonGroup pollingRangeGroup = new ButtonGroup();
    private ButtonGroup pollingFlightGroup = new ButtonGroup();
    
    //Declaration of buttons
    
    private JButton proceedButton = new JButton("Proceed with the Countdown");
    
    //Declaration of panels
    
    private JPanel boosterPanel = new JPanel(new BorderLayout());
    private JPanel guidancePanel = new JPanel(new BorderLayout());
    private JPanel rangeSafetyPanel = new JPanel(new BorderLayout());
    private JPanel flightDirectorPanel = new JPanel(new BorderLayout());
    private JPanel pollingBoosterPanel = new JPanel(new BorderLayout());
    private JPanel pollingGuidancePanel = new JPanel(new BorderLayout());
    private JPanel cmpPanel = new JPanel(new BorderLayout());
    private JPanel standardPanel = new JPanel(new BorderLayout());
    
    
    public Poll() {

        //Setting Title
        
        this.setTitle("Launch Poll");
        
        //Formatting labels
        
        boosterLabel.setFont(DEFAULT_FONT);
        guidanceLabel.setFont(DEFAULT_FONT);
        rangeLabel.setFont(DEFAULT_FONT);
        boosterLabel.setForeground(Color.WHITE);
        guidanceLabel.setForeground(Color.WHITE);
        rangeLabel.setForeground(Color.WHITE);      
        
        //Formatting buttons
            
        awaitingBoosterButton.setFont(BUTTON_FONT);
        goBoosterButton.setFont(BUTTON_FONT); 
        noGoBoosterButton.setFont(BUTTON_FONT); 
        
        awaitingGuidanceButton.setFont(BUTTON_FONT);
        goGuidanceButton.setFont(BUTTON_FONT); 
        noGoGuidanceButton.setFont(BUTTON_FONT); 
        
        awaitingRangeButton.setFont(BUTTON_FONT);
        goRangeButton.setFont(BUTTON_FONT); 
        noGoRangeButton.setFont(BUTTON_FONT); 
        
        awaitingFlightButton.setFont(BUTTON_FONT);
        goFlightButton.setFont(BUTTON_FONT); 
        noGoFlightButton.setFont(BUTTON_FONT); 
        
        awaitingBoosterButton.setForeground(Color.WHITE);
        goBoosterButton.setForeground(Color.WHITE); 
        noGoBoosterButton.setForeground(Color.WHITE);     
        
        //Adding to pollingGroup
        
        pollingBoosterGroup.add(awaitingBoosterButton);
        pollingBoosterGroup.add(goBoosterButton);
        pollingBoosterGroup.add(noGoBoosterButton);
        
        //Formatting and Adding to pollingBoosterPanel
        
        pollingBoosterPanel.setBackground(BACKGROUND_COLOR);
        
        pollingBoosterPanel.add(awaitingBoosterButton,BorderLayout.WEST);
        pollingBoosterPanel.add(goBoosterButton,BorderLayout.CENTER);
        pollingBoosterPanel.add(noGoBoosterButton,BorderLayout.EAST);
        
        //Formatting and Adding to boosterPanel
        
        boosterPanel.setBackground(BACKGROUND_COLOR);
        
        boosterPanel.add(boosterLabel,BorderLayout.WEST);
        boosterPanel.add(pollingBoosterPanel,BorderLayout.EAST);
        
        //Formatting and Adding to standardPanel
        
        standardPanel.setBackground(BACKGROUND_COLOR);
        
        standardPanel.add(boosterPanel,BorderLayout.NORTH);
        
        //Adding to frame
        
        this.add(standardPanel,BorderLayout.CENTER);
        
        this.setVisible(true);

    }

    //For testing purposes only
    
    public static void main(String[] args) {
        
        Poll testObject = new Poll();
    }

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
