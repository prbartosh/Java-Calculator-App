package com.pajor.calculator.ui.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sun.tools.javac.Main;

public class GUIUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    // private JPanel buttonPanel = new JPanel(new FlowLayout());
    private JPanel inputPanel;

    public GUIUI() {
        SwingUtilities.invokeLater(() -> {
            mainFrame = new mainFrame();
            mainPanel = new mainPanel();
            inputPanel = new inputPanel(mainFrame);
            mainPanel.add(inputPanel);
            
            mainFrame.setContentPane(mainPanel);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
        
        
        
        

    }

}
