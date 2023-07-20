package com.ucdenver_vigil.bookipediasearchpart;

public class Book{

    private int id; //integer that represents the number id of a book so we don't have to look for strings
    private String name; //name of the book
    private int pgNum; //page number that the book should open at when opened next

    //constructor
    public Book(int id, String name){
        this.id = id;
        this.name = name;
        this.pgNum = 0; //will always start at 0 when a book is created/added
    }

    public int getPage(){
        return pgNum;
    }

    public void setPage(int pgNum){
        this.pgNum = pgNum;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}