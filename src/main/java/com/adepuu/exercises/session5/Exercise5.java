package com.adepuu.exercises.session5;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5
{
    /**
     * Java Array Program to sort array in increasing & decreasing order
     *
     * Example 1 :
     * Input : [ 8, 7, 5, 2], direction = “asc”
     * Output : [ 2, 5, 7, 8 ]
     *
     * Example 2 :
     * Input : [ 8, 7, 5, 2], direction = “desc”
     * Output : [ 8,7, 5, 2 ]
     */
    public static class SortArray
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input array elements
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++)
            {
                arr[i] = scanner.nextInt();
            }

            // Input sorting direction
            System.out.print("Enter the sorting direction (asc/desc): ");
            String direction = scanner.next();

            // Sort the array based on direction
            if ( direction.equals("asc") )
            {
                Arrays.sort(arr);
                System.out.println( "Sorted array in increasing order: " + Arrays.toString(arr) );
            }
            else if ( direction.equals("desc") )
            {
                Arrays.sort(arr);
                reverseArray(arr);
                System.out.println( "Sorted array in decreasing order: " + Arrays.toString(arr) );
            }
            else
            {
                System.out.println("Invalid sorting direction. Please enter 'asc' or 'desc'.");
            }

            scanner.close();
        }

        public static void reverseArray(int[] arr)
        {
            int start = 0;
            int end = arr.length - 1;
            while (start < end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}