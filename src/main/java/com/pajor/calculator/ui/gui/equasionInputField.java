package com.pajor.calculator.ui.gui;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;




public class equasionInputField extends JTextField{

    
    public equasionInputField(GUIInputHandler inputHandler) {
    new JTextField("0", 16);
    setMargin(new Insets(10,5,10,5));
    Font fo = new Font("Serif", Font.BOLD, 20);
    setFont(fo);
    setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    

    

    addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });

    }
}
