package com.example.demo.data;

public enum Preference {
    STANDARD("standard"),
    EARLIER("earlier"),
    LATER("later"),
    HOME("home");

    private String value;

    Preference(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
