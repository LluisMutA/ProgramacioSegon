package com.esliceu.demospring.model;

public class Person {

    int year;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "year=" + year +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
