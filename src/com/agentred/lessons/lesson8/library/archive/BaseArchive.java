package com.agentred.lessons.lesson8.library.archive;

import java.util.ArrayList;

public class BaseArchive implements Archive{

    private final ArrayList<Book> books = new ArrayList<>();

    @Override
    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void pickUpBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                this.books.remove(book);
                System.out.println("Книга убрана из архива");
                break;
            }
        }
    }
}
