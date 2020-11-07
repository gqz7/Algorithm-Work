package com.company;

public class Customer implements Comparable<Customer>{
    private String name;
    private String email;
    private String id;
    private static int numberOfUsers;

    public Customer ( String name, String email ){
        this.name = name;
        this.email = email;
        id = "u" + (++numberOfUsers);
    }

    @Override
    public int compareTo(Customer o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
