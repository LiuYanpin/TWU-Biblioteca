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
        return new StringBuilder().append(name).append(author).append(publishYear).toString();
    }
}
