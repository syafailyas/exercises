package com.adepuu.exercises.session11;

import java.util.Scanner;

public class Stack<T>
{
    /**
     * Write a Java stack program that can scale dynamically
     * <p>
     * As a developer, I want to implement a Java stack program that can scale dynamically using a linked list, so that I can efficiently manage data storage and retrieval in my applications.
     * Notes:
     * The program doesn't require a menu system; focus should be on data structure implementation.
     * <p>
     * Acceptance Criteria:
     * - Functionality: The program must be able to perform basic stack operations (push, pop, peek) on a linked list.
     * - Dynamic Scaling: The stack should automatically scale in size as elements are added or removed, without any manual resizing required by the user.
     * - Performance: The program should maintain constant time complexity for push and pop operations, ensuring efficient data management.
     * - Memory Efficiency: The stack should use memory efficiently, allocating and deallocating memory dynamically as needed.
     * - Error Handling: The program should handle edge cases gracefully, such as attempting to pop an element from an empty stack, and provide clear error messages.
     */
    private Node<T> top;
    private int size;

    public Stack()
    {
        top = null;
        size = 0;
    }

    public void push(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop()
    {
        if ( isEmpty() )
        {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek()
    {
        if ( isEmpty() )
        {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private static class Node<T>
    {
        private final T data;
        private Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nYour choice:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("\nEnter the variable to push (Enter 'stop' to stop):");
                    String input = scanner.next();
                    while ( !input.equals("stop") )
                    {
                        stack.push(input);
                        System.out.println(input + " pushed onto the stack.");
                        input = scanner.next();
                    }
                    break;
                case 2:
                    try
                    {
                        if ( !stack.isEmpty() )
                        {
                            String popped = stack.pop();
                            System.out.println("\nPopped element: " + popped);
                        }
                        else
                        {
                            System.out.println("Stack is empty");
                        }
                    }
                    catch (IllegalStateException e)
                    {
                        System.out.println( e.getMessage() );
                    }
                    break;
                case 3:
                    try
                    {
                        String peeked = stack.peek();
                        System.out.println("\nPeeked element: " + peeked);
                    }
                    catch (IllegalStateException e)
                    {
                        System.out.println( e.getMessage() );
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}