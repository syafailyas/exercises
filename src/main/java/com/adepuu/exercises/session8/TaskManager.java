package com.adepuu.exercises.session8;

import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
    private final List<String> tasks;

    public TaskManager()
    {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task)
    {
        tasks.add(task);
    }

    public List<String> getTasks()
    {
        return tasks;
    }

    public boolean deleteTask(String task)
    {
        return tasks.remove(task);
    }
}