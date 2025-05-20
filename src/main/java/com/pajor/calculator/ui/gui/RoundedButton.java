package com.pajor.calculator.ui.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getModel().isPressed() ? Color.LIGHT_GRAY : Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
        super.paintComponent(g2);
        g2.dispose();
    }
    @Override
    public void setContentAreaFilled(boolean b) {}
}

