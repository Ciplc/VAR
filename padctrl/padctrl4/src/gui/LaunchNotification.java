package gui;

import java.awt.event.ActionListener;

public class LaunchNotification extends Template implements ActionListener {

    public LaunchNotification(){

        this.setTitle("Launched");
        this.setBounds(100,50,700,160);
        
    }

    //For testing only
    public static void main(String[] args){
        LaunchNotification ln = new LaunchNotification();

    }
}
