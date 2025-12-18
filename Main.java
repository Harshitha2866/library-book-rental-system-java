import java.util.Scanner;

public class Main{
    public static void main (String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide the library name as a command line argument.");
            return;
        }

        String libraryName = args[0];
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Welcome to " + libraryName + " =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Rent Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Available Books");
            System.out.println("6. Show Rented Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    library.addBook(new Book(id, title, author, price));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter title to search: ");
                    Book found = library.searchBook(sc.nextLine());
                    if (found != null) found.displayDetails();
                    else System.out.println("Book not found.");
                    break;

                case 3:
                    System.out.print("Enter Book ID to rent: ");
                    library.rentBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    library.displayRentedBooks();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}
