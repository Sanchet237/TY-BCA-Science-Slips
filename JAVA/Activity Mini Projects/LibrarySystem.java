import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void displayBook() {
        System.out.println(id + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available"));
    }
}

class Library {
    Book[] books;
    int count;

    Library(int size) {
        books = new Book[size];
        count = 0;
    }

    void addBook(int id, String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(id, title, author);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full!");
        }
    }

    void issueBook(int id) {
        for (Book b : books) {
            if (b != null && b.id == id) {
                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b != null && b.id == id) {
                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void showBooks() {
        System.out.println("ID | Title | Author | Status");
        for (Book b : books) {
            if (b != null) b.displayBook();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(5);

        int choice;
        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib.addBook(id, title, author);
                }
                case 2 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                }
                case 3 -> {
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                }
                case 4 -> lib.showBooks();
                case 5 -> System.out.println("Exiting Library System...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
