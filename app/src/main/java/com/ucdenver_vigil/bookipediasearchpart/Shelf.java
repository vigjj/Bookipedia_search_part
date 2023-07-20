package com.ucdenver_vigil.bookipediasearchpart;

import java.util.ArrayList;

public class Shelf{

    int id; //integer that represents the number id of a shelf
    String name; //name of the shelf
    ArrayList<Integer> books; //holds the id's of the books that are in the shelf

    //constructor
    public Shelf(int id, String name, int bookId){
        this.id = id;
        this.name = name;
        this.books = new ArrayList<Integer>();
        this.books.add(bookId); //add the book
    }

    public ArrayList<Integer> getBooks(){
        return books;
    }

    public void addBook(int bookId){
        //if the book is not added already, then add it. otherwise do nothing
        if(!books.contains(bookId)) books.add(bookId);
    }

    public void removeBook(int bookId){
        books.remove(Integer.valueOf(bookId));
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
