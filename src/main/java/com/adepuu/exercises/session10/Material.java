package com.adepuu.exercises.session10;

// LibraryMeterial class (Parent class)
public class LibraryMaterial
{
    private final int id;
    private final String title;
    private int availabilityCount;
    private boolean borrowed;

    public LibraryMaterial(int id, String title, int availabilityCount)
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
            System.out.println("Borrowed: " + title);
        }
        else
        {
            System.out.println("Sorry, " + title + " is not available for borrowing.");
        }
    }

    public void returnMaterial()
    {
        if (borrowed)
        {
            availabilityCount++;
            borrowed = false;
            System.out.println("Returned: " + title);
        }
        else
        {
            System.out.println("You did not borrow that book");
        }
    }

    public void displayStatus()
    {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println( "Availability: " + (availabilityCount > 0 ? "Available" : "Not Available") );
        System.out.println("Number of Availability: " + availabilityCount);
        System.out.println( "Borrowed: " + (borrowed ? "Yes" : "No") );
    }
}