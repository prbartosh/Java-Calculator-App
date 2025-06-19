package com.pajor.calculator.ui.gui;

import javax.swing.JTextField;

import com.pajor.calculator.service.api.CalculatorService;

public class GUIInputHandler {
    private final CalculatorService calculatorService;

    public GUIInputHandler(CalculatorService calcServ) {
        this.calculatorService = calcServ;
    }

    public String passToService(String input) throws Exception {
        try {
            return String.valueOf(calculatorService.performCalculation(input));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void onAction(String text, JTextField textField) {
        if (text == "AC") {
                    textField.setText("");
                } else if (text == ".") {
                    textField.setText(textField.getText()+".");
                } else if (text == "=") {
                    // wykonaj obliczenia ->
                    try {
                        String result = passToService(textField.getText());
                        textField.setText(result);
                    } catch (Exception exception) {
                        textField.setText(exception.toString());
                    }
                    
                } else if (text.matches("-?\\d+") || text.matches("-?\\d*\\.\\d+")) {
                    textField.setText(textField.getText() + text);
                }
                else {
                    textField.setText(textField.getText() + " " + text + " ");
                }
    }

}
