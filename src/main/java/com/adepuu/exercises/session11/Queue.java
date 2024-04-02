package com.adepuu.exercises.session11;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<T>
{
    /**
     * Write a Java queue program that can scale dynamically
     * <p>
     * As a developer, I want to implement a Java queue program that can scale dynamically using a linked list, so that I can efficiently manage data storage and retrieval in my applications.
     * <p>
     * Notes:
     * The program doesn't require a menu system; focus should be on data structure implementation.
     * <p>
     * Acceptance Criteria:
     * - Functionality: The program must be able to perform basic queue operations (enqueue, dequeue, peek) on a linked list.
     * - Dynamic Scaling: The queue should automatically scale in size as elements are added or removed, without any manual resizing required by the user.
     * - Performance: The program should maintain constant time complexity for enqueue and dequeue operations, ensuring efficient data management.
     * - Memory Efficiency: The queue should use memory efficiently, allocating and deallocating memory dynamically as needed.
     * - Error Handling: The program should handle edge cases gracefully, such as attempting to dequeue an element from an empty queue, and provide clear error messages.
     */
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue()
    {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data)
    {
        Node<T> newNode = new Node<>(data);
        if ( isEmpty() )
        {
            front = newNode;
        }
        else
        {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    public T dequeue()
    {
        if ( isEmpty() )
        {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null)
        {
            rear = null; // Reset rear when dequeuing last element
        }
        size--;
        return data;
    }

    public T peek()
    {
        if ( isEmpty() )
        {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    private static class Node<T> {
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
        Queue<Integer> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nEnter a number to enqueue (Enter 'stop' to stop):");
            String input = scanner.next();
            if ( input.equals("stop") )
            {
                break;
            }
            try
            {
                int number = Integer.parseInt(input);
                queue.enqueue(number);
                System.out.println(number + " enqueued.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number or 'stop' to stop.");
            }
        }

        System.out.println("\nDequeuing elements:");
        while ( !queue.isEmpty() )
        {
            System.out.println("Dequeued element: " + queue.dequeue());
        }
    }
}