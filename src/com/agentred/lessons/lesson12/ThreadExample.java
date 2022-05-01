package com.agentred.lessons.lesson12;

public class ThreadExample {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {
        fillArray();
        setNewValues(arr);
        setNewValuesWithTread(arr);
    }

    public static void fillArray() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
    }

    public static void setNewValues(float[] array) {
        float[] copyArr = calculateByFormula(array);
        long a = System.currentTimeMillis();
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = (float) (copyArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Main thread: " + (System.currentTimeMillis() - a));
    }

    public static void setNewValuesWithTread(float[] array) {
        float[] copyArr = array.clone();
        long a = System.currentTimeMillis();

        Thread threadFirst = new Thread(() -> {
            float[] a1 = new float[HALF];
            System.arraycopy(copyArr, 0, a1, 0, HALF);
            a1 = calculateByFormula(a1);
            System.arraycopy(a1, 0, copyArr, 0, HALF);
            System.out.println("First thread: " + (System.currentTimeMillis() - a));
        });

        Thread threadSecond = new Thread(() -> {
            float[] a2 = new float[HALF];
            System.arraycopy(copyArr, HALF, a2, 0, HALF);
            a2 = calculateByFormula(a2);
            System.arraycopy(a2, 0, copyArr, HALF, HALF);
            System.out.println("Second thread: " + (System.currentTimeMillis() - a));
        });

        threadFirst.start();
        threadSecond.start();

        try{
            threadFirst.join();
            threadSecond.join();
            System.out.println("Total result: " + (System.currentTimeMillis() - a));
        }catch (InterruptedException exception) {
            System.out.println("Fail");
        }

    }

    public static float[] calculateByFormula(float[] arr) {
        float[] copyArr = arr.clone();
        for(int i = 0; i < arr.length; i++) {
            copyArr[i] = (float) (copyArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        return copyArr;
    }

}
