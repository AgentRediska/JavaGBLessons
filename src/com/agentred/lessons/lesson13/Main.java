package com.agentred.lessons.lesson13;


import com.agentred.lessons.lesson13.stage.Road;
import com.agentred.lessons.lesson13.stage.Tunnel;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        preparation(cars);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        startDriving(cars);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static void preparation(Car[] cars) {
        final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final int w = i;
            new Thread(() -> {
                cars[w].run();
                System.out.println("TEST");
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startDriving(Car[] cars) {
        final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final int w = i;
            new Thread(() -> {
                cars[w].startDriving();
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
