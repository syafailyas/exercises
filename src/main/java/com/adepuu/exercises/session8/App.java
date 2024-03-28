package com.adepuu.exercises.session8;

import java.util.Scanner;

public class App
{
    /**
     * Manages user registration, login and task management for the To-Do List application.
     * <p>
     * This function enables users to register, log in and manage their tasks through the console.
     * It provides a clear and concise menu with options to add a task, view tasks, delete a task or log out.
     * The system handles user input errors gracefully, providing clear feedback and prompting for correct input.
     * </p>
     * <br/>
     * <h3>User Registration and Login:</h3>
     * <ul>
     *     <li>Given a new user, when they input their desired login and password through the console, then the system should create a new account and confirm successful account creation.</li>
     *     <li>Given an existing user, when they input their login and password through the console, then the system should authenticate the user and grant access to the to-do list.</li>
     * </ul>
     *
     * <h3>Task Management:</h3>
     * <ul>
     *     <li>Given a logged-in user, when they input a new task through the console, then the system should add the task to their to-do list and confirm the task has been added.</li>
     *     <li>Given a logged-in user, when they view their to-do list through the console, then the system should display all tasks currently in their list.</li>
     *     <li>Given a logged-in user, when they input a task to delete through the console, then the system should remove the task from their to-do list and confirm the task has been deleted.</li>
     * </ul>
     *
     * <h3>Other:</h3>
     * <ul>
     *     <li>When a user accesses the application, the interface should display a clear and concise menu with options to add a task, view tasks, delete a task, or log out, all accessible through the console.</li>
     *     <li>The system should handle user input errors gracefully, providing clear feedback and prompting for correct input through the console.</li>
     * </ul>
     *
     * <h3>Notes:</h3>
     * <ul>
     *     <li>No need to encrypt user password</li>
     *     <li>Start the program menu inside main function below</li>
     *     <li>Split each functionalities into its own classes</li>
     *     <li>Please Use UUID if there's ID needed <a href = "https://www.baeldung.com/java-uuid">Java UUID Reference</a></li>
     *     <li>Data does not need to be stored in a File. Instead, store it inside a Map or List and let the data gone when program finished</li>
     * </ul>
     */
    private static final UserManager userManager = new UserManager();
    private static final TaskManager taskManager = new TaskManager();
    private static final Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args)
    {
        /*
         Create menu functionalities
         Split classes
         Make methods
         Connect all the functionalities with the related menu ;)
         GL HF! ;)
        */
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\nWelcome to the To-Do List Application!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option)
            {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void registerUser()
    {
        System.out.println("\nUser Registration");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if ( userManager.registerUser(username, password) )
        {
            System.out.println("User registered successfully!");
        }
        else
        {
            System.out.println("Username already exists. Please choose another username.");
        }
    }

    private static void loginUser()
    {
        System.out.println("\nUser Login");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        currentUser = userManager.loginUser(username, password);
        if (currentUser != null)
        {
            System.out.println("Login successful!");
            showToDoListMenu();
        }
        else
        {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void showToDoListMenu()
    {
        boolean logout = false;
        while (!logout)
        {
            System.out.println("\nTo-Do List Menu");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option)
            {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    logout = true;
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void addTask()
    {
        System.out.println("\nAdd Task");
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        taskManager.addTask(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks()
    {
        System.out.println("\nYour To-Do List:");
        for ( String task : taskManager.getTasks() )
        {
            System.out.println("- " + task);
        }
    }

    private static void deleteTask()
    {
        System.out.println("\nDelete Task");
        System.out.print("Enter task description to delete: ");
        String task = scanner.nextLine();
        if ( taskManager.deleteTask(task) )
        {
            System.out.println("Task deleted successfully!");
        }
        else
        {
            System.out.println("Task not found in your to-do list.");
        }
    }
}