package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise6
{
    /**
     * Java Array Program to Remove All Occurrences of an Element in an Array
     *
     * Input : array = [ 1, 2, 1, 3, 5, 1 ], key = 1
     * Output : [2, 3, 5]
     *
     * Explanation : all the occurrences of element 1 is removed from the array So, array becomes from
     * [ 1, 2, 1, 3, 5, 1 ] to
     * Final result : [2, 3, 5]
     */
    public static class RemoveElementFromArray
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

            // Input the key element to remove
            System.out.print("Enter the key element to remove: ");
            int key = scanner.nextInt();

            // Remove all occurrences of the key element from the array
            int[] result = removeElement(arr, key);

            // Output the result
            System.out.print("Output: ");
            for (int num : result)
            {
                System.out.print(num + " ");
            }

            scanner.close();
        }

        public static int[] removeElement(int[] arr, int key)
        {
            int count = 0;
            for (int num : arr)
            {
                if (num != key)
                {
                    count++;
                }
            }
            int[] result = new int[count];
            int index = 0;
            for (int num : arr)
            {
                if (num != key)
                {
                    result[index++] = num;
                }
            }
            return result;
        }
    }
}