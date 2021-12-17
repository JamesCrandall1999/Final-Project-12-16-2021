package com.company.models;

public class Account {
    private int id;
    private String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;

    }


    public int getId() {
        return id;
    }

    public void setIdentity(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "#" + id + " Name: " + name;
    }
}
