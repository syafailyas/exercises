package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public static class RemoveAllOccurrences
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input array elements
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();
            int[] array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++)
            {
                array[i] = scanner.nextInt();
            }

            // Input the key element to remove
            System.out.print("Enter the key element to remove: ");
            int key = scanner.nextInt();

            // Remove all occurrences of the key element from the array
            int[] result = removeAllOccurrences(array, key);

            // Output the result
            System.out.println( "Output: " + Arrays.toString(result) );

            scanner.close();
        }

        public static int[] removeAllOccurrences(int[] array, int key)
        {
            List<Integer> list = new ArrayList<>();

            // Add non-key elements to the list
            for (int num : array)
            {
                if (num != key)
                {
                    list.add(num);
                }
            }

            // Convert list to array
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
            {
                result[i] = list.get(i);
            }

            return result;
        }
    }
}