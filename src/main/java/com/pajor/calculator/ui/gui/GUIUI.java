package com.pajor.calculator.ui.gui;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
// import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.pajor.calculator.service.api.CalculatorService;

public class GUIUI {
    private GUIInputHandler inputHandler;
    private JFrame mainFrame;
    private JPanel mainPanel;
    // private JPanel buttonPanel = new JPanel(new FlowLayout());
    private JPanel inputPanel;
    private JTextField textField;
    private JPanel buttonsPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints gbc = new GridBagConstraints();
    private void addButton(String text, int x, int y, int gridheight, int gridwidth, JTextField textField) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        buttonsPanel.add(new CustomButton(text, textField, inputHandler), gbc);
    }
    private int columns = 4;

    // stworzyć listę przycisków
    private List<String> buttons = List.of(
        "%", "n√a", "√", "AC",
        "!", "^","÷", "×",
        "7", "8", "9", "-", 
        "4", "5", "6", "+",
        "1", "2", "3", "=", 
        "0", "."
    );

    // dodać przyciski w pętli


    public GUIUI(CalculatorService _calcServ) {
        SwingUtilities.invokeLater(() -> {
            inputHandler = new GUIInputHandler(_calcServ);
            textField = new equasionInputField(inputHandler);
            mainFrame = new mainFrame();
            inputPanel = new inputPanel(mainFrame, textField);
            mainPanel = new mainPanel(textField, inputHandler);
            // mainPanel.setBackground(new Color(164, 180, 148));
            buttonsPanel.setBackground(new Color(164, 180, 148));
            mainPanel.add(Box.createHorizontalStrut(10));
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(inputPanel);
            mainPanel.add(Box.createVerticalStrut(10));
            for (int i=0; i<19; i++) {
                addButton(buttons.get(i), i%columns, i/columns, 1, 1, textField);
            }

            addButton(buttons.get(19), 19%columns, 19/columns, 2, 1, textField);
            addButton(buttons.get(20), 20%columns, 20/columns, 1, 2, textField);
            addButton(buttons.get(21), 2, 5, 1, 1, textField);
            

            mainPanel.add(buttonsPanel);
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(Box.createHorizontalStrut(10));
            mainFrame.setContentPane(mainPanel);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(false);
        });
    }

    public void startGUIUI() {
        mainFrame.setVisible(true);
    };

}
