package com.pajor.calculator.ui.gui;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class mainPanel extends JPanel {
    // private final GUIInputHandler inputHandler;
    private final JTextField textField;
    private final static int up = 1;
    private final static int down = -1;

    private void handleEnterOrEquals(KeyEvent e, GUIInputHandler inputHandler) {
        if (e.getKeyChar() == '\n' || e.getKeyChar() == '=') {
            inputHandler.onAction("\n", textField);
            e.consume();
            return;
        }
    }

    private void handleClear(KeyEvent e) {
        if (e.getKeyChar() == 'c') {
            textField.setText("");
            e.consume();
            return;
        }
    }

    private void handleHistory(KeyEvent e, GUIInputHandler inputHandler) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            String historyEntry = inputHandler.getFromHistory(up);
            textField.setText(historyEntry);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            String historyEntry = inputHandler.getFromHistory(down);
            textField.setText(historyEntry);
        }
    }

    mainPanel(JTextField textField, GUIInputHandler inputHandler) {
        this.textField = textField;
        // this.inputHandler = inputHandler;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(164, 180, 148));

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    handleEnterOrEquals(e, inputHandler);
                    handleHistory(e, inputHandler);
                } else if (e.getID() == KeyEvent.KEY_TYPED) {
                    handleClear(e);
                }
                return false;
            } 
        });
    }
}
