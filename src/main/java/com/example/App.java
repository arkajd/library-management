package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Library library = new Library();

        Book book1 = new Book("Atomic Habits", "James Clear");
        Book book2 = new Book("Change your habits", "Ash Doctor");

        library.addBook(book1);
        library.addBook(book2);

        library.lendBook("Atomic Habits");
        System.out.println(library.getBooks().toString());

        library.returnBook("Atomic Habits");
        System.out.println(library.getBooks().toString());
    }
}
