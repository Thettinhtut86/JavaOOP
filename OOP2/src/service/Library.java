package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private int currentId = 1;

    public void addBook(Book book){
        book.setId(currentId++);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayDetails();
            }
        }
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    //method overloading
    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(String title, String newTitle, String newAuthor, int newYear) {
        Book book = searchBook(title);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setReleasedYear(newYear);
            System.out.println("Book details updated.");
        } else {
            System.out.println("Book not found.");
        }
    }
    //method overloading
    public void updateBook(int id, String newTitle, String newAuthor, int newYear) {
        Book book = searchBook(id);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setReleasedYear(newYear);
            System.out.println("Book details updated.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook(String title) {
        Book book = searchBook(title);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    //method overloading
    public void deleteBook(int id) {
        Book book = searchBook(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

}
