package com.agentred.lessons.lesson8.library;

import com.agentred.lessons.lesson8.library.actor.Librarian;
import com.agentred.lessons.lesson8.library.actor.Visitor;
import com.agentred.lessons.lesson8.library.archive.BaseArchive;
import com.agentred.lessons.lesson8.library.archive.book.Book;
import com.agentred.lessons.lesson8.library.archive.book.Genre;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;
import com.agentred.lessons.lesson8.library.register.BaseRegister;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //создать книги
        ArrayList<Genre> genres1 = new ArrayList<>();
        genres1.add(Genre.Crime);
        genres1.add(Genre.Romance);
        Book book = new Book("Война и мир", genres1);
        ArrayList<Genre> genres2 = new ArrayList<>();
        genres2.add(Genre.Fantasy);
        genres2.add(Genre.Horror);
        Book book2 = new Book("Мертвые души", genres2);

        BaseArchive archive = new BaseArchive();
        ReadingRoom readingRoom = new ReadingRoom(1, archive, 30);
        BaseRegister register = new BaseRegister();

        //первый день библиотекаря
        Librarian librarian = new Librarian(register, "Денис Петрович", archive);
        librarian.memorizeNewReadingRoom(readingRoom);

        //пришли новые книги в архив
        librarian.addBookToArchive(book);
        librarian.addBookToArchive(book2);

        // посетитель приходит
        Visitor visitor = new Visitor();
        librarian.suggestBooksByGenre(Genre.Crime);
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
