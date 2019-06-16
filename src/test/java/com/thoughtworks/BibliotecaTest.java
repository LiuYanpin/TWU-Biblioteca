package com.thoughtworks;

import com.google.common.collect.Lists;
import com.thoughtworks.entity.Book;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    private final String expectWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private List<Book> expectBookList = Lists.newArrayList(

            new Book("The Pilgrim’s Progress", " John Bunyan", 1678),
            new Book("Robinson Crusoe", "Daniel Defoe", 1719),
            new Book("Gulliver’s Travels", "Jonathan Swift", 1726),
            new Book("Clarissa", "Samuel Richardson", 1748),
            new Book("Tom Jones", "Henry Fielding", 1749),
            new Book(" Emma", "Jane Austen", 1816),
            new Book("Frankenstein", "Mary Shelley", 1818),
            new Book("Nightmare Abbey", "Thomas Love Peacock", 1818),
            new Book("Sybil", " Benjamin Disraeli", 1845),
            new Book("Jane Eyre", "Charlotte Brontë", 1847)
    );

    @Test
    public void should_print_welcome_message_when_start_the_application() {
        Biblioteca.printWelcomeMessage();
        String actualWelcomeMessage = this.log.getLog();
        assertEquals(expectWelcomeMessage, actualWelcomeMessage);
    }

    @Test
    public void should_print_book_list_when_after_welcome_message_appears() {
        Biblioteca.printBookList();
        String actualBookList = this.log.getLog();
        assertEquals(expectBookList.toString(), actualBookList);
    }
}