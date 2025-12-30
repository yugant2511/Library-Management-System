import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add New Book");
            System.out.println("2. Register New Member");
            System.out.println("3. Display All Books");
            System.out.println("4. Display Available Books");
            System.out.println("5. Search Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();

                    library.addBook(new Book(isbn, title, author, genre));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    library.addMember(new Member(memberId, name, contact));
                    System.out.println("Member registered successfully!");
                    break;

                case 3:
                    library.displayAllBooks();
                    break;

                case 4:
                    library.displayAvailableBooks();
                    break;

                case 5:
                    System.out.print("Enter keyword (title/author/genre): ");
                    String keyword = sc.nextLine();

                    ArrayList<Book> results = library.searchBooks(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No books found!");
                    } else {
                        for (Book book : results) {
                            book.displayInfo();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Member ID: ");
                    memberId = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    isbn = sc.nextLine();

                    Member member = library.findMemberById(memberId);
                    Book book = library.findBookByIsbn(isbn);

                    if (member != null && book != null && member.borrowBook(book)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Borrowing failed!");
                    }
                    break;

                case 7:
                    System.out.print("Member ID: ");
                    memberId = sc.nextLine();
                    System.out.print("Book ISBN: ");
                    isbn = sc.nextLine();

                    member = library.findMemberById(memberId);
                    book = library.findBookByIsbn(isbn);

                    if (member != null && book != null && member.returnBook(book)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Return failed!");
                    }
                    break;

                case 8:
                    System.out.println("Exiting Library System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
