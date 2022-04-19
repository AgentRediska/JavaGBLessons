package com.agentred.lessons.lesson8.library.book;

import java.util.ArrayList;

public class Archive {

    private final int numberArchive;
    private final ArrayList<Book> books = new ArrayList<>();

    public Archive(int numberArchive) {
        this.numberArchive = numberArchive;
    }

    public int getNumberArchive() {
        return numberArchive;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void pickUpBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                this.books.remove(book);
                break;
            }
        }
    }
}
