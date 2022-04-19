package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.register.Register;

public class Librarian {

    private Register register;
    private final String fullName;

    public Librarian(Register register, String fullName) {
        this.register = register;
        this.fullName = fullName;
    }
}
