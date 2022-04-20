package com.agentred.lessons.lesson8.library.radingroom;

import com.agentred.lessons.lesson8.library.archive.Archive;

public class ReadingRoom {

    private final int numberReadingRoom;
    private Archive archive;
    private int maxVisitorCount;

    public ReadingRoom(int numberReadingRoom, Archive archive, int maxVisitorCount) {
        this.numberReadingRoom = numberReadingRoom;
        this.archive = archive;
        this.maxVisitorCount = maxVisitorCount;
    }

    public int getMaxVisitorCount() {
        return maxVisitorCount;
    }

    public void setMaxVisitorCount(int maxVisitorCount) {
        this.maxVisitorCount = maxVisitorCount;
    }

    public Archive getArchive() {
        return archive;
    }

    public int getNumberReadingRoom() {
        return numberReadingRoom;
    }
}
