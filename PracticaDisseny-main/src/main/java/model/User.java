package model;

public class User {
    int id;
    String usr;
    String name;
    String psw;

    public User(String usr, String name, String psw, int id) {
        this.usr = usr;
        this.name = name;
        this.psw = psw;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}


