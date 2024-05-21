package com.moviedb;

public class RegistrationService
{
    private UserDAO userDAO;

    public RegistrationService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public boolean registerUser(String username, String email, String password)
    {

        for(User user : userDAO.getAllUsers()) {
            if(user.getUsername().equals(username) || user.getEmail().equals(email))
            {
                return false;
            }
        }

        User newUser = new User(0, username, email, password);
        userDAO.addUser(newUser);
        return true;
    }
}
