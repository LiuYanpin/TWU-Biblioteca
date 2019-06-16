package com.thoughtworks.entity;

public class Book {
    private String name;
    private String author;
    private int publishYear;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("%-30s", name))
                .append(String.format("%-22s", author))
                .append(String.format("%-5d", publishYear))
                .toString();
    }
}
