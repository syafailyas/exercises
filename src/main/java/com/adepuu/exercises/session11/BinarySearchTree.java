package com.adepuu.exercises.session11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearchTree
{
    /**
     * Write a Java binary search tree program that can scale dynamically
     * <p>
     * As a user, I want to insert N-numbers into a binary search tree and then search for a specific number. After searching, the program should prompt me to search for another number without terminating.
     * <p>
     * Acceptance Criteria:
     * - The program should start by prompting the user to enter the number of elements (N) they wish to insert into the binary search tree.
     * - The program should then prompt the user to enter N numbers one by one.
     * <p>
     * Acceptance Criteria:
     * - The program should correctly insert each number into the binary search tree in a way that maintains the binary search tree properties (all nodes in the left subtree are less than the root, and all nodes in the right subtree are greater than the root).
     * - The program should handle duplicate numbers appropriately, either by ignoring them or by updating the existing node.
     * - After inserting all N-numbers, the program should prompt the user to enter a number to search for within the binary search tree.
     * - The program should perform a binary search to find the entered number, following the binary search tree properties.
     * - The program should display whether the number is found or not.
     * - The program should provide a clear and straightforward way for the user to exit the continuous search loop and terminate the program, such as entering a specific keyword or command.
     */
    static class Node
    {
        int data;
        Node left, right;

        Node(int value)
        {
            data = value;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree()
    {
        root = null;
    }

    void insert(int key)
    {
        root = insertRecursive(root, key);
    }

    Node insertRecursive(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
        {
            root.left = insertRecursive(root.left, key);
        }
        else if (key > root.data)
        {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }

    boolean search(int key)
    {
        return searchRecursive(root, key);
    }

    boolean searchRecursive(Node root, int key)
    {
        if (root == null || root.data == key)
        {
            return root != null;
        }

        if (key < root.data)
        {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        int n;
        while (true)
        {
            try
            {
                System.out.print("Enter the number of elements to insert into the binary search tree: ");
                n = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input. Please enter an integer.\n");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++)
        {
            int num = scanner.nextInt();
            bst.insert(num);
        }

        while (true)
        {
            System.out.print("\nEnter a number to search for (Enter 'exit' to terminate): ");
            String input = scanner.next();

            if ( input.equals("exit") )
            {
                break;
            }

            try
            {
                int number = Integer.parseInt(input);
                if ( bst.search(number) )
                {
                    System.out.println("Number " + number + " is found in the binary search tree.");
                }
                else
                {
                    System.out.println("Number " + number + " is not found in the binary search tree.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number or 'exit' to terminate.");
            }
        }
    }
}