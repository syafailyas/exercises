package com.adepuu.exercises.session10;

// DVD class (Child class)
public class DVDMaterial extends Material
{
    private final String director;

    public DVDMaterial(int id, String title, String director, int availabilityCount)
    {
        super(id, title, availabilityCount);
        this.director = director;
    }

    @Override
    public void displayStatus()
    {
        super.displayStatus();
        System.out.println("Director: " + director);
    }
}