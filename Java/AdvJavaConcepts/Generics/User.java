package com.company;

public class User implements Comparable<User> {
    public int points;
    public User (int points) {
        this.points = points;
    }
    @Override
    public int compareTo (User otherUser) {
        return points - otherUser.points;
    }
}
