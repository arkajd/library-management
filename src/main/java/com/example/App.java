package com.example;

import com.example.models.Book;
import com.example.service.BooksManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Book book1 = new Book("Atomic Habits", "James Clear");
        Book book2 = new Book("Change your habits", "Ash Doctor");

        BooksManager booksManager = new BooksManager();
        Library library = new Library(booksManager);
        library.addBook(book1);
        library.addBook(book2);
        library.lendBook(book1.getTitle());
        library.returnBook(book1.getTitle());
    }
}
