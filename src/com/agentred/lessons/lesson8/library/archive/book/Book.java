package com.agentred.lessons.lesson8.library.archive.book;

import java.util.ArrayList;

public class Book {

    private final String name;

    private final ArrayList<Genre> genres;

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public Book(String name, ArrayList<Genre> genres) {
        this.genres = genres;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
