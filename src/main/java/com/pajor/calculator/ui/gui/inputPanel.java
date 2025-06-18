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

    inputPanel(JFrame mainFrame, JTextField _textField) {
        setLayout(new BorderLayout(5,5));
        setPreferredSize(new Dimension(mainFrame.getWidth(), 40));
        setBackground(new Color(164, 180, 148));
        textField = _textField;
    
        add(textField, BorderLayout.CENTER);
    }
}
