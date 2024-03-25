package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise1
{
    public static class LargestElementInArray
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input array size
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Input array elements
            int[] arr = new int[size];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++)
            {
                arr[i] = scanner.nextInt();
            }

            // Find the largest element in the array
            int largest = findLargestElement(arr);

            // Output the result
            System.out.println("Largest element in the array: " + largest);

            scanner.close();
        }

        public static int findLargestElement(int[] arr)
        {
            if (arr == null || arr.length == 0)
            {
                throw new IllegalArgumentException("Array must not be empty");
            }

            int largest = arr[0];
            for (int i = 1; i < arr.length; i++)
            {
                if (arr[i] > largest)
                {
                    largest = arr[i];
                }
            }
            return largest;
        }
    }
}