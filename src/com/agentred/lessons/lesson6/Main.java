package com.agentred.lessons.lesson6;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        System.out.println("Количество созданных котов " + Cat.countCreatedCat);

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        System.out.println("Количество созданных собак " + Dog.countCreatedDog);
    }
}
