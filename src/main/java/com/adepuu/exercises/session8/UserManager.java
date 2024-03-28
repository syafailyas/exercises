package com.adepuu.exercises.session8;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager
{
    private final Map<String, User> users;

    public UserManager()
    {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password)
    {
        if ( users.containsKey(username) )
        {
            return false; // User already exists
        }
        User newUser = new User(UUID.randomUUID(), username, password); // Expected 2 arguments but found 3
        users.put(username, newUser);
        return true; // Registration successful
    }

    public User loginUser(String username, String password)
    {
        User user = users.get(username);
        if ( user != null && user.authenticate(password) ) // Cannot resolve method 'authenticate' in 'User'
        {
            return user; // Authentication successful
        }
        return null; // Authentication failed
    }
}