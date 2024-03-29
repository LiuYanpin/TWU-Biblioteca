package com.thoughtworks;

import com.thoughtworks.entity.Biblioteca;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private static final String PREFIX_BOOK = StringUtils.repeat("*", 30) + " Book List " + StringUtils.repeat("*", 30) + "\n";
    private static final String PREFIX_MOVIE = StringUtils.repeat("*", 30) + " Movie List " + StringUtils.repeat("*", 30) + "\n";
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
    private static final String ALL_MOVIE_LIST =
            "01  The Godfather\n" +
            "02  The Shawshank Redemption\n" +
            "03  Pulp Fiction\n" +
            "04  Star Wars\n" +
            "05  The Dark Knight\n" +
            "06  Goodfellas\n" +
            "07  The Godfather Part II\n" +
            "08  The Matrix\n" +
            "09  Schindler's List\n" +
            "10  Saving Private Ryan\n";

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
        String expectBookString = PREFIX_BOOK + ALL_BOOK_LIST;
        assertEquals(expectBookString, actualBookString);
    }

    @Test
    public void should_print_menu_of_options() {
        biblioteca.printMenu();
        String actualMenuString = this.log.getLog();
        String prefixString = StringUtils.repeat("*", 30) + " Menu " + StringUtils.repeat("*", 30) + "\n";
        String expectMenuString = prefixString +
                "01  List of books\n" +
                "02  Exit\n" +
                "03  Check-out book\n" +
                "04  Return book\n" +
                "05  List of movies\n" +
                "06  Check-out movie\n" +
                "07  Return movie\n" +
                "08  My Information\n" +
                "Please select a valid option:\n";
        assertEquals(expectMenuString, actualMenuString);
    }

    @Test
    public void should_print_remaining_books_when_check_out_a_book() {
        biblioteca.checkOutBook("01");
        this.log.clearLog();
        biblioteca.printBookList();
        String actualBookList = this.log.getLog();
        String expectBookList = PREFIX_BOOK +
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
        String expectBookList = PREFIX_BOOK + ALL_BOOK_LIST;
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

    @Test
    public void should_print_movie_list_when_choose_movie_list() {
        biblioteca.printMovieList();
        String expectMovieList = PREFIX_MOVIE + ALL_MOVIE_LIST;
        String actualMovieList = this.log.getLog();
        assertEquals(expectMovieList, actualMovieList);
    }

    @Test
    public void should_print_success_message_when_check_out_a_movie() {
        biblioteca.checkOutMovie("01");
        String expectMessage = "Thank you! Enjoy the movie\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_print_failed_message_when_failed_check_out_a_movie() {
        biblioteca.checkOutMovie("99");
        String expectMessage = "Sorry, that movie is not available\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_get_notified_message_when_return_a_movie_successfully() {
        biblioteca.checkOutMovie("01");
        this.log.clearLog();
        biblioteca.returnMovie("01");
        String expectMessage = "Thank you for returning the movie\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_get_notified_message_when_return_movie_unsuccessfully() {
        biblioteca.returnMovie("99");
        String expectMessage = "That is not a valid movie to return.\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }

    @Test
    public void should_get_success_message_when_user_use_correct_library_number_and_password() {
        boolean loginResultWithCorrectInfo = biblioteca.login("100-0001", "1qaz@WSX").isPresent();
        assertTrue(loginResultWithCorrectInfo);
        boolean loginResultWithWrongInfo = biblioteca.login("100-0001", "12345678").isPresent();
        assertFalse(loginResultWithWrongInfo);
    }

    @Test
    public void should_print_logined_user_information_when_user_choose_info_menu() {
        biblioteca.viewUserInfo(biblioteca.login("100-0001", "1qaz@WSX").get());
        String expectMessage = "Morgan Freeman\nmorganfreeman@gmail.com\n100122133\n";
        String actualMessage = this.log.getLog();
        assertEquals(expectMessage, actualMessage);
    }
}