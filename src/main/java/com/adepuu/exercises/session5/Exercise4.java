package com.adepuu.exercises.session5;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise4
{
    /**
     * Java Array Program to Remove Duplicate Elements From an Array
     *
     * Input : [ 1, 2, 2, 3, 3, 3, 4, 5 ]
     * Output : [ 1, 2, 3, 4, 5 ]
     */
    public static class RemoveDuplicatesFromArray
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input array elements
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();
            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++)
            {
                nums[i] = scanner.nextInt();
            }

            // Remove duplicates from the array
            int[] result = removeDuplicates(nums);

            // Output the result
            System.out.println( "Output: " + Arrays.toString(result) );

            scanner.close();
        }

        public static int[] removeDuplicates(int[] nums)
        {
            Set<Integer> set = new LinkedHashSet<>();
            for (int num : nums)
            {
                set.add(num);
            }
            int[] result = new int[ set.size() ];
            int i = 0;
            for (int num : set)
            {
                result[i++] = num;
            }
            return result;
        }
    }
}