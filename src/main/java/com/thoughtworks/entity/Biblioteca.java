package com.thoughtworks.entity;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final List<Book> BOOK_LIST = Lists.newArrayList(
            new Book("01", "The Pilgrim’s Progress", "John Bunyan", 1678),
            new Book("02", "Robinson Crusoe", "Daniel Defoe", 1719),
            new Book("03", "Gulliver’s Travels", "Jonathan Swift", 1726),
            new Book("04", "Clarissa", "Samuel Richardson", 1748),
            new Book("05", "Tom Jones", "Henry Fielding", 1749),
            new Book("06", "Emma", "Jane Austen", 1816),
            new Book("07", "Frankenstein", "Mary Shelley", 1818),
            new Book("08", "Nightmare Abbey", "Thomas Love Peacock", 1818),
            new Book("09", "Sybil", "Benjamin Disraeli", 1845),
            new Book("10", "Jane Eyre", "Charlotte Brontë", 1847)
    );
    private List<Menu> MENU_LIST = Lists.newArrayList(
            new Menu("01", "List of books"),
            new Menu("02", "Exit")
    );
    private List<String> lentBooks = new ArrayList<>();

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printBookList() {
        BOOK_LIST.stream()
                .filter(book -> !lentBooks.contains(book.getId()))
                .forEach(book -> System.out.println(book));
    }

    public void printMenu() {
        for (Menu menu : MENU_LIST) {
            System.out.println(menu);
        }
    }

    public void checkOutBook(String bookId) {
        if (containsBook(bookId)) {
            lentBooks.add(bookId);
            System.out.println("Thank you!Enjoy the book");
        } else {
            System.out.println("Sorry, that book is not available");
        }
    }

    public boolean containsBook(String bookId) {
        return BOOK_LIST.stream().anyMatch(book -> bookId.equals(book.getId()));
    }

    public void returnBook(String bookId) {
        if (lentBooks.contains(bookId)) {
            System.out.println("Thank you for returning the book");
            lentBooks.remove(bookId);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
