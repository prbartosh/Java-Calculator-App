package com.pajor.calculator.ui.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Minimalist Calculator");
        setSize(320, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Główny panel w układzie pionowym (VBox)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Spacer
        mainPanel.add(Box.createVerticalStrut(10));

        // Display Text
        JTextField display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        display.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        mainPanel.add(display);

        // Spacer
        mainPanel.add(Box.createVerticalStrut(10));

        // Panel z przyciskami (VBox)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        // Wiersze przycisków
        buttonPanel.add(row("%", "n√a", "√", "AC"));
        buttonPanel.add(row("÷", "×", "-", "+"));
        buttonPanel.add(row("7", "8", "9", "!"));
        buttonPanel.add(row("4", "5", "6", "^"));

        // Specjalny dolny wiersz
        JPanel lastRow = new JPanel();
        lastRow.setLayout(new BoxLayout(lastRow, BoxLayout.X_AXIS));
        lastRow.setOpaque(false);

        // Lewa część (Vstack)
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setOpaque(false);

        left.add(row("1", "2", "3"));
        left.add(doubleWidthRow("0", "."));

        // Prawa część (doubleHeightButton)
        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        right.setOpaque(false);
        JButton equals = new RoundedButton("=");
        equals.setPreferredSize(new Dimension(55, 86));
        right.add(equals, BorderLayout.CENTER);

        // Dodanie lewej i prawej strony do ostatniego wiersza
        lastRow.add(left);
        lastRow.add(Box.createRigidArea(new Dimension(10, 0)));
        lastRow.add(right);

        buttonPanel.add(lastRow);

        mainPanel.add(buttonPanel);
        add(mainPanel);
        setVisible(true);
    }

    // Utility – Hstack z n przyciskami
    private JPanel row(String... texts) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);
        for (String text : texts) {
            JButton btn = new RoundedButton(text);
            btn.setPreferredSize(new Dimension(55, 36));
            panel.add(btn);
            panel.add(Box.createRigidArea(new Dimension(8, 0)));
        }
        panel.remove(panel.getComponentCount() - 1); // usuń ostatni odstęp
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        return panel;
    }

    // Podwójna szerokość
    private JPanel doubleWidthRow(String text1, String text2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);
        JButton btn1 = new RoundedButton(text1);
        btn1.setPreferredSize(new Dimension(118, 36)); // 2x normalny
        panel.add(btn1);
        panel.add(Box.createRigidArea(new Dimension(8, 0)));
        JButton btn2 = new RoundedButton(text2);
        btn2.setPreferredSize(new Dimension(55, 36));
        panel.add(btn2);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        return panel;
    }
}

