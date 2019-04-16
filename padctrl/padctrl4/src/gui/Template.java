package gui;
/*
Written by Henry G for VAR padctrl
Template frame, nothing to see here move along
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Template extends JFrame implements ActionListener {

    //Constants

    public final Color BACKGROUND_COLOR = new Color(0,200,0);
    public final Font DEFAULT_FONT = new Font("Calibri",Font.PLAIN,20);

    public Template(){

        //Formatting
        super("Template");
        this.setBounds(100,50,900,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
