package com.company;

public class Admin extends User {
    private String adminID;
    private static int adminsMade;

    public Admin () {
        super(1000);
        adminID = "ID-" + ++adminsMade;
    }

    @Override
    public String toString () {
        return username + ": " + points + ", Admin: " + adminID;
    }
}
