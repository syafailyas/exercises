package com.adepuu.exercises.session8;

import java.util.UUID;

public class Task
{
    private final UUID id;
    private final String description;

    public Task(String description)
    {
        this.id = UUID.randomUUID();
        this.description = description;
    }

    public UUID getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }
}