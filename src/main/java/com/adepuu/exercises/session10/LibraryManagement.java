package com.adepuu.exercises.session10;

import java.util.Scanner;

public class LibraryManagement
{
    /**
     * Acceptance Criteria:
     * - Each material should have an availability count, and the program should check if the material is still available for borrowing.
     * - The program should demonstrate polymorphism by allowing operations (borrow, return) to be performed on any type of library material through a single method.
     * - The program should include methods to borrow and return materials.
     * - The program should keep track of the available and borrowed materials.
     * - The program should print out the status of materials (available, borrowed) and the actions performed (borrow, return).
     * <p>
     * Notes:
     * - The program doesn't require a menu system; focus should be on Object-Oriented Programming (OOP) and inheritance implementation.
     * - Make sure to implement Inheritance and Polymorphism properly
     */
    public static void main(String[] args)
    {
        // Create books and DVDs
        Material[] materials = {
                new BookMaterial(1, "Finding Indra", "Indra", 5),
                new BookMaterial(2, "Nina The Explorer", "Nina", 3),
                new DVDMaterial(1, "Laila and The Bear", "Laila", 5),
                new DVDMaterial(2, "Detective Ilyas", "Ilyas", 3)
        };

        System.out.println("Welcome to library system\n");

        Scanner scanner = new Scanner(System.in);

        // Borrow process
        borrowBook(scanner, materials);
        borrowDVD(scanner, materials);

        // Return process
        returnBook(scanner, materials);
        returnDVD(scanner, materials);

        System.out.println("\nBook List:");
        displayMaterials(materials, BookMaterial.class);

        System.out.println("DVD List:");
        displayMaterials(materials, DVDMaterial.class);

        System.out.println("Thank you for using this system");
    }

    private static void borrowBook(Scanner scanner, Material[] materials)
    {
        System.out.println("Book List:");
        displayMaterials(materials, BookMaterial.class);

        System.out.print("Enter book id that you want to borrow (or press exit to exit): ");
        String input = scanner.nextLine();

        while ( !input.equalsIgnoreCase("exit") )
        {
            int id;
            try
            {
                id = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input");

                System.out.println("\nBook List:");
                displayMaterials(materials, BookMaterial.class);

                System.out.print("Enter book id that you want to borrow (or press exit to exit): ");
                input = scanner.nextLine();
                continue;
            }

            boolean found = false;
            for (Material material : materials)
            {
                if (material.getId() == id && material instanceof BookMaterial)
                {
                    material.borrowMaterial();
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Invalid Input");
            }

            System.out.println("\nBook List:");
            displayMaterials(materials, BookMaterial.class);

            System.out.print("Enter book id that you want to borrow (or press exit to exit): ");
            input = scanner.nextLine();
        }
    }

    private static void borrowDVD(Scanner scanner, Material[] materials)
    {
        System.out.println("\nDVD List:");
        displayMaterials(materials, DVDMaterial.class);

        System.out.print("Enter dvd id that you want to borrow (or press exit to exit): ");
        String input = scanner.nextLine();

        while ( !input.equalsIgnoreCase("exit") )
        {
            int id;
            try
            {
                id = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input");

                System.out.println("\nDVD List:");
                displayMaterials(materials, DVDMaterial.class);

                System.out.print("Enter dvd id that you want to borrow (or press exit to exit): ");
                input = scanner.nextLine();
                continue;
            }

            boolean found = false;
            for (Material material : materials)
            {
                if (material.getId() == id && material instanceof DVDMaterial)
                {
                    material.borrowMaterial();
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Invalid Input");
            }

            System.out.println("\nDVD List:");
            displayMaterials(materials, DVDMaterial.class);

            System.out.print("Enter dvd id that you want to borrow (or press exit to exit): ");
            input = scanner.nextLine();
        }
    }

    private static void returnBook(Scanner scanner, Material[] materials)
    {
        System.out.print("\nEnter book id that you want to return (or press exit to exit): ");
        String input = scanner.nextLine();

        while ( !input.equalsIgnoreCase("exit") )
        {
            int id;
            try
            {
                id = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input");

                System.out.print("\nEnter book id that you want to return (or press exit to exit): ");
                input = scanner.nextLine();
                continue;
            }

            boolean found = false;
            for (Material material : materials)
            {
                if (material.getId() == id && material instanceof BookMaterial)
                {
                    material.returnMaterial();
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Invalid Input");
            }

            System.out.print("\nEnter book id that you want to return (or press exit to exit): ");
            input = scanner.nextLine();
        }
    }

    private static void returnDVD(Scanner scanner, Material[] materials)
    {
        System.out.print("\nEnter dvd id that you want to return (or press exit to exit): ");
        String input = scanner.nextLine();

        while ( !input.equalsIgnoreCase("exit") )
        {
            int id;
            try
            {
                id = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input");

                System.out.print("\nEnter dvd id that you want to return (or press exit to exit): ");
                input = scanner.nextLine();
                continue;
            }

            boolean found = false;
            for (Material material : materials)
            {
                if (material.getId() == id && material instanceof DVDMaterial)
                {
                    material.returnMaterial();
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Invalid Input");
            }

            System.out.print("\nEnter dvd id that you want to return (or press exit to exit): ");
            input = scanner.nextLine();
        }
    }

    private static void displayMaterials(Material[] materials, Class<? extends Material> type)
    {
        for (Material material : materials)
        {
            if ( type.isInstance(material) )
            {
                material.displayStatus();
                System.out.println();
            }
        }
    }
}