package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.book.Book;

public class Visitor {

    private int numberTicket;
    private int noiseLvl;
    private Book book;

    public Visitor(int numberTicket, int noiseLvl) {
        this.numberTicket = numberTicket;
        this.noiseLvl = noiseLvl;
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

    public int getNoiseLvl() {
        return noiseLvl;
    }

    public void setNoiseLvl(int noiseLvl) {
        this.noiseLvl = noiseLvl;
    }
}
