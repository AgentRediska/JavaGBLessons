package com.agentred.lessons.lesson8.library.archive;

import java.util.ArrayList;

public interface Archive {

    ArrayList<Book> getBooks();

    void addBook(Book book);

    void pickUpBook(String bookName);
}
