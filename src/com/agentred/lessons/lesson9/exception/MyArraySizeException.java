package com.agentred.lessons.lesson9.exception;

public class MyArraySizeException extends RuntimeException {

    private static final String sizeException = "Size of array is not 4 elements";

    public MyArraySizeException() {
        super(sizeException);
    }
}
