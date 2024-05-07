package com.cydeo.enums;

public enum State {
    ACTIVE("active"), DRAFT("draft"), SUSPENDED("suspended");

    private String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    }
