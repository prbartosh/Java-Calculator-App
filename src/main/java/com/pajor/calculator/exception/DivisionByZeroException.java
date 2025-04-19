package com.pajor.calculator.exception;

public class DivisionByZeroException extends IllegalArgumentException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}