public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    private Member borrowedBy; // Holds the Member object who has the book

    // Constructor to initialize a new book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // By default, new books are available
        this.borrowedBy = null;  // No one has borrowed it yet
    }

    // Getters to fetch book details
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }
    public Member getBorrowedBy() { return borrowedBy; }

    // Method to assign a book to a user
    public void borrowBook(Member member) { 
        this.isBorrowed = true; 
        this.borrowedBy = member;
    }

    // Method to make a book available again
    public void returnBook() { 
        this.isBorrowed = false; 
        this.borrowedBy = null;
    }
}