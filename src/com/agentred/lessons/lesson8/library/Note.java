package com.agentred.lessons.lesson8.library;

public class Note {

    private final int visitorTicket;
    private final int numberReadingRoom;
    private final String bookName;

    public Note(int visitorTicket, int numberReadingRoom, String bookName) {
        this.visitorTicket = visitorTicket;
        this.numberReadingRoom = numberReadingRoom;
        this.bookName = bookName;
    }

    public int getVisitorTicket() {
        return visitorTicket;
    }

    public int getNumberReadingRoom() {
        return numberReadingRoom;
    }

    public String getBookName() {
        return bookName;
    }
}
