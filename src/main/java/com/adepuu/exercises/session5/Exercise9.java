package com.adepuu.exercises.session5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Exercise9
{
    /**
     * Java Program to get the number of days you have to wait after the i-th day to get a warmer temperature
     *
     * Example 1 :
     * Input : temperatures = [73,74,75,71,69,72,76,73]
     * Output : [1,1,4,2,1,1,0,0]
     *
     * Example 2 :
     * Input : temperatures = [30,40,50,60]
     * Output : [1,1,1,0]
     *
     * Example 3 :
     * Input : temperatures = [30,60,90]
     * Output : [1,1,0]
     */
    public static class WarmerTemperatures
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input temperatures
            System.out.print("Enter the number of temperatures: ");
            int n = scanner.nextInt();
            int[] temperatures = new int[n];
            System.out.println("Enter the temperatures:");
            for (int i = 0; i < n; i++)
            {
                temperatures[i] = scanner.nextInt();
            }

            // Calculate warmer days
            int[] result = warmerTemperatures(temperatures);

            // Output the result
            System.out.println( "Output: " + Arrays.toString(result) );

            scanner.close();
        }

        public static int[] warmerTemperatures(int[] temperatures)
        {
            int n = temperatures.length;
            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++)
            {
                while ( !stack.isEmpty() && temperatures[i] > temperatures[ stack.peek() ] )
                {
                    int index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }

            return result;
        }
    }
}