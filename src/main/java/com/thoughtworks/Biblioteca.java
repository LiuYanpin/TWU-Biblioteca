package com.thoughtworks;

import com.google.common.collect.Lists;
import com.thoughtworks.entity.Book;

import java.util.List;

public class Biblioteca {

    public static void printWelcomeMessage() {
        final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void printBookList() {
        List<Book> bookList = Lists.newArrayList(
                new Book("The Pilgrim’s Progress", "John Bunyan", 1678),
                new Book("Robinson Crusoe", "Daniel Defoe", 1719),
                new Book("Gulliver’s Travels", "Jonathan Swift", 1726),
                new Book("Clarissa", "Samuel Richardson", 1748),
                new Book("Tom Jones", "Henry Fielding", 1749),
                new Book("Emma", "Jane Austen", 1816),
                new Book("Frankenstein", "Mary Shelley", 1818),
                new Book("Nightmare Abbey", "Thomas Love Peacock", 1818),
                new Book("Sybil", "Benjamin Disraeli", 1845),
                new Book("Jane Eyre", "Charlotte Brontë", 1847)
        );
        for (Book book: bookList) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        printBookList();
    }
}
