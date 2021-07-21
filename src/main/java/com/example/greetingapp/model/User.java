package com.example.greetingapp.model;

public class User {
    private String firstName;

    public User(String firstName){
        this.firstName = firstName;

    }
    @Override
    public String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        return str.trim();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
