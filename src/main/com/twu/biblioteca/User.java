package com.twu.biblioteca;

public class User {

    private String referenceNumber;
    private String name;
    private String password;

    public User(String reference, String name, String password) {
        this.referenceNumber = reference;
        this.name = name;
        this.password = password;
    }

    public String getReference() {
        return referenceNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
