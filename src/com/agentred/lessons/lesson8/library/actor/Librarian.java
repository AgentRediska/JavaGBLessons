package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.Note;
import com.agentred.lessons.lesson8.library.book.Archive;
import com.agentred.lessons.lesson8.library.book.Book;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;
import com.agentred.lessons.lesson8.library.register.Register;

import java.util.ArrayList;

public class Librarian {

    private Register register;
    private final String fullName;
    private ArrayList<ReadingRoom> readingRooms = new ArrayList<>();
    private final Archive archive = new Archive();

    public Librarian(Register register, String fullName) {
        this.register = register;
        this.fullName = fullName;
    }

    public void addNote(int visitorTicket, int numberReadingRoom, String nameBook) {
        Note note = new Note(visitorTicket, numberReadingRoom, nameBook);
        register.addNote(note);
    }

    public void deleteNote(int visitorTicket) {
        for (Note note : register.getNotes()) {
            if (note.getVisitorTicket() == visitorTicket) {
                register.getNotes().remove(note);
                System.out.println("Всего хорошего, приходите ещё!");
            }
        }
    }

    private boolean checkNote(int visitorTicket) {
        ArrayList<Note> notes = register.getNotes();
        for (Note note : notes) {
            if (note.getVisitorTicket() == visitorTicket) {
                return true;
            }
        }
        System.out.println("Такой номерок занят, выберу другой номерок для Вас");
        return false;
    }

    private int generateTicket() {
        int number;
        do {
            number = 43;
        } while (!checkNote(number));
        System.out.println("Вы записаны. Ваш номерок: " + number);
        return number;
    }

    public void offerBookToVisitor() {
        System.out.println("Вот список наших книг:\n");
        for (Book book : archive.getBooks()) {
            System.out.println(book.getName());
        }
        System.out.println("Какую книгу хотите выбрать?:\n");
    }

    public void giveBookToVisitor(String bookName, Visitor visitor) {
        if (!isBookWithVisitor(visitor.getNumberTicket())) {
            for (Book book : archive.getBooks()) {
                if (bookName.equals(book.getName())) {
                    archive.pickUpBook(bookName);
                    System.out.println("Вот Ваша книга");
                    addVisitorToReadingRoom(bookName);
                    visitor.setBook(book);
                }
            }
        }
    }

    private boolean isBookWithVisitor(int visitorTicket) {
        ArrayList<Note> notes = register.getNotes();
        for (Note note : notes) {
            if (note.getVisitorTicket() == visitorTicket) {
                System.out.println("У вас уже есть книга. Вы не можете взять больше");
                return false;
            }
        }
        return true;
    }

    public void takeBookWithVisitor(int visitorTicket, Book book) {
        deleteNote(visitorTicket);
        archive.addBook(book);
    }

    public void memorizeNewReadingRoom(ReadingRoom readingRoom) {
        readingRooms.add(readingRoom);
        System.out.println("Окей, я понял, что у нас появился новый читательный зал");

    }

    public void forgetReadingRoom(ReadingRoom readingRoom) {
        readingRooms.remove(readingRoom);
        System.out.println("Окей, я понял, что читательный зал закрылся");
    }

    public int checkCountVisitorInReadingRoom(int numberReadingRoom) {
        for (ReadingRoom readingRoom : readingRooms) {
            if (numberReadingRoom == readingRoom.getNumberReadingRoom()) {
                return readingRoom.getMaxVisitorCount();
            }
        }
        return 0;
    }

    public void addVisitorToReadingRoom(String nameBook) {
        for (ReadingRoom readingRoom : readingRooms) {
            int count = checkCountVisitorInReadingRoom(readingRoom.getNumberReadingRoom());
            if (count < readingRoom.getMaxVisitorCount()) {
                int ticketNumber = generateTicket();
                addNote(ticketNumber, readingRoom.getNumberReadingRoom(), nameBook);
                System.out.println("Пройдите в читальный зал номер " + readingRoom.getNumberReadingRoom());
                break;
            }
        }
    }
}
