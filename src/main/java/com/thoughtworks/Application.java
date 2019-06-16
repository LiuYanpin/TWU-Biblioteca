package com.thoughtworks;

import com.google.common.base.Strings;
import com.thoughtworks.entity.Biblioteca;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();
        biblioteca.printMenu();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while (!Strings.isNullOrEmpty(option)) {
            switch (option) {
                case "01":
                    biblioteca.printBookList();
                    System.out.println("Which book do you want to check-out?");
                    option = scanner.nextLine();
                    if (biblioteca.containsBook(option)) {
                        biblioteca.checkOutBook(option);
                    }
                    break;
                case "02":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid option!");
                    break;
            }
            biblioteca.printMenu();
            option = scanner.nextLine();
        }

    }
}
