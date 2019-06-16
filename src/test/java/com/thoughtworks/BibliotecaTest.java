package com.thoughtworks;

import com.thoughtworks.entity.Biblioteca;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void should_print_welcome_message_when_start_the_application() {
        biblioteca.printWelcomeMessage();
        String actualWelcomeMessage = this.log.getLog();
        String expectWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals(expectWelcomeMessage, actualWelcomeMessage);
    }

    @Test
    public void should_print_book_list_when_after_welcome_message_appears() {
        biblioteca.printBookList();
        String actualBookString = this.log.getLog();
        String expectBookString =
                "01  The Pilgrim’s Progress        John Bunyan           1678 \n" +
                "02  Robinson Crusoe               Daniel Defoe          1719 \n" +
                "03  Gulliver’s Travels            Jonathan Swift        1726 \n" +
                "04  Clarissa                      Samuel Richardson     1748 \n" +
                "05  Tom Jones                     Henry Fielding        1749 \n" +
                "06  Emma                          Jane Austen           1816 \n" +
                "07  Frankenstein                  Mary Shelley          1818 \n" +
                "08  Nightmare Abbey               Thomas Love Peacock   1818 \n" +
                "09  Sybil                         Benjamin Disraeli     1845 \n" +
                "10  Jane Eyre                     Charlotte Brontë      1847 \n";
        assertEquals(expectBookString, actualBookString);
    }

    @Test
    public void should_print_menu_of_options() {
        biblioteca.printMenu();
        String actualMenuString = this.log.getLog();
        String expectMenuString = "01  List of books\n" + "02  Exit\n";
        assertEquals(expectMenuString, actualMenuString);
    }

    @Test
    public void should_print_remaining_books_when_check_out_a_book() {
        biblioteca.checkOutBook("01");
        biblioteca.printBookList();
        String actualBookList = this.log.getLog();
        String expectBookList =
                "02  Robinson Crusoe               Daniel Defoe          1719 \n" +
                "03  Gulliver’s Travels            Jonathan Swift        1726 \n" +
                "04  Clarissa                      Samuel Richardson     1748 \n" +
                "05  Tom Jones                     Henry Fielding        1749 \n" +
                "06  Emma                          Jane Austen           1816 \n" +
                "07  Frankenstein                  Mary Shelley          1818 \n" +
                "08  Nightmare Abbey               Thomas Love Peacock   1818 \n" +
                "09  Sybil                         Benjamin Disraeli     1845 \n" +
                "10  Jane Eyre                     Charlotte Brontë      1847 \n";;
        assertEquals(expectBookList, actualBookList);
    }

    @Test
    public void should_print_success_message_when_succeeded_check_out_book() {
        biblioteca.checkOutBook("01");
        String expectSuccessMessage = "Thank you!Enjoy the book\n";
        String actualSuccessMessage = this.log.getLog();
        assertEquals(expectSuccessMessage, actualSuccessMessage);
    }
}