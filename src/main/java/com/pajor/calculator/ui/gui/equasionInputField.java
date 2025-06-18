package com.pajor.calculator.ui.gui;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;


import javax.swing.JTextField;

public class equasionInputField extends JTextField{
    equasionInputField() {
    new JTextField("0", 16);
    setMargin(new Insets(10,5,10,5));
    Font fo = new Font("Serif", Font.BOLD, 20);
    setFont(fo);
    setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
}
}
