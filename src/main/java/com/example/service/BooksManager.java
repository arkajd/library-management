package com.example.service;

import com.example.exceptions.BookNotFoundException;
import com.example.exceptions.BookNotInInventoryException;
import com.example.exceptions.BookUnavailableException;
import com.example.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BooksManager {

    private List<Book> books;

    public BooksManager(){
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public Optional<Book> findBook(String name){
        return books.stream().filter(book -> book.getTitle().equals(name)).findAny();
    }

    public void lendBook(String bookName){
        Optional<Book> optionalBook = findBook(bookName);
        Book book = optionalBook.orElseThrow(()-> new BookNotFoundException("Book not found:" + bookName));

        if(book.isAvailable()){
            book.setAvailable(false);
            System.out.println("Book lent: " + book.getTitle());
        }
        else{
            throw new BookUnavailableException("Book unavailable.");
        }
    }

    public void returnBook(String bookName){
        Optional<Book> optionalBook = findBook(bookName);

        Book book = optionalBook.orElseThrow(()->new BookNotFoundException("Book not found: " + bookName));

        if(!book.isAvailable()){
            book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        }
        else{
            throw new BookNotInInventoryException("This book does not belong to this library.");
        }
    }
}
