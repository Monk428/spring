package com.lessionThree.jdbc;

public class Student {
    private int id;

    private String name;

    private String gender;

    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "["+id+","+name+","+age+"]";
    }
}
