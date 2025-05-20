package com.pajor.calculator.app;

import java.util.Scanner;

import com.pajor.calculator.service.impl.CalculatorServiceImpl;
import com.pajor.calculator.ui.console.ConsoleUI;
import com.pajor.calculator.ui.gui.GUIUI;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        ConsoleUI consoleUI = new ConsoleUI(calculatorService);
        GUIUI guiUI = new GUIUI();


        // consoleUI.start();
    }


}

