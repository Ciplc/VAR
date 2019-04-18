package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Input extends Template implements ActionListener {

    //Declaring inputs gathered
    private String Date;
    private Integer CountdownTime;
    private String LaunchLocation;
    private String Vehicle;
    private String Payload;
    private String Motor;
    private String PrimaryObj;
    private String SecondObj;
    //TODO Hold Parameters and Mission Type

    //Declaring TextFields
    private JTextField DateField;
    private JTextField CountdownTimeField;
    private JTextField LaunchLocationField;
    private JTextField VehicleField;
    private JTextField PayloadField;
    private JTextField MotorField;
    private JTextField PrimaryObjField;
    private JTextField SecondaryObjField;

    //Declaring Mission Type objs
    private JComboBox<String> MissionTypeComboBox;
    private String[] MissionTypeArray = {"Standard", "CMP"};

    //Declaring Panels
    private JPanel DatePanel = new JPanel(new BorderLayout());
    private JPanel CountdownTimePanel  = new JPanel(new BorderLayout());
    private JPanel LaunchLocationPanel = new JPanel(new BorderLayout());
    private JPanel VehiclePanel = new JPanel(new BorderLayout());
    private JPanel PayloadPanel = new JPanel(new BorderLayout());
    private JPanel MotorPanel = new JPanel(new BorderLayout());
    private JPanel PrimaryObjPanel = new JPanel(new BorderLayout());
    private JPanel SecondaryObjPanel = new JPanel(new BorderLayout());
    private JPanel MissionTypePanel = new JPanel(new BorderLayout());
    private JPanel HoldParamPanel = new JPanel(new BorderLayout());

    public Input(){

        //Formatting Frame
        this.setTitle("Input");
        this.setBounds(100,50,700,160);

        //Mission Type ComboBox
        MissionTypeComboBox = new JComboBox<>(MissionTypeArray);
    }

    //Testing purposes only
//    public static void main(String[] args){
//
//    }
}
