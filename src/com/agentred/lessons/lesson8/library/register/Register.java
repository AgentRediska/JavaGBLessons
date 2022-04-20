package com.agentred.lessons.lesson8.library.register;

import com.agentred.lessons.lesson8.library.Note;
import com.agentred.lessons.lesson8.library.actor.Visitor;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;

import java.util.ArrayList;

public class Register {

    private ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote() {

    }

}
