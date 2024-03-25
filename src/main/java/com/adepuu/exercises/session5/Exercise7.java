package com.adepuu.exercises.session5;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise7
{
    /**
     * Java String Program to Check Anagram
     *
     * Example 1 :
     * Input : s = "anagram", t = "nagaram"
     * Output : true
     *
     * Example 2 :
     * Input : s = "rat", t = "car"
     * Output : false
     */
    public static class AnagramChecker
    {
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);

            // Input the two strings
            System.out.print("Enter the first string: ");
            String s = scanner.next();
            System.out.print("Enter the second string: ");
            String t = scanner.next();

            // Check if the strings are anagrams
            boolean result = isAnagram(s, t);

            // Output the result
            System.out.println("Output: " + result);

            scanner.close();
        }

        public static boolean isAnagram(String s, String t)
        {
            if ( s.length() != t.length() )
            {
                return false;
            }

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            Arrays.sort(sChars);
            Arrays.sort(tChars);

            return Arrays.equals(sChars, tChars);
        }
    }
}