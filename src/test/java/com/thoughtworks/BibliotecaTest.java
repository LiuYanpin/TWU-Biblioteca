package com.thoughtworks;

import com.thoughtworks.entity.Biblioteca;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private static final String ALL_BOOK_LIST =
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
        String expectBookString = ALL_BOOK_LIST;
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
        this.log.clearLog();
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
                "10  Jane Eyre                     Charlotte Brontë      1847 \n";
        assertEquals(expectBookList, actualBookList);
    }

    @Test
    public void should_print_success_message_when_succeeded_check_out_book() {
        biblioteca.checkOutBook("01");
        String expectSuccessMessage = "Thank you!Enjoy the book\n";
        String actualSuccessMessage = this.log.getLog();
        assertEquals(expectSuccessMessage, actualSuccessMessage);
    }

    @Test
    public void should_print_un_successful_message_when_failed_check_out_book() {
        biblioteca.checkOutBook("99");
        String expectMessage = "Sorry, that book is not available\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_print_returned_book_when_return_a_book() {
        biblioteca.checkOutBook("01");
        biblioteca.returnBook("01");
        this.log.clearLog();
        biblioteca.printBookList();
        String actualBookList = this.log.getLog();
        String expectBookList = ALL_BOOK_LIST;
        assertEquals(expectBookList, actualBookList);
    }

    @Test
    public void should_get_notified_message_when_return_a_book_successfully() {
        biblioteca.checkOutBook("01");
        this.log.clearLog();
        biblioteca.returnBook("01");
        String expectMessage = "Thank you for returning the book\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_get_notified_message_when_return_book_unsuccessfully() {
        biblioteca.returnBook("99");
        String expectMessage = "That is not a valid book to return.\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }
}