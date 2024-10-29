package com.Draw.model;

public class User {


    int id;
    String username;
    String password;
    String name;

    public User(String username, String password, String name) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    public User(String username, String password, String name, int id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
