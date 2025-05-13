package src.com.bantishaw.booktracker;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookTracker {
    private ArrayList<LibraryBook> libBook = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);

    public void start(){
        while (true) {
            System.out.println("1. Add Book, 2. View All, 3. Search Book, 4. Borrow Book, 5. Return Book, 6. View Borrowed Book, 0. Exit");
            System.out.println("Choose an option");
            int userChoice = 0;
            try{
                userChoice = Integer.parseInt(userInput.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Invalid input " + e);
                continue;
            }

            switch (userChoice) {
                case 1 -> addBook();
                case 2 -> viewAllBook();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> viewBorrowedBook();
                case 0 -> {
                    System.out.println("** Existing.... **");
                    return;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    public void addBook(){
        System.out.println("Enter Book Name:");
        String bookTitle = userInput.nextLine();
        
        System.out.println("Book Author:");
        String bookAuthor = userInput.nextLine();

        System.out.println("ISBN:");
        String bookIsbn = userInput.nextLine();

        libBook.add(new LibraryBook(bookTitle, bookAuthor, bookIsbn));
        System.out.println("*** Book Added Successfully ***");
    }

    public void viewAllBook(){
        if(libBook.isEmpty()){
            System.out.println("** No Books Found **");
        }else {
            for (LibraryBook libBook : libBook) {
                System.out.println(libBook);
            }
            // libBook.forEach(System.out::println);
        }
    }

    public void searchBook(){
        System.out.println("Enter name or author of the book");
        String bookWant = userInput.nextLine().toLowerCase();
        boolean found = false;
        for(LibraryBook book:libBook){
            if(book.getName().toLowerCase().contains(bookWant) || book.getAuthor().toLowerCase().contains(bookWant)){
                found = true;
                System.out.println(book);
                System.out.println("** Book exist in our library **");
            }
        }
        if(!found) System.out.println("** Book not found **");
    }

    public void borrowBook(){
        System.out.println("Enter ISBN to borrow the book?");
        String isbn = userInput.nextLine();
        for(LibraryBook book:libBook){
            if(book.getIsbn().equals(isbn)){
                if(book.getBorrowStatus()){
                    System.out.println("** Book is already borrowed by someone! **");
                }else {
                    book.bookBorrow();
                    System.out.println("** Book borrowed successfully! **");
                }
                return;
            }
        }
    }

    public void returnBook(){
        System.out.println("Enter ISBN to return the book.");
        String isbn = userInput.nextLine();
        for(LibraryBook book:libBook){
            if(book.getIsbn().equals(isbn)){
                if(book.getBorrowStatus()){
                    book.bookReturn();
                    System.out.println("** Book returned successfully! **");
                }else{
                    System.out.println("** Book is not borrowed by anyone! **");
                }
            }
        }

    }

    public void viewBorrowedBook(){
        boolean any = false;
        for(LibraryBook book:libBook){
            if(book.getBorrowStatus()){
                System.out.println(book);
                any = true;
            }
        }
        if(!any) System.out.println("** No book is borrowed till now. **");
    }

}
