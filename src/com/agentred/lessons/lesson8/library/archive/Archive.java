package com.agentred.lessons.lesson8.library.archive;

import com.agentred.lessons.lesson8.library.archive.book.Book;

import java.util.ArrayList;

public interface Archive {

    ArrayList<Book> getBooks();

    void addBook(Book book);

    void pickUpBook(String bookName);
}
