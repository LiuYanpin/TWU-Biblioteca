package com.thoughtworks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void should_print_welcome_message_when_start_the_application() {
        Biblioteca.printWelcomeMessage();
        String actualWelcomeMessage = this.log.getLog();
        String expectWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectWelcomeMessage, actualWelcomeMessage);
    }

    @Test
    public void should_print_book_list_when_after_welcome_message_appears() {
        Biblioteca.printBookList();
        String actualBookString = this.log.getLog();
        String expectBookString = "The Pilgrim’s Progress        John Bunyan           1678 \n" +
                "Robinson Crusoe               Daniel Defoe          1719 \n" +
                "Gulliver’s Travels            Jonathan Swift        1726 \n" +
                "Clarissa                      Samuel Richardson     1748 \n" +
                "Tom Jones                     Henry Fielding        1749 \n" +
                "Emma                          Jane Austen           1816 \n" +
                "Frankenstein                  Mary Shelley          1818 \n" +
                "Nightmare Abbey               Thomas Love Peacock   1818 \n" +
                "Sybil                         Benjamin Disraeli     1845 \n" +
                "Jane Eyre                     Charlotte Brontë      1847 \n";
        assertEquals(expectBookString, actualBookString);
    }

    @Test
    public void should_print_menu_of_options() {
        Biblioteca.printMenu();
        String actualMenuString = this.log.getLog();
        String expectMenuString = "01  List of books\n";
        assertEquals(expectMenuString, actualMenuString);
    }
}