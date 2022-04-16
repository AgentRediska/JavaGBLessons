package com.agentred.lessons.lesson5;

public class Main {

    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 30);
        persons[1] = new Person("Ivanov Ivan1", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 60);
        persons[2] = new Person("Ivanov Ivan2", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 20);
        persons[3] = new Person("Ivanov Ivan3", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 63);
        persons[4] = new Person("Ivanov Ivan4", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 34);

        for (Person person : persons) {
            if(person.getAge() > 40){
                person.showPersonInfo();
            }
        }
    }

}
