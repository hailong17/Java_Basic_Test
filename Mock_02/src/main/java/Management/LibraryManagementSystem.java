package Management;

import DAO.BookDao;
import Entities.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookDao bookDao = new BookDao();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("== Library Management System ==");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Remove a specific Book by name");
            System.out.println("4. Find Book by name or author");
            System.out.println("5. Display all Books");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    findBook();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.println("---------- Add Book ----------");
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Book book = new Book();
        book.setBookName(bookName);
        book.setPrice(price);

        try {
            bookDao.save(book);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateBook() {
        System.out.println("---------- Update Book ----------");
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();

        try {
            List<Book> books = bookDao.find(bookName);

            if (books.isEmpty()) {
                System.out.println("No book found with the given name.");
                return;
            }

            for (Book book : books) {
                System.out.println("Updating book with ID: " + book.getbID());
                System.out.print("Enter new price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter new genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter new author: ");
                String author = scanner.nextLine();
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter new status: ");
                String status = scanner.nextLine();
                System.out.print("Enter new total pages: ");
                int totalPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                book.setPrice(price);
                book.setGenre(genre);
                book.setAuthor(author);
                book.setQty(quantity);
                book.setStatus(status);
                book.setTotalPage(totalPages);

                try {
                    bookDao.update(book);
                    System.out.println("Book updated successfully.");
                } catch (SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeBook() {
        System.out.println("---------- Remove Book ----------");
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();

        try {
            bookDao.remove(bookName);
            System.out.println("Book removed successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void findBook() {
        System.out.println("---------- Find Book ----------");
        System.out.print("Enter book name or author: ");
        String query = scanner.nextLine();

        try {
            List<Book> books = bookDao.find(query);

            if (books.isEmpty()) {
                System.out.println("No book found with the given name or author.");
            } else {
                System.out.println("Books found:");
                displayBooks(books);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayAllBooks() {
        System.out.println("---------- All Books ----------");
//        try {
//            List<Book> books = bookDao.getAllBooks();
//
//            if (books.isEmpty()) {
//                System.out.println("No books found.");
//            } else {
//                displayBooks(books);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
    }

    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println("Book ID: " + book.getbID());
            System.out.println("Book Name: " + book.getBookName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: $" + book.getPrice());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Quantity: " + book.getQty());
            System.out.println("Status: " + book.getStatus());
            System.out.println("Total Pages: " + book.getTotalPage());
            System.out.println("-----------------------------");
        }
    }
}