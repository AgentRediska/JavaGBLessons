package com.agentred.lessons.lesson9.exception;

public class MyArrayDataException extends IllegalArgumentException {

    public MyArrayDataException(int i, int j) {
        super("Unable to convert string to integer type (array[" + i + "][" + j + "])");
    }
}
