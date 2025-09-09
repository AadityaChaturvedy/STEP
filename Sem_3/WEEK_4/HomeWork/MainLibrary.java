class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // Default constructor
    Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.isAvailable = true;
    }

    // Constructor with title and author
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.isAvailable = true;
    }

    // Full constructor
    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if(isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned successfully.");
    }

    void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + 
                ", ISBN: " + isbn + ", Available: " + isAvailable);
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Harry Potter", "J.K. Rowling", "HP123", true);

        b2.borrowBook();
        b3.borrowBook();
        b3.returnBook();

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
