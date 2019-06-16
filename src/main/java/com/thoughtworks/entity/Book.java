package com.thoughtworks.entity;

public class Book {
    private String id;
    private String name;
    private String author;
    private int publishYear;

    public Book(String id, String name, String author, int publishYear) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("%-4s", id))
                .append(String.format("%-30s", name))
                .append(String.format("%-22s", author))
                .append(String.format("%-5d", publishYear))
                .toString();
    }
}
