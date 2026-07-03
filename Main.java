import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String libraryName = "Smart Library";

        if (args.length > 0) {
            libraryName = args[0];
        }

        Library library = new Library();

        // Generate 100 books only if library is empty
        if (library.getTotalBooks() == 0) {

            for (int i = 1; i <= 100; i++) {

                library.addBook(new Book(
                        i,
                        "Book " + i,
                        "Author " + i,
                        200 + i
                ));

            }

            System.out.println("100 Sample Books Added Successfully.");
        }

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== " + libraryName + " ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Search Book By Title");
            System.out.println("4. Rent Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Available Books");
            System.out.println("7. Display Rented Books");
            System.out.println("8. Show Transaction History");
            System.out.println("9. Simulate 500 Transactions");
            System.out.println("10. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Book ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Title : ");
                    String title = sc.nextLine();

                    System.out.print("Author : ");
                    String author = sc.nextLine();

                    System.out.print("Price : ");
                    double price = sc.nextDouble();

                    library.addBook(new Book(id, title, author, price));

                    break;

                case 2:

                    System.out.print("Enter Book ID : ");

                    Book b1 = library.search(
                            new SearchById(),
                            String.valueOf(sc.nextInt())
                    );

                    if (b1 != null)
                        System.out.println(b1);
                    else
                        System.out.println("Book Not Found");

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Title : ");

                    Book b2 = library.search(
                            new SearchByTitle(),
                            sc.nextLine()
                    );

                    if (b2 != null)
                        System.out.println(b2);
                    else
                        System.out.println("Book Not Found");

                    break;

                case 4:

                    System.out.print("Book ID : ");

                    library.rentBook(sc.nextInt());

                    break;

                case 5:

                    System.out.print("Book ID : ");

                    library.returnBook(sc.nextInt());

                    break;

                case 6:

                    library.displayAvailableBooks();

                    break;

                case 7:

                    library.displayRentedBooks();

                    break;

                case 8:

                    library.displayTransactions();

                    break;

                case 9:

                    Random random = new Random();

                    for (int i = 0; i < 500; i++) {

                        int bookId = random.nextInt(100) + 1;

                        if (random.nextBoolean())
                            library.rentBook(bookId);
                        else
                            library.returnBook(bookId);

                    }

                    System.out.println("500 Transactions Completed.");

                    break;

                case 10:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice");

            }

        } while (choice != 10);

        sc.close();

    }

}
