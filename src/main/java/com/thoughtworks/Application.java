package com.thoughtworks;

import com.google.common.base.Strings;
import com.thoughtworks.entity.Biblioteca;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();

        boolean loginResult = getLoginResult(biblioteca);
        while (!loginResult) {
            System.out.println("Login failed");
            loginResult = getLoginResult(biblioteca);
        }
        System.out.println("Login successfully");
        biblioteca.printMenu();
        processMenu(biblioteca);
    }

    private static void processMenu(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
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
                case "05":
                    biblioteca.printMovieList();
                    break;
                case "06":
                    System.out.println("Which movie do you want to check-out?");
                    biblioteca.checkOutMovie(scanner.nextLine());
                    break;
                case "07":
                    System.out.println("Which movie do you want to return?");
                    biblioteca.returnMovie(scanner.nextLine());
                    break;
                default:
                    System.out.println("Please select a valid option!");
                    break;
            }
            biblioteca.printMenu();
            option = scanner.nextLine();
        }
    }

    private static boolean getLoginResult(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your library number:(Enter \"Q\" to quit.)");
        String libraryNumber = scanner.nextLine();
        if (libraryNumber.equals("Q")) {
            System.exit(0);
        }
        System.out.println("Please input your password:");
        String password = scanner.nextLine();
        return biblioteca.login(libraryNumber, password);
    }
}
