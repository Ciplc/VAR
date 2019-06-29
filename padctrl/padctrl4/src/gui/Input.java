/*Written by An T for VAR padctrl 6/28/2019
Input frame for padctrl to allow user to record key data of their mission */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Input extends Template implements ActionListener {

    //Declaring inputs gathered
    private String date;
    private Integer countdownTime;
    private String launchLocation;
    private String vehicle;
    private String payload;
    private String motor;
    private String primaryObj;
    private String secondObj;
    
    //Declaring Labels
    private JLabel dateLabel = new JLabel("Date: ",SwingConstants.RIGHT);
    private JLabel countdownTimeLabel = new JLabel("Countdown Time: ",SwingConstants.RIGHT);
    private JLabel launchLocationLabel = new JLabel("Launch Location: ",SwingConstants.RIGHT);
    private JLabel missionTypeLabel = new JLabel("Mission Type: ",SwingConstants.RIGHT);
    private JLabel vehicleLabel = new JLabel("Vehicle Type: ",SwingConstants.RIGHT);
    private JLabel payloadLabel = new JLabel("Payload: ",SwingConstants.RIGHT);
    private JLabel motorLabel = new JLabel("Motor: ",SwingConstants.RIGHT);
    private JLabel primaryObjLabel = new JLabel("Primary Objective: ",SwingConstants.RIGHT);
    private JLabel secondaryObjLabel = new JLabel("Secondary Objective: ",SwingConstants.RIGHT);
    
    //Declaring TextFields
    private JTextField dateField = new JTextField(20);
    private JTextField countdownTimeField = new JTextField(20);
    private JTextField launchLocationField = new JTextField(20);
    private JTextField vehicleField = new JTextField(20);
    private JTextField payloadField = new JTextField(20);
    private JTextField motorField = new JTextField(20);
    private JTextField primaryObjField = new JTextField(20);
    private JTextField secondaryObjField = new JTextField(20);

    //Declaring Mission Type objs
    private JComboBox<String> missionTypeComboBox;
    private String[] missionTypeArray = {"Standard Launch", "High Altitude Balloon Launch", "CMP Launch"};

    //Declaring Panels
    private JPanel datePanel = new JPanel(new BorderLayout());
    private JPanel countdownTimePanel  = new JPanel(new BorderLayout());
    private JPanel launchLocationPanel = new JPanel(new BorderLayout());
    private JPanel vehiclePanel = new JPanel(new BorderLayout());
    private JPanel payloadPanel = new JPanel(new BorderLayout());
    private JPanel motorPanel = new JPanel(new BorderLayout());
    private JPanel primaryObjPanel = new JPanel(new BorderLayout());
    private JPanel secondaryObjPanel = new JPanel(new BorderLayout());
    private JPanel missionTypePanel = new JPanel(new BorderLayout());
    private JPanel missionEnvironmentPanel = new JPanel(new BorderLayout());
    private JPanel holdParamPanel = new JPanel(new BorderLayout());
    private JPanel vehicleDataPanel = new JPanel(new BorderLayout());
    private JPanel objPanel = new JPanel(new BorderLayout());
    private JPanel missionPanel = new JPanel(new BorderLayout());

    public Input(){

        //Formatting Frame
        this.setTitle("Input");
        this.setBounds(100,50,450,270);
        this.setLayout(new BorderLayout());
        
        //Formatting labels
        
        dateLabel.setFont(DEFAULT_FONT);
        countdownTimeLabel.setFont(DEFAULT_FONT);
        launchLocationLabel.setFont(DEFAULT_FONT);
        missionTypeLabel.setFont(DEFAULT_FONT);
        vehicleLabel.setFont(DEFAULT_FONT);
        payloadLabel.setFont(DEFAULT_FONT);
        motorLabel.setFont(DEFAULT_FONT);
        primaryObjLabel.setFont(DEFAULT_FONT);
        secondaryObjLabel.setFont(DEFAULT_FONT);
        dateLabel.setForeground(Color.WHITE);
        countdownTimeLabel.setForeground(Color.WHITE);
        launchLocationLabel.setForeground(Color.WHITE);      
        missionTypeLabel.setForeground(Color.WHITE);      
        vehicleLabel.setForeground(Color.WHITE);  
        payloadLabel.setForeground(Color.WHITE);  
        motorLabel.setForeground(Color.WHITE);  
        primaryObjLabel.setForeground(Color.WHITE);  
        secondaryObjLabel.setForeground(Color.WHITE);  
        
        //Date Panel
        datePanel.add(dateLabel,BorderLayout.WEST);
        datePanel.add(dateField,BorderLayout.EAST);
        datePanel.setBackground(BACKGROUND_COLOR);
        
        //Countdown Time Panel
        countdownTimePanel.add(countdownTimeLabel,BorderLayout.WEST);
        countdownTimePanel.add(countdownTimeField,BorderLayout.EAST);
        countdownTimePanel.setBackground(BACKGROUND_COLOR);
        
        //Launch Location Panel
        launchLocationPanel.add(launchLocationLabel,BorderLayout.WEST);
        launchLocationPanel.add(launchLocationField,BorderLayout.EAST);
        launchLocationPanel.setBackground(BACKGROUND_COLOR);
        
        //Vehicle Panel
        vehiclePanel.add(vehicleLabel,BorderLayout.WEST);
        vehiclePanel.add(vehicleField,BorderLayout.EAST);
        vehiclePanel.setBackground(BACKGROUND_COLOR);
        
        //Payload Panel
        payloadPanel.add(payloadLabel,BorderLayout.WEST);
        payloadPanel.add(payloadField,BorderLayout.EAST);
        payloadPanel.setBackground(BACKGROUND_COLOR);
        
        //Motor Panel
        motorPanel.add(motorLabel,BorderLayout.WEST);
        motorPanel.add(motorField,BorderLayout.EAST);
        motorPanel.setBackground(BACKGROUND_COLOR);
        
        //Primary Objective Panel
        primaryObjPanel.add(primaryObjLabel,BorderLayout.WEST);
        primaryObjPanel.add(primaryObjField,BorderLayout.EAST);
        primaryObjPanel.setBackground(BACKGROUND_COLOR);
        
        //Secondary Objective Panel
        secondaryObjPanel.add(secondaryObjLabel,BorderLayout.WEST);
        secondaryObjPanel.add(secondaryObjField,BorderLayout.EAST);
        secondaryObjPanel.setBackground(BACKGROUND_COLOR);
        
        //Mission Type ComboBox
        missionTypeComboBox = new JComboBox<>(missionTypeArray);
        missionTypeComboBox.addActionListener(this);
        
        //MissionType Panel
        missionTypePanel.add(missionTypeComboBox,BorderLayout.EAST);
        missionTypePanel.add(missionTypeLabel,BorderLayout.WEST);
        missionTypePanel.setBackground(BACKGROUND_COLOR);
        
        //MissionEnvironment Panel
        missionEnvironmentPanel.add(datePanel,BorderLayout.NORTH);
        missionEnvironmentPanel.add(launchLocationPanel,BorderLayout.CENTER);
        missionEnvironmentPanel.add(missionTypePanel,BorderLayout.SOUTH);
        missionEnvironmentPanel.setBackground(BACKGROUND_COLOR);
        
        //VehicleData Panel
        vehicleDataPanel.add(vehiclePanel,BorderLayout.NORTH);
        vehicleDataPanel.add(payloadPanel,BorderLayout.CENTER);
        vehicleDataPanel.add(motorPanel,BorderLayout.SOUTH);
        vehicleDataPanel.setBackground(BACKGROUND_COLOR);
        
        //obj Panel
        objPanel.add(primaryObjPanel,BorderLayout.NORTH);
        objPanel.add(secondaryObjPanel,BorderLayout.SOUTH);
        
        //Mission Panel
        missionPanel.add(objPanel,BorderLayout.NORTH);
        missionPanel.add(holdParamPanel,BorderLayout.CENTER);
        missionPanel.add(buttonPanel,BorderLayout.SOUTH);
        
        //Remove from frame
        this.remove(buttonPanel);
        
        //Add to frame
        this.add(missionEnvironmentPanel,BorderLayout.NORTH);
        this.add(vehicleDataPanel,BorderLayout.CENTER);
        this.add(missionPanel,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    //Testing purposes only
    public static void main(String[] args){

        Input testInput = new Input();
    }
}
