package com.thoughtworks;

import com.google.common.collect.Lists;
import com.thoughtworks.entity.Book;
import com.thoughtworks.entity.Menu;

import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static final List<Book> BOOK_LIST = Lists.newArrayList(
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
    private static List<Menu> MENU_LIST = Lists.newArrayList(
            new Menu("01", "List of books")
    );

    public static void main(String[] args) {
        printWelcomeMessage();
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (containsMenu(scanner.nextLine())) {
            printBookList();
        }
    }

    private static boolean containsMenu(String menu) {
        return MENU_LIST.stream().anyMatch(m -> m.getCode().equals(menu) || m.getValue().equals(menu));
    }

    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printBookList() {
        for (Book book : BOOK_LIST) {
            System.out.println(book);
        }
    }

    public static void printMenu() {
        for (Menu menu : MENU_LIST) {
            System.out.println(menu);
        }
    }
}
