package com.agentred.lessons.lesson8.library.register;

import com.agentred.lessons.lesson8.library.actor.Visitor;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;

import java.util.ArrayList;

public class Register {

    private final ArrayList<ReadingRoom> readingRooms = new ArrayList<>();
    private final ArrayList<Visitor> visitors = new ArrayList<>();

    public ArrayList<ReadingRoom> getReadingRooms() {
        return readingRooms;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    private boolean isReadingRoom(int readingRoomNumber) {
        for (ReadingRoom readR : this.readingRooms) {
            if (readR.getNumberReadingRoom() == readingRoomNumber) {
                return true;
            }
        }
        return false;
    }

    public void addReadingRoom(ReadingRoom readingRoom) {
        if (!isReadingRoom(readingRoom.getNumberReadingRoom())) {
            readingRooms.add(readingRoom);
        } else {
            System.out.println("Такой читательный зал уже существует в списке");
        }
    }

    public void removeReadingRoom(ReadingRoom readingRoom) {
        if (isReadingRoom(readingRoom.getNumberReadingRoom())) {
            readingRooms.remove(readingRoom);
        } else {
            System.out.println("Такого читательного зала нет в списке");
        }
    }

}
