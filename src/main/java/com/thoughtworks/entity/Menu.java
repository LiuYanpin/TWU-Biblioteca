package com.thoughtworks.entity;

public class Menu {
    private String code;
    private String value;

    public Menu(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format("%-4s", code))
                .append(value)
                .toString();
    }
}
