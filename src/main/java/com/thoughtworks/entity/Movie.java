package com.thoughtworks.entity;

public class Movie {

    private String id;
    private String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("%-4s", id)).append(name).toString();
    }
}
