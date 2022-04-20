package com.agentred.lessons.lesson8.library;

import com.agentred.lessons.lesson8.library.actor.Librarian;
import com.agentred.lessons.lesson8.library.actor.Visitor;
import com.agentred.lessons.lesson8.library.archive.Archive;
import com.agentred.lessons.lesson8.library.archive.Book;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;
import com.agentred.lessons.lesson8.library.register.Register;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Война и мир");
        Book book2 = new Book("Мертвые души");

        Archive archive = new Archive();
        ReadingRoom readingRoom = new ReadingRoom(1, archive, 30);
        Register register = new Register();

        //первый день библиотекаря
        Librarian librarian = new Librarian(register, "Денис Петрович", archive);
        librarian.memorizeNewReadingRoom(readingRoom);

        //пришли новые книги в архив
        librarian.addBookToArchive(book);
        librarian.addBookToArchive(book2);

        // посетитель приходит
        Visitor visitor = new Visitor();
        ArrayList<String> nameBook = librarian.offerBookToVisitor();
        String nameChangedBook = visitor.changeBook(nameBook);
        int numberTicket = librarian.generateTicket();
        visitor.setNumberTicket(numberTicket);
        librarian.giveBookToVisitor(visitor.getNumberTicket(), nameChangedBook);

        // посетитель уходит
        Book bookOfVisitor = visitor.getBook();
        librarian.takeBookWithVisitor(visitor.getNumberTicket(), bookOfVisitor);
    }
}
