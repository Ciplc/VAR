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
    //TODO Hold Parameters and Mission Type

    //Declaring TextFields
    private JTextField dateField;
    private JTextField countdownTimeField;
    private JTextField launchLocationField;
    private JTextField vehicleField;
    private JTextField payloadField;
    private JTextField motorField;
    private JTextField primaryObjField;
    private JTextField secondaryObjField;

    //Declaring Mission Type objs
    private JComboBox<String> missionTypeComboBox;
    private String[] missionTypeArray = {"Standard", "CMP"};

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
    private JPanel holdParamPanel = new JPanel(new BorderLayout());

    public Input(){

        //Formatting Frame
        this.setTitle("Input");
        this.setBounds(100,50,700,160);

        //Mission Type ComboBox
        missionTypeComboBox = new JComboBox<>(missionTypeArray);
        missionTypeComboBox.addActionListener(this);
        
        missionTypePanel.add(missionTypeComboBox);
        missionTypePanel.setBackground(BACKGROUND_COLOR);
    }

    //Testing purposes only
//    public static void main(String[] args){
//
//    }
}
