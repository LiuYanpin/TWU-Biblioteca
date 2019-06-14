package com.thoughtworks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class BibliotecaTest {

    private final String expectWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void should_print_welcome_message_when_start_the_application() {
        System.out.print(expectWelcomeMessage);
        String actualWelcomeMessage = this.log.getLog();
        assertEquals(expectWelcomeMessage, actualWelcomeMessage);
    }
}