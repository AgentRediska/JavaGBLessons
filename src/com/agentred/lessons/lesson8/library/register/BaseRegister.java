package com.agentred.lessons.lesson8.library.register;

import java.util.ArrayList;

public class BaseRegister implements Register{

    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    public ArrayList<Note> getNotes() {
        return notes;
    }

}
