package com.agentred.lessons.lesson8.library.radingroom;

import com.agentred.lessons.lesson8.library.archive.BaseArchive;

public class ReadingRoom {

    private final int numberReadingRoom;
    private BaseArchive archive;
    private int maxVisitorCount;

    public ReadingRoom(int numberReadingRoom, BaseArchive archive, int maxVisitorCount) {
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

    public BaseArchive getArchive() {
        return archive;
    }

    public int getNumberReadingRoom() {
        return numberReadingRoom;
    }
}
