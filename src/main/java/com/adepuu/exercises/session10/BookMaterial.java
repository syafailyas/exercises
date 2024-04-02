package com.adepuu.exercises.session10;

// Book class (Child class)
public class Book extends Material
{
    private final String author;

    public Book(int id, String title, String author, int availabilityCount)
    {
        super(id, title, availabilityCount);
        this.author = author;
    }

    @Override
    public void displayStatus()
    {
        super.displayStatus();
        System.out.println("Author: " + author);
    }
}