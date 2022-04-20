package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.archive.Book;

import java.util.ArrayList;

public class Visitor {

    private int numberTicket;
    private Book book;

    public void takeBook(Book book) {
        this.book = book;
    }

    public String changeBook(ArrayList<String> namesBook) {
        System.out.println("Я хочу взять " + namesBook.get(1));
        return namesBook.get(1);
    }

    public Book getBook() {
        System.out.println("Возьмите книгу, я прочел что хотел");
        return this.book;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

}
