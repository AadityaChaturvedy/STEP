class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 1;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public static String generateBookId() {
        String id = String.format("B%03d", bookCounter);
        bookCounter++;
        return id;
    }

    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            return true;
        }
        return false;
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
        System.out.println("---------------------------");
    }

    public String getBookId() {
        return bookId;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int memberCounter = 1;

    public Member(String memberName, int maxBooks) {
        this.memberId = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[maxBooks];
        this.bookCount = 0;
    }

    public static String generateMemberId() {
        String id = String.format("M%03d", memberCounter);
        memberCounter++;
        return id;
    }

    public void borrowBook(Book book) {
        if (book.getIsAvailable() && bookCount < booksIssued.length) {
            if (book.issueBook()) {
                booksIssued[bookCount] = book.getBookId();
                bookCount++;
                System.out.println(memberName + " borrowed book: " + book.getBookId());
            }
        } else {
            System.out.println("Cannot borrow book: " + book.getBookId());
        }
    }

    public void returnBook(String bookId, Book[] books) {
        int idx = -1;
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            for (Book book : books) {
                if (book.getBookId().equals(bookId)) {
                    if (book.returnBook()) {
                        System.out.println(memberName + " returned book: " + bookId);
                        // Remove bookId from booksIssued
                        for (int j = idx; j < bookCount - 1; j++) {
                            booksIssued[j] = booksIssued[j + 1];
                        }
                        booksIssued[bookCount - 1] = null;
                        bookCount--;
                    }
                    return;
                }
            }
        } else {
            System.out.println("Book ID " + bookId + " not found in issued books for " + memberName);
        }
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + memberName);
        System.out.print("Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        System.out.println("\n---------------------------");
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        // Create books
        Book[] books = new Book[3];
        books[0] = new Book("Java Programming", "James Gosling");
        books[1] = new Book("Python Basics", "Guido van Rossum");
        books[2] = new Book("C++ Primer", "Stanley Lippman");

        // Create members
        Member[] members = new Member[2];
        members[0] = new Member("Alice", 2);
        members[1] = new Member("Bob", 2);

        // Borrow books
        members[0].borrowBook(books[0]);
        members[0].borrowBook(books[1]);
        members[1].borrowBook(books[1]); // Should fail, already issued
        members[1].borrowBook(books[2]);

        // Display info
        for (Book book : books) {
            book.displayBookInfo();
        }
        for (Member member : members) {
            member.displayMemberInfo();
        }

        // Return books
        members[0].returnBook(books[0].getBookId(), books);
        members[1].borrowBook(books[0]); // Now should succeed

        // Display info after return
        for (Book book : books) {
            book.displayBookInfo();
        }
        for (Member member : members) {
            member.displayMemberInfo();
        }

        // Show statistics
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}