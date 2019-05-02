package gui;
/*
Written by Henry G and An T for VAR padctrl 5/2/2019
Notifies user of launch, if noise and smoke isn't enough to give that away already
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchNotification extends Template implements ActionListener {

    //Constants
    private final Color LAUNCH_COLOR = new Color(0,150,0);
    
    //Declaring Objects
    private JPanel conformationPanel = new JPanel(new BorderLayout());
    private JLabel launchLabel = new JLabel("LIFTER HAS LAUNCHED!",SwingConstants.CENTER);

    public LaunchNotification(){

        //Formatting window
        this.setTitle("Launched");
        this.setBounds(500,400,500,160);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Configure launch label
        launchLabel.setForeground(Color.WHITE);
        launchLabel.setFont(WARNING_FONT);

        //Configure conformation panel
        conformationPanel.add(launchLabel,BorderLayout.CENTER);
        conformationPanel.setBackground(LAUNCH_COLOR);

        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(exitButton);
        navigationButtonPanel.setBackground(LAUNCH_COLOR);

        //Modifying button panel
        buttonPanel.remove(navigationButtonPanel);
        buttonPanel.add(navigationButtonPanel,BorderLayout.CENTER);

        //Add Components and set visible
        this.add(conformationPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }

    //For testing only
    public static void main(String[] args){
        LaunchNotification ln = new LaunchNotification();

    }
}
