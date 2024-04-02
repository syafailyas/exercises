package com.adepuu.exercises.session10;

// Material class (Parent class)
public class Material
{
    private final int id;
    private final String title;
    private int availabilityCount;
    private boolean borrowed;

    public Material(int id, String title, int availabilityCount)
    {
        this.id = id;
        this.title = title;
        this.availabilityCount = availabilityCount;
        this.borrowed = false;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getAvailabilityCount()
    {
        return availabilityCount;
    }

    public boolean isBorrowed()
    {
        return borrowed;
    }

    public void borrowMaterial()
    {
        if (availabilityCount > 0 && !borrowed)
        {
            availabilityCount--;
            borrowed = true;
            System.out.println("Borrowed ID: " + id);
        }
        else
        {
            System.out.println("Sorry, id " + id + " is not available for borrowing.");
        }
    }

    public void returnMaterial()
    {
        if (borrowed)
        {
            availabilityCount++;
            borrowed = false;
            System.out.println("Returned ID: " + id);
        }
        else
        {
            System.out.println("You did not borrow that id: " + id);
        }
    }

    public void displayStatus()
    {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println( "Availability: " + (availabilityCount > 0 ? "Available" : "Not Available") );
        System.out.println("Number of Availability: " + availabilityCount);
        if (borrowed)
        {
            System.out.println("Status: You are borrowing this id");
        }
        else
        {
            System.out.println("Status: You are not borrowing this id");
        }
    }
}