package com.sda.javaee9spring.controller;

public enum Season {
    WINTER ("Beatiful"),
    SUMMER ("Sunny");

    private String description;
    private Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


