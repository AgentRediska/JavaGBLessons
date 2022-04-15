package com.agentred.lessons.lesson2;

public class Main {
    public static void main(String[] args) {
        Lesson2 lesson2 = new Lesson2();

        System.out.println("1 Задание");
        lesson2.reverseArray();

        System.out.println("\n 2 Задание");
        lesson2.fillArray();

        System.out.println("\n 3 Задание");
        lesson2.weedOutArray();

        System.out.println("\n 4 Задание");
        lesson2.createSquareArray();

        System.out.println("\n 5 Задание");
        lesson2.findMaxMinInArray();

        System.out.println("\n 6 Задание");
        int[] testArr1 = {1, 5, 6, 7, 9, 10};
        int[] testArr2 = {43, 2, 4, 66, 23, 64, 34};
        lesson2.searchIdenticalPartsOfArray(testArr1);
        lesson2.searchIdenticalPartsOfArray(testArr2);

        System.out.println("\n 7 Задание");
        lesson2.moveElements(testArr1, 4);
        System.out.println();
        lesson2.moveElements(testArr1, -2);


    }
}

class Lesson2 {

    void reverseArray() {
        int[] arr = {1, 0, 0, 0, 1, 1, 0, 1, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    void fillArray() {
        int[] arr = new int[8];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = count;
            count += 3;
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    void weedOutArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    void createSquareArray() {
        int size = 15;
        int[][] arr = new int[size][size];
        System.out.println(arr.length);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int helper = arr.length - (count + 1);
            for (int j = 0; j < arr.length; j++) {
                if (j == count || j == helper) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
            if (i < arr.length / 2) {
                count++;
            } else {
                count--;
            }
        }

        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    void findMaxMinInArray() {
        int[] array = {33, 4, 16, 834, 234, 5, 234, 11};
        int max = array[0];
        int min = max;
        int number;

        for (int j : array) {
            number = j;
            if (number < min) {
                min = number;
            } else if (number > max) {
                max = number;
            }
        }
        System.out.println("min = " + min + " max = " + max);
    }

    void searchIdenticalPartsOfArray(int[] arr) {
        if (arr.length > 3) {
            for (int barrier = 2; barrier < arr.length - 2; barrier++) {
                int sumLeft = 0;
                int sumRight = 0;

                for (int i = 0; i < arr.length; i++) {
                    if (i <= barrier) {
                        sumLeft += arr[i];
                    } else {
                        sumRight += arr[i];
                    }
                }
                if (sumLeft == sumRight) {
                    System.out.println("Совпадение найдено, сумма чисел слева = " + sumLeft + ", а сумма справа = " + sumRight);
                    System.out.println("Числа слева: ");
                    for (int i = 0; i <= barrier; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println("Числа справа: ");
                    for (int i = barrier + 1; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    break;
                }
            }
        }
    }

    void moveElements(int[] arr, int count) {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                moveRight(arr);
            }
        } else {
            for (int i = 0; i < count * (-1); i++) {
                moveLeft(arr);
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private void moveRight(int[] arr) {
        int size = arr.length;
        int elementBox = arr[arr.length - 1];

        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = elementBox;
    }

    private int[] moveLeft(int[] arr) {
        int size = arr.length;
        int elementBox = arr[0];

        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = elementBox;
        return arr;
    }
}
