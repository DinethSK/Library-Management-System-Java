import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        
        // --- POPULATING 20 BOOKS ---
        String[] sinhalaTitles = {
            "Gamperaliya", "Madol Doova", "Ape Gama", "Kaliyugaya", "Yuganthaya",
            "Viragaya", "Hevanella", "Malagiya Attho", "Gehenu Lamai", "Guru Geethaya",
            "Kaluwara Gedara", "Amba Yaluwo", "Subha Sandeshaya", "Magul Kema", "Hath Pana",
            "Semini", "Bava Tharanaya", "Sudo Sudu", "Karumakkarayo", "Senkottan"
        };

        String[] sinhalaAuthors = {
            "Martin Wickramasinghe", "Martin Wickramasinghe", "Martin Wickramasinghe", "Martin Wickramasinghe", "Martin Wickramasinghe",
            "Gunadasa Amarasekara", "Siri Gunasinghe", "Ediriweera Sarachchandra", "Karunasena Jayalath", "Chingiz Aitmatov",
            "K. Jayatillake", "T. B. Ilangaratne", "Alagiyawanna Mukaveti", "Kumaratunga Munidasa", "Kumaratunga Munidasa",
            "Siri Weerasinghe", "Martin Wickramasinghe", "Keyas", "Gunadasa Amarasekara", "Mahinda Prasad Masimbula"
        };

        // Loop to add the 20 Sinhala books into the system
        for (int i = 0; i < 20; i++) {
            library.addBook(new Book(sinhalaTitles[i], sinhalaAuthors[i]));
        }

        // Add a default system user
        library.registerMember(new Member("M001", "Kamal"));

        // --- CORE APPLICATION LOOP WITH CRASH PROTECTION ---
        while (true) {
            System.out.println("\n===== UNIVERSITY LIBRARY SYSTEM =====");
            System.out.println("1. View All Books");
            System.out.println("2. Add a New Book");
            System.out.println("3. Register a New Member");
            System.out.println("4. View All Members");
            System.out.println("5. Borrow a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice (1-7): ");
            
            int choice;
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear scanner input cache memory
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a number between 1 and 7, not text words!");
                scanner.nextLine(); // Clear the bad text input from memory
                continue; // Restart the loop menu again
            }

            if (choice == 1) {
                library.displayBooks();
                
            } else if (choice == 2) {
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(title, author));
                System.out.println("Success: Book added!");
                
            } else if (choice == 3) {
                System.out.print("Enter Member ID (e.g., M002): ");
                String id = scanner.nextLine();
                System.out.print("Enter Member Name: ");
                String name = scanner.nextLine();
                library.registerMember(new Member(id, name));
                
            } else if (choice == 4) {
                library.displayMembers();
                
            } else if (choice == 5) {
                System.out.print("Enter book title to borrow: ");
                String title = scanner.nextLine();
                System.out.print("Enter Member ID: ");
                String memberId = scanner.nextLine();
                library.borrowBook(title, memberId);
                
            } else if (choice == 6) {
                System.out.print("Enter book title to return: ");
                String title = scanner.nextLine();
                library.returnBook(title);
                
            } else if (choice == 7) {
                System.out.println("Thank you for using the library system!");
                break;
                
            } else {
                System.out.println("Invalid choice. Please select numbers 1 up to 7.");
            }
        }
        scanner.close();
    }
}
