import java.util.ArrayList;

public class Library {
    // Dynamic lists to store multiple book and member objects
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    // 1. Add a new book to the storage list
    public void addBook(Book book) {
        books.add(book);
    }

    // 2. Register a new member to the system
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Success: Member \"" + member.getName() + "\" registered with ID: " + member.getMemberId());
    }

    // 3. Print all library books with their current statuses
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library database has no books.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            String status = "Available";
            if (book.isBorrowed()) {
                status = "Borrowed by " + book.getBorrowedBy().getName() + " (ID: " + book.getBorrowedBy().getMemberId() + ")";
            }
            System.out.println("Title: " + book.getTitle() + " | Author: " + book.getAuthor() + " | Status: " + status);
        }
    }

    // 4. Handle borrowing logic using Book Title and Member ID
    public void borrowBook(String title, String memberId) {
        // Step A: Find if the user exists
        Member targetMember = null;
        for (Member m : members) {
            if (m.getMemberId().equalsIgnoreCase(memberId)) {
                targetMember = m;
                break;
            }
        }

        if (targetMember == null) {
            System.out.println("Error: Member ID not found. Register the member first.");
            return;
        }

        // Step B: Find the book and assign it to the member
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrowBook(targetMember);
                    System.out.println("Success: \"" + title + "\" borrowed by " + targetMember.getName());
                } else {
                    System.out.println("Error: This book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Error: Book not found in library.");
    }

    // 5. Handle returning logic
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("Success: \"" + title + "\" returned successfully.");
                } else {
                    System.out.println("Message: This book is already in the library.");
                }
                return;
            }
        }
        System.out.println("Error: Book not found.");
    }
}