import java.util.*;

class Book {
    int id;
    String title;
    boolean available;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }
}

public class LibrarySystem {
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        books.add(new Book(1, "Java"));
        books.add(new Book(2, "Python"));
        books.add(new Book(3, "DSA"));

        while (true) {
            System.out.println("\n1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    issueBook(sc);
                    break;
                case 3:
                    returnBook(sc);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    static void viewBooks() {
        for (Book b : books) {
            System.out.println(b.id + " - " + b.title + " - " + (b.available ? "Available" : "Issued"));
        }
    }

    static void issueBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.available) {
                b.available = false;
                System.out.println("Book Issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.available) {
                b.available = true;
                System.out.println("Book Returned!");
                return;
            }
        }
        System.out.println("Invalid ID!");
    }
}
