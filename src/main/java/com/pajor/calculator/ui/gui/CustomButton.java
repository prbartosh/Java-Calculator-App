package com.pajor.calculator.ui.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JTextField;


public class CustomButton extends JButton {
    // GUIInputHandler inputHandler;
    
    CustomButton(String text, JTextField textField, GUIInputHandler inputHandler) {
        new JButton() {
        @Override
            protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            g2.dispose(); 
            super.paintComponent(g2);
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //rysownie obramowania
            g2.setColor(new Color(81, 152, 114));
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 10, 10);
            g2.dispose();
        }

        };
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);
        // setBackground(new Color(190, 197, 173));
        setFont(new Font("Arial", Font.BOLD, 16));
        // setBorder(
        //     BorderFactory.createCompoundBorder(
        //         BorderFactory.createLineBorder(new Color(59, 82, 73),4, true),
        //         BorderFactory.createEmptyBorder(5,5,5,5))
        //     );
        setText(text);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button " + text + " clicked!");
                // rest logic
                inputHandler.onAction(text, textField);
            }
        });
    }
    

    
}
