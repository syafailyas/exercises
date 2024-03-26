package com.adepuu.exercises.session6;

import java.util.Scanner;

public class Exercise1
{
    /**
     * Write a Java Program to Enter numbers to calculate average and enter 'q' to finish.
     *
     * Input: 1, 2, 3, 4, 5, q
     * Output: 3
     *
     * Input: 1, 2, 3, a, b, 4, 5, q
     * Output: 3
     *
     * Explanation: print "Invalid input. Please enter a valid number or 'q' to finish." if user not inserting the expected number or character.
     */
    public static class AverageCalculator
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            int sum = 0;
            int count = 0;

            while (true)
            {
                System.out.print("Enter a number or 'q' to finish: ");
                if ( scanner.hasNextInt() )
                {
                    int num = scanner.nextInt();
                    sum += num;
                    count++;
                }
                else if ( scanner.next().equalsIgnoreCase("q") )
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter a valid number or 'q' to finish.");
                }
            }

            if (count > 0)
            {
                double average = (double) sum / count;
                System.out.println("Output: " + average);
            }
            else
            {
                System.out.println("No numbers entered.");
            }

            scanner.close();
        }
    }
}