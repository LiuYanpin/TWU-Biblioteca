package com.thoughtworks;

import com.google.common.base.Strings;
import com.thoughtworks.entity.Biblioteca;
import com.thoughtworks.entity.User;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.printWelcomeMessage();

        Optional<User> loginResult = getLoginResult(biblioteca);
        while (!loginResult.isPresent()) {
            System.out.println("Login failed");
            loginResult = getLoginResult(biblioteca);
        }
        System.out.println("Login successfully");
        biblioteca.printMenu();
        processMenu(biblioteca, loginResult.get());
    }

    private static void processMenu(Biblioteca biblioteca, User user) {
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
                case "08":
                    biblioteca.viewUserInfo(user);
                    break;
                default:
                    System.out.println("Please select a valid option!");
                    break;
            }
            biblioteca.printMenu();
            option = scanner.nextLine();
        }
    }

    private static Optional<User> getLoginResult(Biblioteca biblioteca) {
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
