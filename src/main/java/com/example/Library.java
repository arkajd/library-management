package com.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public Book findBook(String name){

        for(Book book : books){
            if(book.getTitle().equals(name)){
                return book;
            }
        }
        return null;
    }


    public void lendBook(String name){
        Book book = findBook(name);
        if(book.isAvailable()){
            book.setAvailable(false);
        }
        else{
            throw new RuntimeException("Book unavailable.");
        }
    }

    public void returnBook(String bookName){
        Book book = findBook(bookName);

        if(!book.isAvailable()){
            book.setAvailable(true);
        }
        else{
            throw new RuntimeException("This book does not belong to this library.");
        }
    }


}
