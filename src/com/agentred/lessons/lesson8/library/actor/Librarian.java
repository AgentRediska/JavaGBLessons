package com.agentred.lessons.lesson8.library.actor;

import com.agentred.lessons.lesson8.library.archive.book.Genre;
import com.agentred.lessons.lesson8.library.register.Note;
import com.agentred.lessons.lesson8.library.archive.Archive;
import com.agentred.lessons.lesson8.library.archive.book.Book;
import com.agentred.lessons.lesson8.library.radingroom.ReadingRoom;
import com.agentred.lessons.lesson8.library.register.Register;

import java.util.ArrayList;

public class Librarian {

    private Register register;
    private final String fullName;
    private ArrayList<ReadingRoom> readingRooms = new ArrayList<>();
    private final Archive archive;

    public Librarian(Register register, String fullName, Archive archive) {
        this.archive = archive;
        this.register = register;
        this.fullName = fullName;
    }

    public void addNote(int visitorTicket, int numberReadingRoom, String nameBook) {
        Note note = new Note(visitorTicket, numberReadingRoom, nameBook);
        register.getNotes().add(note);
    }

    private void deleteNote(int visitorTicket) {
        for (Note note : register.getNotes()) {
            if (note.getVisitorTicket() == visitorTicket) {
                register.getNotes().remove(note);
                System.out.println("Всего хорошего, приходите ещё!");
            }
        }
    }

    public boolean checkNote(int visitorTicket) {
        ArrayList<Note> notes = register.getNotes();
        if (notes.isEmpty()) {
            return true;
        } else {
            for (Note note : notes) {
                if (note.getVisitorTicket() == visitorTicket) {
                    return true;
                }
            }
            System.out.println("Такой номерок занят, выберу другой номерок для Вас");
            return false;
        }
    }

    public int generateTicket() {
        int number;
        do {
            number = 43;
        } while (!checkNote(number));
        System.out.println("Вы записаны. Ваш номерок: " + number);
        return number;
    }

    public ArrayList<String> offerBookToVisitor() {
        System.out.println("Вот список наших книг, которые хранятся в архиве:");
        ArrayList<String> namesBook = new ArrayList<>();
        for (Book book : archive.getBooks()) {
            namesBook.add(book.getName());
            System.out.println(book.getName());
        }
        System.out.println("Какую книгу хотите выбрать?");
        return namesBook;
    }

    public Book giveBookToVisitor(int numberTicket, String bookName) {
        if (!isBookWithVisitor(numberTicket)) {
            for (Book b : archive.getBooks()) {
                if (b.getName().equals(bookName)) {
                    archive.pickUpBook(bookName);
                    System.out.println("Вот Ваша книга");
                    addVisitorToReadingRoom(bookName, numberTicket);
                    return b;
                }
            }
        }
        return null;
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
        addBookToArchive(book);
        System.out.println("Спасибо, приходите ещё");
    }

    public void memorizeNewReadingRoom(ReadingRoom readingRoom) {
        readingRooms.add(readingRoom);
        System.out.println("Окей, я понял, что у нас появился новый читательный зал\n");

    }

    public void forgetReadingRoom(ReadingRoom readingRoom) {
        readingRooms.remove(readingRoom);
        System.out.println("Окей, я понял, что читательный зал закрылся");
    }

    private int checkCountVisitorInReadingRoom(int numberReadingRoom) {
        for (ReadingRoom readingRoom : readingRooms) {
            if (numberReadingRoom == readingRoom.getNumberReadingRoom()) {
                return readingRoom.getMaxVisitorCount();
            }
        }
        return 0;
    }

    private void addVisitorToReadingRoom(String nameBook, int numberTicket) {
        for (ReadingRoom readingRoom : readingRooms) {
            int count = checkCountVisitorInReadingRoom(readingRoom.getNumberReadingRoom());
            if (count < readingRoom.getMaxVisitorCount()) {
                addNote(numberTicket, readingRoom.getNumberReadingRoom(), nameBook);
                System.out.println("Пройдите в читальный зал номер " + readingRoom.getNumberReadingRoom());
                break;
            }
        }
    }

    public void addBookToArchive(Book book) {
        archive.addBook(book);
    }

    private ArrayList<Book> getBooksByGenre(Genre genre) {
        ArrayList<Book> allBooks = archive.getBooks();
        ArrayList<Book> booksByGenre = new ArrayList<>();
        for (Book book : allBooks) {
            for (Genre g : book.getGenres()) {
                if (g == genre) {
                 booksByGenre.add(book);
                }
            }
        }
        return booksByGenre;
    }

    public void suggestBooksByGenre(Genre genre) {
        ArrayList<Book> books = getBooksByGenre(genre);
        System.out.println("Здравствуйте. Хочу предложить Вам книги с жанром " + genre);
        for (Book b : books) {
            System.out.println(b.getName());
        }
    }
}
