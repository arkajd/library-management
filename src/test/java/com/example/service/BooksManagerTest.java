package com.example.service;

import com.example.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BooksManagerTest {

    private BooksManager booksManager;

    @BeforeEach
    public void setup(){
        booksManager = new BooksManager();
    }

    @Test
    void addOneBook() {
        Book book = new Book("Clean code", "Uncle bob");
        booksManager.addBook(book);
        assertEquals(1, booksManager.getBooks().size());
        assertTrue(booksManager.getBooks().contains(book));
    }

    @Test
    void findBook() {
        String title = "Clean code";
        String author = "Uncle bob";
        Book book = new Book(title, author);
        booksManager.addBook(book);

        Optional<Book> optionalBook = booksManager.findBook(title);
        assertTrue(optionalBook.isPresent());
        assertEquals(book, optionalBook.get());
    }

    @Test
    void lendBook() {
        String title = "Clean code";
        String author = "Uncle bob";
        Book book = new Book(title, author);
        booksManager.addBook(book);

        booksManager.lendBook(title);

        boolean expectedResult = false;
        Optional<Book> optionalBook = booksManager.getBooks().stream().filter(book1 -> book1.getTitle().equals(title)).findFirst();
        if(optionalBook.isPresent()){
            expectedResult = optionalBook.get().isAvailable();
        }
        assertFalse(expectedResult);
    }

    @Test
    void returnBook() {
        String title = "Clean code";
        String author = "Uncle bob";
        Book book = new Book(title, author);
        booksManager.addBook(book);

        booksManager.lendBook(title);
        booksManager.returnBook(title);
        Book returnedBook = booksManager.getBooks().get(0);
        assertTrue(returnedBook.isAvailable());
    }
}