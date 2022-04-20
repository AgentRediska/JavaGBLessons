package com.agentred.lessons.lesson8.library;

import com.agentred.lessons.lesson8.library.actor.Librarian;
import com.agentred.lessons.lesson8.library.actor.Visitor;
import com.agentred.lessons.lesson8.library.book.Archive;
import com.agentred.lessons.lesson8.library.book.Book;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;
import com.agentred.lessons.lesson8.library.register.Register;

public class Main {

    public static void main(String[] args) {
        Book book = new Book("Война и мир");
        Book book2 = new Book("Мертвые души");

        Archive archive = new Archive(1);

        ReadingRoom readingRoom = new ReadingRoom(1, archive, 30);

        Register register = new Register();
        register.addReadingRoom(readingRoom);

        Librarian librarian = new Librarian(register, "Денис Петрович");

        boolean res = librarian.getRegister().checkVisitorByTicket(1022);
        if(res){
            librarian.getRegister().setVisitor(1022);
        }
    }
}
