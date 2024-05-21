package com.example;

import com.example.exceptions.BookNotFoundException;
import com.example.exceptions.BookNotInInventoryException;
import com.example.exceptions.BookUnavailableException;
import com.example.models.Book;
import com.example.service.BooksManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private BooksManager booksManager;

    public Library(BooksManager booksManager){
        this.booksManager = booksManager;
    }

    public void addBook(Book book){
        booksManager.addBook(book);
    }

    public void findBook(String bookName){
        booksManager.findBook(bookName);
    }

    public void lendBook(String bookName){
        booksManager.lendBook(bookName);
    }

    public void returnBook(String bookName){
        booksManager.returnBook(bookName);
    }

}
