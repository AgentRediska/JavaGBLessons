package com.agentred.lessons.lesson9;


import com.agentred.lessons.lesson9.exception.MyArrayDataException;
import com.agentred.lessons.lesson9.exception.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        String[][] array = new String[4][4];
        testString(array, 4);
        try {
            System.out.println("start");
            example(array);
        } catch (MyArraySizeException arSize) {
            //MyArraySizeException наследована от Runtime
            System.out.println("Array's size is bad");
        } catch (MyArrayDataException arData) {
            //MyArrayDataException наследована от IllegalArgumentException
            System.out.println("parsing error");
        }

    }

    public static void example(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int size = 4;
        int sum = 0;

        if (arr.length != size || arr[0].length != size) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    System.out.println("AAAAAAAAAAAAAA");
                    throw new MyArrayDataException(i, j);
                }
            }
        }
    }

    public static void testString(String[][] arr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 3 && j == 3) {
                    arr[i][j] = "not number";
                } else {
                    arr[i][j] = "" + i + j;
                }
            }
        }
    }

}

