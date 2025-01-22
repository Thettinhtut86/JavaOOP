import model.Book;
import model.Fiction;
import model.NonFiction;
import service.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();


        while(true){
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    searchBook(scanner, library);
                    break;
                case 4:
                    updateBook(scanner, library);
                    break;
                case 5:
                    deleteBook(scanner, library);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addBook(Scanner scanner, Library library) {
        String type = readNonEmptyString(scanner, "Enter type (Fiction/NonFiction): ", "Type cannot be empty.");

        String title = readNonEmptyString(scanner, "Enter title: ", "Title cannot be empty.");

        String author = readNonEmptyString(scanner, "Enter author: ", "Author cannot be empty.");

        int year = readIntInRange(scanner, "Enter publication year: ", "Please enter a valid year.", 0, 9999);

        if (type.equalsIgnoreCase("Fiction")) {
            library.addBook(new Fiction(0,title, author, year));
        } else if (type.equalsIgnoreCase("NonFiction")) {
            library.addBook(new NonFiction(0,title, author, year));
        } else {
            System.out.println("Invalid type! Please enter 'Fiction' or 'NonFiction'.");
        }
    }
    private static void searchBook(Scanner scanner, Library library) {

        String searchTitle = readNonEmptyString(scanner, "Enter book Id or title to search: ", "Id or Title cannot be empty.");
        Book book = library.searchBook(searchTitle);
        if (book != null) {
            book.displayDetails();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Overloaded searchBook by ID
    private static void searchBook(Scanner scanner, Library library, int id) {

        Book book = library.searchBook(id);
        if (book != null) {
            book.displayDetails();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Overloaded updateBook methods based on title and ID
    private static void updateBook(Scanner scanner, Library library) {
        String oldTitle = readNonEmptyString(scanner, "Enter title of the book to update: ", "Title cannot be empty.");
        String newTitle = readNonEmptyString(scanner, "Enter new title: ", "Title cannot be empty.");
        String newAuthor = readNonEmptyString(scanner, "Enter new author: ", "Author cannot be empty.");
        int newYear = readIntInRange(scanner, "Enter new publication year: ", "Please enter a valid year.", 0, 9999);
        library.updateBook(oldTitle, newTitle, newAuthor, newYear);
    }
    // Overloaded updateBook by ID
    private static void updateBook(Scanner scanner, Library library, int id) {
        String newTitle = readNonEmptyString(scanner, "Enter new title: ", "Title cannot be empty.");
        String newAuthor = readNonEmptyString(scanner, "Enter new author: ", "Author cannot be empty.");
        int newYear = readIntInRange(scanner, "Enter new publication year: ", "Please enter a valid year.", 0, 9999);
        library.updateBook(id, newTitle, newAuthor, newYear);
    }

    private static void deleteBook(Scanner scanner, Library library) {
        System.out.println("Delete book by:");
        System.out.println("1. Title");
        System.out.println("2. ID");
        int option = readIntInRange(scanner, "Choose option (1 or 2): ", "Invalid option.", 1, 2);

        if (option == 1) {
            // Delete by Title
            String deleteTitle = readNonEmptyString(scanner, "Enter title of the book to delete: ", "Title cannot be empty.");
            library.deleteBook(deleteTitle);
        } else {
            // Delete by ID
            int id = readIntInRange(scanner, "Enter book ID to delete: ", "Invalid ID.", 1, Integer.MAX_VALUE);
            library.deleteBook(id);
        }
    }

    private static int readIntInRange(Scanner scanner, String prompt, String errorMessage, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }

    private static String readNonEmptyString(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }
}