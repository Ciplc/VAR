package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchNotification extends Template implements ActionListener {

    private JPanel conformationPanel = new JPanel(new BorderLayout());
    private JLabel launchLabel = new JLabel("Launched",SwingConstants.CENTER);

    public LaunchNotification(){

        //Formatting window
        this.setTitle("Launched");
        this.setBounds(500,400,500,160);

        //Configure launch label
        launchLabel.setForeground(Color.WHITE);

        //Configure conformation panel
        conformationPanel.add(launchLabel,BorderLayout.CENTER);
        conformationPanel.setBackground(BACKGROUND_COLOR);

        //Modify nav panel
        navigationButtonPanel.remove(nextButton);
        navigationButtonPanel.remove(returnButton);

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
