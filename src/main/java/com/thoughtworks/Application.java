package com.thoughtworks;

import com.google.common.base.Strings;
import com.thoughtworks.entity.Biblioteca;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        biblioteca.printWelcomeMessage();
        biblioteca.printMenu();
        String option = scanner.nextLine();
        while (!Strings.isNullOrEmpty(option)) {
            switch (option) {
                case "01":
                    biblioteca.printBookList();
                    break;
                case "02":
                    System.exit(0);
                    break;
                case "03":
                    System.out.println("Which book do you want to check-out?");
                    biblioteca.checkOutBook(scanner.nextLine());
                    break;
                case "04":
                    System.out.println("Which book do you want to return?");
                    biblioteca.returnBook(scanner.nextLine());
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
