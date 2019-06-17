package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class UserList {

    private HashMap<String, String> userReferenceAndPassword = new HashMap<>();

    private Map<String, String> userReferenceAndName = new HashMap<>();

    public UserList() {
    User Jade = new User("123-4567", "Jade Corcoran", "password1");
    User Steve = new User("765-4321", "Steven Leung", "password2");
    User Tim = new User("000-0000", "Tim Pharo", "password3" );

    userReferenceAndPassword.put(Jade.getReference(),Jade.getPassword());
    userReferenceAndPassword.put(Steve.getReference(), Steve.getPassword());
    userReferenceAndPassword.put(Tim.getReference(), Tim.getPassword());

    userReferenceAndName.put(Jade.getReference(), Jade.getName());
    userReferenceAndName.put(Steve.getReference(), Steve.getName());
    userReferenceAndName.put(Tim.getReference(), Tim.getName());
    }

    public Map<String, String> getUserReferenceAndName() {
        return userReferenceAndName;
    }

    public HashMap<String, String> getUserReferenceAndPassword() {
        return userReferenceAndPassword;
    }
}
