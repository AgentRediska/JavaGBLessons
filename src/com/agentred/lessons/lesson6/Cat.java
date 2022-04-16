package com.agentred.lessons.lesson6;

public class Cat extends Animal {

    static int countCreatedCat = 0;

    public Cat() {
        countCreatedCat++;
    }

    @Override
    void run(int obstacleLength) {
        int maxRunDistance = 200;
        if (obstacleLength > maxRunDistance){
            super.run(obstacleLength);
        } else {
            printLose();
        }
    }

    @Override
    void swim(int obstacleLength) {
        int maxSwimDistance = 0;
        if (obstacleLength > maxSwimDistance){
            super.swim(obstacleLength);
        } else {
            printLose();
        }
    }
}
