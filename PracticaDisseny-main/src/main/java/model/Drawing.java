package model;

import java.util.List;

public class Drawing {
    public int id;
    public String name;
    public int id_user;
    public String user;
    //private List<Shape> shape;

    public Drawing(int id, String name, int id_user, String user) {
        this.id = id;
        this.name = name;
        this.id_user = id_user;
        this.user = user;
        //this.shape = shape;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}

