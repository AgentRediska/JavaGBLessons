package com.agentred.lessons.lesson11;

import com.agentred.lessons.lesson11.fruit.Apple;
import com.agentred.lessons.lesson11.fruit.Fruit;
import com.agentred.lessons.lesson11.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        firstTask();
        secondTask();
        thirdTask();
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
        getBoxWithApple(box);
        System.out.println("Weight of box is - " + box.getWeight());

        Box<Orange> box2 = getBoxWithApple();
        System.out.println("Weight of box2 is - " + box.getWeight());
    }

    public static <T extends Fruit> Box<T>  getBoxWithApple(Box<T> box) {
        int count = 0;
        while (count < 20) {
            box.setProduct(new T());
            count++;
        }
        return box;
    }

}
