package com.adepuu.exercises.session5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise3
{
    /**
     * Write a Java Program to Check if Array Contain Duplicates
     *
     * Example 1 :
     * Input : nums = [1,2,3,1]
     * Output : true
     *
     * Example 2 :
     * Input : nums = [1,2,3,4]
     * Output : false
     *
     * Example 3 :
     * Input : nums = [1,1,1,3,3,4,3,2,4,2]
     * Output : true
     */
    public static class ContainsDuplicates
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

            // Check if array contains duplicates
            boolean hasDuplicates = containsDuplicates(nums);

            // Output the result
            System.out.println("Output: " + hasDuplicates);

            scanner.close();
        }

        public static boolean containsDuplicates(int[] nums)
        {
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
            {
                if ( set.contains(num) )
                {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}