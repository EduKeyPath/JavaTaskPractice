package src.com.bantishaw.booktracker;

public class LibraryBook {
    public String bookName;
    public String bookAuthor;
    public String bookIsbn;
    public boolean bookBorrow;

    public LibraryBook(String name, String author, String isbn){
        this.bookName = name;
        this.bookAuthor = author;
        this.bookIsbn = isbn;
        this.bookBorrow = false;
    }

    public String getName(){return bookName; }
    public String getAuthor() { return bookAuthor; }
    public String getIsbn() { return bookIsbn; }
    public Boolean getBorrowStatus() { return bookBorrow; }

    public void bookBorrow(){ this.bookBorrow = true; }
    public void bookReturn(){ this.bookBorrow = false; }

    @Override
    public String toString(){
        return bookName + " by " + bookAuthor + " (ISBN" + bookIsbn + ") - " + (bookBorrow ? "Borrowed" : "Available");
    }
}
