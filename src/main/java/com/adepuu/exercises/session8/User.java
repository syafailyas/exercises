package com.adepuu.exercises.session8;

import java.util.Objects;

public class User
{
    private final String username;
    private final String password;
    private final ToDoList todoList;

    public User(String username, String password)
    {
        ToDoList todoList = new ToDoList();
        this.username = username;
        this.password = password;
        this.todoList = todoList;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean checkCredentials(String username, String password)
    {
        return this.username.equals(username) && this.password.equals(password);
    }

    public ToDoList getTodoList()
    {
        return this.todoList;
    }
}