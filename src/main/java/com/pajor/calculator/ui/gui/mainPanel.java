package com.pajor.calculator.ui.gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class mainPanel extends JPanel {
    mainPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(164, 180, 148));
    }
}
