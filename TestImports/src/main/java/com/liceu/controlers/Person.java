package com.liceu.controlers;

public class Person {
    private String nom;
    private int birthYear;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Person(String nom, int birthYear) {
        this.nom = nom;
        this.birthYear = birthYear;
    }
}
