package com.adepuu.exercises.session5;

import java.util.Scanner;

public class Exercise2
{
    /**
     * Java Array Program For Array Rotation
     * Input : arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
     * Output :  3 4 5 6 7 1 2
     * Explanation: d = 2 so 2 elements are rotated to the end of the array. So, 1 2 is rotated back
     * So, Final result: 3, 4, 5, 6, 7, 1, 2
     */
    public static class ArrayRotation
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

            // Input number of positions to rotate
            System.out.print("Enter the number of positions to rotate: ");
            int d = scanner.nextInt();

            // Perform array rotation
            rotateArray(arr, d);

            // Output the rotated array
            System.out.print("Rotated array: ");
            for (int num : arr)
            {
                System.out.print(num + " ");
            }

            scanner.close();
        }

        public static void rotateArray(int[] arr, int d)
        {
            int n = arr.length;
            reverseArray(arr, 0, d - 1);
            reverseArray(arr, d, n - 1);
            reverseArray(arr, 0, n - 1);
        }

        public static void reverseArray(int[] arr, int start, int end)
        {
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