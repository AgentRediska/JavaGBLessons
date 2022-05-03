package com.agentred.lessons.lesson13.stage;

import com.agentred.lessons.lesson13.Car;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore semaphore = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        Thread thread = new Thread(() -> {
                try {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " +
                            description);
                    semaphore.acquire();
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " +
                            description);
                    semaphore.release();
                }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
