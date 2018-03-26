package com.lessionOne.property;

public class PropertySet {

    private String bookname;

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void demobook() {
        System.out.println("book..." + bookname);
    }
}
