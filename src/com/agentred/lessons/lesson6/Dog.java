package com.agentred.lessons.lesson6;

public class Dog extends Animal {

    static int countCreatedDog = 0;

    public Dog() {
        countCreatedDog++;
    }

    @Override
    void run(int obstacleLength) {
        int maxRunDistance = 500;
        if (obstacleLength > maxRunDistance){
            super.run(obstacleLength);
        } else {
            printLose();
        }
    }

    @Override
    void swim(int obstacleLength) {
        int maxSwimDistance = 10;
        if (obstacleLength > maxSwimDistance){
            super.swim(obstacleLength);
        } else {
            printLose();
        }
    }
}
