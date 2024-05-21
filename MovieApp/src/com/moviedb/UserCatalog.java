package com.moviedb;

import java.util.List;

public class UserCatalog
{
    private UserDAO userDAO;

    public UserCatalog(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public void displayAllUsers()
    {
        List<User> users = userDAO.getAllUsers();
        if(users.isEmpty())
        {
            System.out.println("No users found in the database.");
        }
        else{
            System.out.println("Users in the database:");
            for(User user : users)
            {
                System.out.println(user);
            }
        }
    }
}
