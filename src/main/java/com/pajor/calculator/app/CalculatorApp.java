package com.pajor.calculator.app;

import javax.swing.SwingUtilities;
import com.pajor.calculator.service.impl.CalculatorServiceImpl;
import com.pajor.calculator.ui.gui.GUIUI;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        // ConsoleUI consoleUI = new ConsoleUI(calculatorService);
        GUIUI guiUI = new GUIUI(calculatorService);

        // consoleUI.start();
        SwingUtilities.invokeLater(() -> { guiUI.startGUIUI();});
    }


}

