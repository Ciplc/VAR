package gui;
/*
Written by An T and Henry G for VAR padctrl 4/18/2019
Poll frame for padctrl, will poll user for status of various depts.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Poll extends Template implements ActionListener {

    //Constants
    
    private final Font BUTTON_FONT = new Font("Trebuchet MS",Font.PLAIN,15);
    private final Color GO_COLOR = new Color(0,155,0);
    private final Color NO_GO_COLOR = new Color(255,0,0);
    
    //Declaration of labels
    
    private JLabel boosterLabel = new JLabel("Boosters Engineer: ", 
            SwingConstants.RIGHT);
    private JLabel guidanceLabel = new JLabel("Guidance Engineer: ", 
            SwingConstants.RIGHT);
    private JLabel rangeLabel = new JLabel("Range Safety Officer: ",
            SwingConstants.RIGHT);
    private JLabel flightLabel = new JLabel("Flight Director: ",
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
    
    private JButton enterButton = new JButton("Enter Status");
    private JButton proceedButton = new JButton("Proceed with the Countdown");
    
    //Declaration of panels
    
    private JPanel boosterPanel = new JPanel(new BorderLayout());
    private JPanel guidancePanel = new JPanel(new BorderLayout());
    private JPanel rangePanel = new JPanel(new BorderLayout());
    private JPanel flightPanel = new JPanel(new BorderLayout());
    private JPanel pollingBoosterPanel = new JPanel(new BorderLayout());
    private JPanel pollingGuidancePanel = new JPanel(new BorderLayout());
    private JPanel pollingRangePanel = new JPanel(new BorderLayout());
    private JPanel pollingFlightPanel = new JPanel(new BorderLayout());
    private JPanel cmpPanel = new JPanel(new BorderLayout());
    private JPanel standardPanel = new JPanel(new BorderLayout());
    
    
    public Poll() {

        //Formatting frame
        
        this.setTitle("Launch Poll");
        this.setBounds(100,50,700,160);
        
        //Adding actionlistener to buttons
        
        enterButton.addActionListener(this);
        proceedButton.addActionListener(this);
        
        //Formatting labels
        
        boosterLabel.setFont(DEFAULT_FONT);
        guidanceLabel.setFont(DEFAULT_FONT);
        rangeLabel.setFont(DEFAULT_FONT);
        flightLabel.setFont(DEFAULT_FONT);
        boosterLabel.setForeground(Color.WHITE);
        guidanceLabel.setForeground(Color.WHITE);
        rangeLabel.setForeground(Color.WHITE);      
        flightLabel.setForeground(Color.WHITE);     
        
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
        
        awaitingGuidanceButton.setForeground(Color.WHITE);
        goGuidanceButton.setForeground(Color.WHITE); 
        noGoGuidanceButton.setForeground(Color.WHITE);
        
        awaitingRangeButton.setForeground(Color.WHITE);
        goRangeButton.setForeground(Color.WHITE); 
        noGoRangeButton.setForeground(Color.WHITE);
        
        awaitingFlightButton.setForeground(Color.WHITE);
        goFlightButton.setForeground(Color.WHITE); 
        noGoFlightButton.setForeground(Color.WHITE);
        
        //Adding to pollingGroups
        
        pollingBoosterGroup.add(awaitingBoosterButton);
        pollingBoosterGroup.add(goBoosterButton);
        pollingBoosterGroup.add(noGoBoosterButton);
        
        pollingGuidanceGroup.add(awaitingGuidanceButton);
        pollingGuidanceGroup.add(goGuidanceButton);
        pollingGuidanceGroup.add(noGoGuidanceButton);
        
        pollingRangeGroup.add(awaitingRangeButton);
        pollingRangeGroup.add(goRangeButton);
        pollingRangeGroup.add(noGoRangeButton);
        
        pollingFlightGroup.add(awaitingFlightButton);
        pollingFlightGroup.add(goFlightButton);
        pollingFlightGroup.add(noGoFlightButton);
        
        //Formatting and Adding to pollingPanels
        
        pollingBoosterPanel.setBackground(BACKGROUND_COLOR);
        pollingGuidancePanel.setBackground(BACKGROUND_COLOR);
        pollingRangePanel.setBackground(BACKGROUND_COLOR);
        pollingFlightPanel.setBackground(BACKGROUND_COLOR);
        
        pollingBoosterPanel.add(awaitingBoosterButton,BorderLayout.WEST);
        pollingBoosterPanel.add(goBoosterButton,BorderLayout.CENTER);
        pollingBoosterPanel.add(noGoBoosterButton,BorderLayout.EAST);
        
        pollingGuidancePanel.add(awaitingGuidanceButton,BorderLayout.WEST);
        pollingGuidancePanel.add(goGuidanceButton,BorderLayout.CENTER);
        pollingGuidancePanel.add(noGoGuidanceButton,BorderLayout.EAST);
        
        pollingRangePanel.add(awaitingRangeButton,BorderLayout.WEST);
        pollingRangePanel.add(goRangeButton,BorderLayout.CENTER);
        pollingRangePanel.add(noGoRangeButton,BorderLayout.EAST);
        
        pollingFlightPanel.add(awaitingFlightButton,BorderLayout.WEST);
        pollingFlightPanel.add(goFlightButton,BorderLayout.CENTER);
        pollingFlightPanel.add(noGoFlightButton,BorderLayout.EAST);
        
        //Formatting and Adding to rolePanels
        
        boosterPanel.setBackground(BACKGROUND_COLOR);
        guidancePanel.setBackground(BACKGROUND_COLOR);
        rangePanel.setBackground(BACKGROUND_COLOR);
        flightPanel.setBackground(BACKGROUND_COLOR);
        
        boosterPanel.add(boosterLabel,BorderLayout.WEST);
        boosterPanel.add(pollingBoosterPanel,BorderLayout.EAST);
        
        guidancePanel.add(guidanceLabel,BorderLayout.WEST);
        guidancePanel.add(pollingGuidancePanel,BorderLayout.EAST);
        
        rangePanel.add(rangeLabel,BorderLayout.WEST);
        rangePanel.add(pollingRangePanel,BorderLayout.EAST);
        
        flightPanel.add(flightLabel,BorderLayout.WEST);
        flightPanel.add(pollingFlightPanel,BorderLayout.EAST);
        
        //Formatting and Adding to standardPanel
        
        standardPanel.setBackground(BACKGROUND_COLOR);
        
        standardPanel.add(boosterPanel,BorderLayout.NORTH);
        standardPanel.add(rangePanel,BorderLayout.CENTER);
        standardPanel.add(flightPanel,BorderLayout.SOUTH);
        
        //Formatting and Adding to cmpPanel
        
        cmpPanel.setBackground(BACKGROUND_COLOR);
        
        cmpPanel.add(guidancePanel,BorderLayout.NORTH);
        
        //Adding and Removing from buttonPanels
        
        navigationButtonPanel.remove(nextButton);
        buttonPanel.add(enterButton,BorderLayout.WEST);
        buttonPanel.add(proceedButton,BorderLayout.CENTER);
        
        //Adding to frame
        
        this.add(cmpPanel,BorderLayout.NORTH);
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
        
        //Changes colors of frame depending on status
        
        if(command.equals("Enter Status")) {
            
            //Changes to gray if awaiting
            
            if(awaitingBoosterButton.isSelected()) {
            
            boosterPanel.setBackground(BACKGROUND_COLOR);
            pollingBoosterPanel.setBackground(BACKGROUND_COLOR);
            System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goBoosterButton.isSelected() ) {

                boosterPanel.setBackground(GO_COLOR);
                pollingBoosterPanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoBoosterButton.isSelected()) {

                boosterPanel.setBackground(NO_GO_COLOR);
                pollingBoosterPanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingGuidanceButton.isSelected()) {

                guidancePanel.setBackground(BACKGROUND_COLOR);
                pollingGuidancePanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goGuidanceButton.isSelected()) {

                guidancePanel.setBackground(GO_COLOR);
                pollingGuidancePanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoGuidanceButton.isSelected()) {

                guidancePanel.setBackground(NO_GO_COLOR);
                pollingGuidancePanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingRangeButton.isSelected()) {

                rangePanel.setBackground(BACKGROUND_COLOR);
                pollingRangePanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goRangeButton.isSelected()) {

                rangePanel.setBackground(GO_COLOR);
                pollingRangePanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoRangeButton.isSelected()) {

                rangePanel.setBackground(NO_GO_COLOR);
                pollingRangePanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingFlightButton.isSelected()) {

                flightPanel.setBackground(BACKGROUND_COLOR);
                pollingFlightPanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goFlightButton.isSelected()) {

                flightPanel.setBackground(GO_COLOR);
                pollingFlightPanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoFlightButton.isSelected()) {

                flightPanel.setBackground(NO_GO_COLOR);
                pollingFlightPanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
        }
        
        //Proceeds with countdown when pressed
        
        if(command.equals("Proceed with the Countdown")) {
            
            //Changes to gray if awaiting
            
            if(awaitingBoosterButton.isSelected()) {
            
            boosterPanel.setBackground(BACKGROUND_COLOR);
            pollingBoosterPanel.setBackground(BACKGROUND_COLOR);
            System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goBoosterButton.isSelected() ) {

                boosterPanel.setBackground(GO_COLOR);
                pollingBoosterPanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoBoosterButton.isSelected()) {

                boosterPanel.setBackground(NO_GO_COLOR);
                pollingBoosterPanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingGuidanceButton.isSelected()) {

                guidancePanel.setBackground(BACKGROUND_COLOR);
                pollingGuidancePanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goGuidanceButton.isSelected()) {

                guidancePanel.setBackground(GO_COLOR);
                pollingGuidancePanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoGuidanceButton.isSelected()) {

                guidancePanel.setBackground(NO_GO_COLOR);
                pollingGuidancePanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingRangeButton.isSelected()) {

                rangePanel.setBackground(BACKGROUND_COLOR);
                pollingRangePanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goRangeButton.isSelected()) {

                rangePanel.setBackground(GO_COLOR);
                pollingRangePanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoRangeButton.isSelected()) {

                rangePanel.setBackground(NO_GO_COLOR);
                pollingRangePanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //Changes to gray if awaiting
            
            if(awaitingFlightButton.isSelected()) {

                flightPanel.setBackground(BACKGROUND_COLOR);
                pollingFlightPanel.setBackground(BACKGROUND_COLOR);
                System.out.println("awaiting");
            }
            
            //Changes to green if go
            
            if(goFlightButton.isSelected()) {

                flightPanel.setBackground(GO_COLOR);
                pollingFlightPanel.setBackground(GO_COLOR);
                System.out.println("go");
            }
            
            //Changes to red if no go
            
            if(noGoFlightButton.isSelected()) {

                flightPanel.setBackground(NO_GO_COLOR);
                pollingFlightPanel.setBackground(NO_GO_COLOR);
                System.out.println("no go");
            }
            
            //If all roles are go, continue to next frame and start countdown
            
            if(goBoosterButton.isSelected() && goGuidanceButton.isSelected() && 
                    goRangeButton.isSelected() && goFlightButton.isSelected()) {
               
                System.out.println("All systems are go.");
            }    
            else {
                
                System.out.println("All systems are not currently go.");
            }
        }
        if(command.equals("Return")) {
            
            this.dispose();
        }
        if(command.equals("Exit Application")) {
            
            System.exit(0);
        }
    }
}
