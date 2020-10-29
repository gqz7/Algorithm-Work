package com.company;

public class User implements Comparable<User> {
    public int points;
    public String username;
    private static int numberOfUsers;

    public User (int points) {
        this.username = "User" + ++numberOfUsers;
        this.points = points;
    }
    @Override
    public int compareTo (User otherUser) {
        return points - otherUser.points;
    }

    @Override
    public String toString () {
        return username + ": " + points;
    }
}
