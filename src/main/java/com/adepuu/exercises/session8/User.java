package com.adepuu.exercises.session8;

import java.util.UUID;

public class User
{
    private final UUID id;
    private final String username;
    private final String password;

    public User(UUID id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UUID getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean authenticate(String inputPassword)
    {
        return this.password.equals(inputPassword);
    }
}