package com.pajor.calculator.ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

public class mainFrame extends JFrame {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int screenWidth = screenSize.width;
    private final int screenHeight = screenSize.height;

    mainFrame () {
        
        new JFrame("My Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setResizable(false);
        setLocation(screenWidth/2 - 225, screenHeight/2 - 300);
        getContentPane().setBackground(Color.lightGray);
        setLayout(new BorderLayout());

    }
}
