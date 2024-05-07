package com.cydeo.enums;

public enum Type {
    PREMIER("premier"), REGULAR("regular");
    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
