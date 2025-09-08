import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;
    private int timesIssued;

    // Static variables
    public static int totalBooks = 0;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
        this.timesIssued = 0;
        totalBooks++;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getCategory() { return category; }
    public boolean getIsIssued() { return isIssued; }
    public String getIssueDate() { return issueDate; }
    public String getDueDate() { return dueDate; }
    public int getTimesIssued() { return timesIssued; }

    public void issue(String issueDate, String dueDate) {
        isIssued = true;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        timesIssued++;
    }

    public void returnBook() {
        isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
    }

    public void renew(String newDueDate) {
        this.dueDate = newDueDate;
    }

    public void displayBook() {
        System.out.printf("%-7s %-20s %-15s %-13s %-10s %-8s %-12s %-12s\n",
            bookId, title, author, isbn, category, isIssued ? "Issued" : "Available", issueDate, dueDate);
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String memberType;
    private Book[] booksIssued;
    private int booksCount;
    private double totalFines;
    private String membershipDate;

    // Static variables
    public static int totalMembers = 0;
    public static String libraryName = "City Central Library";
    public static double finePerDay = 2.0;
    public static int maxBooksAllowed = 3;

    public Member(String memberId, String memberName, String memberType, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new Book[getMaxBooksAllowedForType(memberType)];
        this.booksCount = 0;
        this.totalFines = 0.0;
        totalMembers++;
    }

    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
    public String getMemberType() { return memberType; }
    public Book[] getBooksIssued() { return booksIssued; }
    public double getTotalFines() { return totalFines; }
    public String getMembershipDate() { return membershipDate; }

    public int getMaxBooksAllowedForType(String type) {
        switch (type.toLowerCase()) {
            case "student": return 3;
            case "faculty": return 5;
            case "general": return 2;
            default: return maxBooksAllowed;
        }
    }

    public int getBorrowDaysForType(String type) {
        switch (type.toLowerCase()) {
            case "student": return 14;
            case "faculty": return 30;
            case "general": return 7;
            default: return 14;
        }
    }

    public boolean issueBook(Book book, String issueDate) {
        if (booksCount >= getMaxBooksAllowedForType(memberType)) {
            System.out.println("Max books issued for " + memberType + ".");
            return false;
        }
        if (book.getIsIssued()) {
            System.out.println("Book already issued.");
            return false;
        }
        Calendar cal = Calendar.getInstance();
        String[] parts = issueDate.split("-");
        cal.set(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        cal.add(Calendar.DAY_OF_MONTH, getBorrowDaysForType(memberType));
        String dueDate = String.format("%d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        book.issue(issueDate, dueDate);
        booksIssued[booksCount++] = book;
        System.out.println("Book issued. Due date: " + dueDate);
        return true;
    }

    public boolean returnBook(String bookId, String returnDate) {
        for (int i = 0; i < booksCount; i++) {
            if (booksIssued[i].getBookId().equals(bookId)) {
                double fine = calculateFine(booksIssued[i], returnDate);
                totalFines += fine;
                booksIssued[i].returnBook();
                // Remove book from array
                for (int j = i; j < booksCount - 1; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                booksIssued[booksCount - 1] = null;
                booksCount--;
                System.out.printf("Book returned. Fine: $%.2f\n", fine);
                return true;
            }
        }
        System.out.println("Book not found in issued list.");
        return false;
    }

    public double calculateFine(Book book, String returnDate) {
        try {
            String[] due = book.getDueDate().split("-");
            String[] ret = returnDate.split("-");
            Calendar dueCal = Calendar.getInstance();
            Calendar retCal = Calendar.getInstance();
            dueCal.set(Integer.parseInt(due[0]), Integer.parseInt(due[1]), Integer.parseInt(due[2]));
            retCal.set(Integer.parseInt(ret[0]), Integer.parseInt(ret[1]), Integer.parseInt(ret[2]));
            long diff = retCal.getTimeInMillis() - dueCal.getTimeInMillis();
            int overdueDays = (int)(diff / (1000 * 60 * 60 * 24));
            return overdueDays > 0 ? overdueDays * finePerDay : 0.0;
        } catch (Exception e) {
            return 0.0;
        }
    }

    public boolean renewBook(String bookId, String newDueDate) {
        for (int i = 0; i < booksCount; i++) {
            if (booksIssued[i].getBookId().equals(bookId)) {
                booksIssued[i].renew(newDueDate);
                System.out.println("Book renewed. New due date: " + newDueDate);
                return true;
            }
        }
        System.out.println("Book not found in issued list.");
        return false;
    }

    public Book[] searchBooks(Book[] books, String keyword) {
        List<Book> found = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                found.add(b);
            }
        }
        return found.toArray(new Book[0]);
    }

    public boolean reserveBook(Book book) {
        if (book.getIsIssued()) {
            System.out.println("Book reserved. You will be notified when available.");
            return true;
        } else {
            System.out.println("Book is available. No need to reserve.");
            return false;
        }
    }

    public void displayMember() {
        System.out.printf("%-7s %-15s %-10s %-12s $%-8.2f\n", memberId, memberName, memberType, membershipDate, totalFines);
        System.out.println("Books Issued:");
        for (int i = 0; i < booksCount; i++) {
            booksIssued[i].displayBook();
        }
    }

    // Static methods
    public static void generateLibraryReport(Book[] books, Member[] members) {
        System.out.println("\n--- Library Report ---");
        System.out.println("Total Books: " + Book.totalBooks);
        System.out.println("Total Members: " + totalMembers);
        double totalFines = 0;
        for (Member m : members) if (m != null) totalFines += m.getTotalFines();
        System.out.printf("Total Fines Collected: $%.2f\n", totalFines);
        int issuedBooks = 0;
        for (Book b : books) if (b.getIsIssued()) issuedBooks++;
        System.out.println("Books Currently Issued: " + issuedBooks);
    }

    public static Book[] getOverdueBooks(Book[] books, String currentDate) {
        List<Book> overdue = new ArrayList<>();
        for (Book b : books) {
            if (b.getIsIssued()) {
                try {
                    String[] due = b.getDueDate().split("-");
                    String[] cur = currentDate.split("-");
                    Calendar dueCal = Calendar.getInstance();
                    Calendar curCal = Calendar.getInstance();
                    dueCal.set(Integer.parseInt(due[0]), Integer.parseInt(due[1]), Integer.parseInt(due[2]));
                    curCal.set(Integer.parseInt(cur[0]), Integer.parseInt(cur[1]), Integer.parseInt(cur[2]));
                    if (curCal.after(dueCal)) overdue.add(b);
                } catch (Exception e) {}
            }
        }
        return overdue.toArray(new Book[0]);
    }

    public static Book[] getMostPopularBooks(Book[] books) {
        Arrays.sort(books, (a, b) -> Integer.compare(b.getTimesIssued(), a.getTimesIssued()));
        int n = Math.min(3, books.length);
        Book[] popular = new Book[n];
        for (int i = 0; i < n; i++) popular[i] = books[i];
        return popular;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Sample books
        Book[] books = {
            new Book("B001", "Java Programming", "James Gosling", "978-0135166307", "Programming"),
            new Book("B002", "Data Structures", "Robert Lafore", "978-0672324536", "Computer Science"),
            new Book("B003", "Algorithms", "Thomas Cormen", "978-0262033848", "Computer Science"),
            new Book("B004", "Physics Fundamentals", "Isaac Newton", "978-1234567890", "Science"),
            new Book("B005", "Modern Chemistry", "Marie Curie", "978-0987654321", "Science"),
            new Book("B006", "World History", "Will Durant", "978-0451528125", "History"),
            new Book("B007", "English Grammar", "Noam Chomsky", "978-0199535954", "Language"),
            new Book("B008", "Calculus", "Gottfried Leibniz", "978-0321781079", "Mathematics"),
            new Book("B009", "Art of War", "Sun Tzu", "978-1590302255", "Strategy"),
            new Book("B010", "Psychology Basics", "Sigmund Freud", "978-0142437230", "Psychology")
        };

        // Sample members
        Member[] members = new Member[3];
        members[0] = new Member("M001", "Alice", "Student", "2022-01-15");
        members[1] = new Member("M002", "Bob", "Faculty", "2021-09-10");
        members[2] = new Member("M003", "Charlie", "General", "2023-03-05");

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- " + Member.libraryName + " Menu ---");
            System.out.println("1. Search books");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Renew book");
            System.out.println("5. Reserve book");
            System.out.println("6. View member info");
            System.out.println("7. Library report");
            System.out.println("8. Overdue books");
            System.out.println("9. Most popular books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    Book[] found = members[0].searchBooks(books, keyword); // Any member can search
                    System.out.printf("%-7s %-20s %-15s %-13s %-10s %-8s %-12s %-12s\n",
                        "BookID", "Title", "Author", "ISBN", "Category", "Status", "IssueDate", "DueDate");
                    for (Book b : found) b.displayBook();
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String mname = sc.nextLine();
                    Member mem = null;
                    for (Member m : members) if (m.getMemberName().equalsIgnoreCase(mname)) mem = m;
                    if (mem == null) { System.out.println("Member not found."); break; }
                    System.out.print("Enter book ID to issue: ");
                    String bid = sc.nextLine();
                    Book bookToIssue = null;
                    for (Book b : books) if (b.getBookId().equalsIgnoreCase(bid)) bookToIssue = b;
                    if (bookToIssue == null) { System.out.println("Book not found."); break; }
                    System.out.print("Enter issue date (YYYY-MM-DD): ");
                    String idate = sc.nextLine();
                    mem.issueBook(bookToIssue, idate);
                    break;
                case 3:
                    System.out.print("Enter member name: ");
                    mname = sc.nextLine();
                    mem = null;
                    for (Member m : members) if (m.getMemberName().equalsIgnoreCase(mname)) mem = m;
                    if (mem == null) { System.out.println("Member not found."); break; }
                    System.out.print("Enter book ID to return: ");
                    bid = sc.nextLine();
                    System.out.print("Enter return date (YYYY-MM-DD): ");
                    String rdate = sc.nextLine();
                    mem.returnBook(bid, rdate);
                    break;
                case 4:
                    System.out.print("Enter member name: ");
                    mname = sc.nextLine();
                    mem = null;
                    for (Member m : members) if (m.getMemberName().equalsIgnoreCase(mname)) mem = m;
                    if (mem == null) { System.out.println("Member not found."); break; }
                    System.out.print("Enter book ID to renew: ");
                    bid = sc.nextLine();
                    System.out.print("Enter new due date (YYYY-MM-DD): ");
                    String nddate = sc.nextLine();
                    mem.renewBook(bid, nddate);
                    break;
                case 5:
                    System.out.print("Enter member name: ");
                    mname = sc.nextLine();
                    mem = null;
                    for (Member m : members) if (m.getMemberName().equalsIgnoreCase(mname)) mem = m;
                    if (mem == null) { System.out.println("Member not found."); break; }
                    System.out.print("Enter book ID to reserve: ");
                    bid = sc.nextLine();
                    Book bookToReserve = null;
                    for (Book b : books) if (b.getBookId().equalsIgnoreCase(bid)) bookToReserve = b;
                    if (bookToReserve == null) { System.out.println("Book not found."); break; }
                    mem.reserveBook(bookToReserve);
                    break;
                case 6:
                    System.out.print("Enter member name: ");
                    mname = sc.nextLine();
                    mem = null;
                    for (Member m : members) if (m.getMemberName().equalsIgnoreCase(mname)) mem = m;
                    if (mem == null) { System.out.println("Member not found."); break; }
                    mem.displayMember();
                    break;
                case 7:
                    Member.generateLibraryReport(books, members);
                    break;
                case 8:
                    System.out.print("Enter current date (YYYY-MM-DD): ");
                    String cdate = sc.nextLine();
                    Book[] overdue = Member.getOverdueBooks(books, cdate);
                    System.out.println("Overdue Books:");
                    for (Book b : overdue) b.displayBook();
                    break;
                case 9:
                    Book[] popular = Member.getMostPopularBooks(books);
                    System.out.println("Most Popular Books:");
                    for (Book b : popular) b.displayBook();
                    break;
                case 0:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}