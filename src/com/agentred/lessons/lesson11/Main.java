package com.agentred.lessons.lesson11;

import com.agentred.lessons.lesson11.fruit.Apple;
import com.agentred.lessons.lesson11.fruit.Fruit;
import com.agentred.lessons.lesson11.fruit.Orange;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
    }

    public static void firstTask() {
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<String> list2 = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5"));
        System.out.println(swapElements(list1));
        System.out.println(swapElements(list2));
    }

    public static void secondTask() {
        Integer[] intMas = {1, 3, 4, 341, 435};
        String[] stringMas = {"hi", "he", "ho", "ha"};
        ArrayList<?> intArrayList = convertToArrayList(intMas);
        ArrayList<?> stringArrayList = convertToArrayList(stringMas);
        System.out.println(intArrayList.get(2));
        System.out.println(stringArrayList.get(1));
    }

    public static <T> List<T> swapElements(List<T> list) {
        T basket = list.get(1);
        list.set(1, list.get(3));
        list.set(3, basket);
        return list;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] nums) {
        return new ArrayList<>(Arrays.asList(nums));
    }

    public static void thirdTask() {
        Box<Apple> box = new Box<>();
        getBoxWithApple(box, 6);
        System.out.println("Weight of apple box is - " + box.getWeight());

        Box<Orange> box2 = new Box<>();
        getBoxWithOrange(box2, 4);
        System.out.println("Weight of orange box is - " + box2.getWeight());

        System.out.println("Compare apple box with orange box - " + box.compare(box2));
    }

    public static void getBoxWithApple(Box<Apple> box, int count) {
        int i = 0;
        while (i < count) {
            box.setProduct(new Apple());
            i++;
        }
    }

    public static void getBoxWithOrange(Box<Orange> box, int count) {
        int i = 0;
        while (i < count) {
            box.setProduct(new Orange());
            i++;
        }
    }

    public static void fourthTask() {
        Box<Apple> appleBox = new Box<>();
        getBoxWithApple(appleBox, 6);

        Box<Orange> orangeBox = new Box<>();
        getBoxWithOrange(orangeBox, 4);

        Box<Apple> newBox = sprinkleFruits(appleBox);
        System.out.println("The new box has " + newBox.getWeight()
                + " and the old box has " + appleBox.getWeight());
    }

    public static <T extends Fruit> Box<T> sprinkleFruits(Box<T> fullBox) {
        Box<T> emptyBox = new Box<>();
        List<T> fruits = fullBox.getListOfProduct();
        ListIterator<T> iterator = fruits.listIterator();
        while (iterator.hasNext()){
            T fruit = iterator.next();
            emptyBox.setProduct(fruit);
            iterator.remove();
        }
        return emptyBox;
    }
}
