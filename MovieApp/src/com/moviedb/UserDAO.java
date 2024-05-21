package com.moviedb;

import java.util.ArrayList;
import java.util.List;

public class UserDAO
{
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public void addUser(User user)
    {
        user.setUserId(nextId++);
        users.add(user);
    }

    public User getUserById(int userId)
    {
        return users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
    }

    public List<User> getAllUsers()
    {
        return new ArrayList<>(users);
    }
}
