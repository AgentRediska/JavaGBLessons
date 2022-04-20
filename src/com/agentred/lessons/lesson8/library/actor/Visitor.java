package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.book.Book;

public class Visitor {

    private int numberTicket;
    private Book book;

    public Visitor(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public void setBook(Book book) {
        if(this.book == null){
            this.book = book;
        } else {
            System.out.println("У посетителя уже есть книга");
        }
    }

    public Book getBook() {
        return this.book;
    }

    public void deleteBook() {
        this.book = null;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }
}
