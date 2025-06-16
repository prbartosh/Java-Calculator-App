package com.pajor.calculator.ui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class inputPanel extends JPanel{
    JTextField textField;

    inputPanel(JFrame mainFrame) {
        setLayout(new BorderLayout(5,5));
        setPreferredSize(new Dimension(mainFrame.getWidth(), 20));
        setMaximumSize(new Dimension(1000, 100));
        setBackground(Color.lightGray);
        textField = new equasionInputField();
    
        add(textField, BorderLayout.CENTER);
    }
}
