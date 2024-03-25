package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise8
{
    /**
     * Java String Program to Find all Duplicates on Array
     *
     * Example 1 :
     * Input : nums = [4,3,2,7,8,2,3,1]
     * Output : [2,3]
     *
     * Example 2 :
     * Input : nums = [1,1,2]
     * Output : [1]
     *
     * Example 3 :
     * Input : nums = [1]
     * Output : []
     */
    public static class FindDuplicates
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

            // Find duplicates in the array
            List<Integer> duplicates = findDuplicates(nums);

            // Output the result
            System.out.println("Output: " + duplicates);

            scanner.close();
        }

        public static List<Integer> findDuplicates(int[] nums)
        {
            List<Integer> result = new ArrayList<>();
            Map<Integer, Integer> countMap = new HashMap<>();

            // Count the occurrences of each number
            for (int num : nums)
            {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            // Add numbers with count > 1 to the result list
            for ( Map.Entry<Integer, Integer> entry : countMap.entrySet() )
            {
                if (entry.getValue() > 1)
                {
                    result.add( entry.getKey() );
                }
            }

            return result;
        }
    }
}