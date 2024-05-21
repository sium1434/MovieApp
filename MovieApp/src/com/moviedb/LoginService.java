package com.moviedb;

public class LoginService
{
    private UserDAO userDAO;
    private User loggedInUser;

    public LoginService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public boolean loginUser(String username, String password)
    {
        for(User user : userDAO.getAllUsers())
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public void logoutUser()
    {
        loggedInUser = null;
    }

    public User getLoggedInUser()
    {
        return loggedInUser;
    }
}
