# Library Book Rental System

A Java-based console application for managing library books using Object-Oriented Programming principles. The system allows users to add, search, rent, and return books while maintaining transaction history and persistent storage through file handling.

## Features

- Add new books to the library
- Search books by ID or title
- Rent and return books
- Display available and rented books
- Maintain transaction history
- Save and load book records using file handling
- Generate 100 sample books for testing
- Simulate 500+ rental and return transactions
- Fast book lookup using HashMap

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (HashMap, ArrayList)
- File Handling
- Strategy Design Pattern
- Repository Design Pattern

## Project Structure

```
LibraryRentalSystem/
│── Book.java
│── Transaction.java
│── SearchStrategy.java
│── SearchById.java
│── SearchByTitle.java
│── LibraryRepository.java
│── FileManager.java
│── Library.java
│── Main.java
│── books.txt
│── README.md
```

## How to Run

1. Clone the repository.

```bash
git clone https://github.com/Harshitha2866/library-book-rental-system-java.git
```

2. Open the project in IntelliJ IDEA, Eclipse, or VS Code.

3. Compile the project.

```bash
javac *.java
```

4. Run the application.

```bash
java Main
```

## Menu Options

- Add Book
- Search Book by ID
- Search Book by Title
- Rent Book
- Return Book
- Display Available Books
- Display Rented Books
- View Transaction History
- Simulate 500 Transactions
- Exit

## What I Learned

This project helped me strengthen my understanding of:

- Object-Oriented Programming concepts
- Java Collections Framework
- File handling for persistent data storage
- Strategy and Repository design patterns
- Building a modular, menu-driven Java application

## Future Improvements

- User and Admin authentication
- Due date and late fee calculation
- Book categories and filters
- Database integration using MySQL
- Graphical User Interface using JavaFX or Swing
- Online book reservation

## Author

Harshitha Minnikanti

B.Tech – Artificial Intelligence & Data Science
