# Library-Management-System-Java
A simple, interactive command-line application built in Java to automate core university library operations. This project demonstrates foundational concepts of Object-Oriented Programming (OOP).
## 🚀 Key Features 

* **Pre-loaded Catalog:** Automatically loads 20 classic Sinhala literature books upon startup.
* **Member Management:** Register new library users with a unique Member ID.
* **Borrowing System:** Allows registered members to borrow books by title, updating availability status dynamically.
* **Returning System:** Hand back borrowed books to restore their status to "Available".
* **Crash Protection:** Implements robust `try-catch` error handling to prevent application crashes from invalid keyboard inputs.

---

## 🛠️ System Architecture & OOP Concepts Used 

The system is developed using 4 core Java classes to preserve clean code modularity:

1. **`Book.java`** - Manages state attributes (Title, Author, Borrowing status, Borrower entity). Demonstrates **Encapsulation**.
2. **`Member.java`** - Represents the system user profiles (ID, Name).
3. **`Library.java`** - Uses **`ArrayList`** collections to process backend business logic dynamically.
4. **`Main.java`** - Serves as the program execution controller and manages user interactions via an interactive console menu loop.
