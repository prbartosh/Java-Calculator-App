package com.pajor.calculator.ui.api;

public interface UserInterface {

    void start(); // główna pętla
    void showResult(String result); // pokazywanie wynikow
    String getUserInput(); // pobieranie inputu
    void showError(String message);
}