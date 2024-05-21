package com.moviedb;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieApp
{
    private static boolean isLoggedIn = false;

    public static void main(String[] args)
    {
        try(Scanner scanner = new Scanner(System.in))
        {
            UserDAO userDAO = new UserDAO();
            MovieDAO movieDAO = new MovieDAO();
            RatingDAO ratingDAO = new RatingDAO();
            RecommendationService recommendationService = new RecommendationService(ratingDAO, movieDAO);
            RegistrationService registrationService = new RegistrationService(userDAO);
            LoginService loginService = new LoginService(userDAO);
            MovieCatalog movieCatalog = new MovieCatalog(movieDAO);
            UserCatalog userCatalog = new UserCatalog(userDAO);
            RatingCatalog ratingCatalog = new RatingCatalog(ratingDAO);

            while(true)
            {
                System.out.println();
                System.out.println("--> Welcome to my MovieApp <--");

                if(!isLoggedIn)
                {
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice(1 to 3): ");
                }
                else
                {
                    System.out.println("1. Add Movie");
                    System.out.println("2. Add Rating");
                    System.out.println("3. Get Recommendations");
                    System.out.println("4. Display all movie");
                    System.out.println("5. Display all user");
                    System.out.println("6. Display all rating");
                    System.out.println("7. Logout");
                    System.out.println("8. Exit");
                    System.out.print("Enter your choice(1 to 8): ");
                }

                int choice;
                try
                {
                    choice = scanner.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid input!!! Please enter a number.");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();

                if(!isLoggedIn)
                {
                    switch(choice)
                    {
                        case 1:
                            registerUser(scanner, registrationService);
                            break;
                        case 2:
                            loginUser(scanner, loginService);
                            break;
                        case 3:
                            System.out.println("Exiting Done...");
                            return;
                        default:
                            System.out.println("Invalid choice. try again please.");
                    }
                }
                else
                {
                    switch(choice)
                    {
                        case 1:
                            addMovie(scanner, movieDAO, loginService);
                            break;
                        case 2:
                            addRating(scanner, ratingDAO, loginService);
                            break;
                        case 3:
                            getRecommendations(loginService, recommendationService);
                            break;
                        case 4:
                            movieCatalog.displayAllMovies();
                            break;
                        case 5:
                            userCatalog.displayAllUsers();
                            break;
                        case 6:
                            ratingCatalog.displayAllRatings();
                            break;
                        case 7:
                            logoutUser(loginService);
                            break;
                        case 8:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. try again please.");
                    }
                }
            }
        }
    }
    private static void registerUser(Scanner scanner, RegistrationService registrationService)
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if(registrationService.registerUser(username, email, password))
        {
            System.out.println("Registration successful...");
        }
        else
        {
            System.out.println("User already exist...");
        }
    }
    private static void loginUser(Scanner scanner, LoginService loginService)
    {
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        if(loginService.loginUser(loginUsername, loginPassword))
        {
            System.out.println("Login successful...");
            isLoggedIn = true;
        }
        else
        {
            System.out.println("Invalid username or password! please registration first.");
        }
    }
    private static void addMovie(Scanner scanner, MovieDAO movieDAO, LoginService loginService)
    {
        if(loginService.getLoggedInUser() == null)
        {
            System.out.println("Please login first...");
            return;
        }
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter release year: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Movie movie = new Movie(0, title, releaseYear, director, description);
        movieDAO.addMovie(movie);
        System.out.println("Movie added.");
    }
    private static void addRating(Scanner scanner, RatingDAO ratingDAO, LoginService loginService)
    {
        if(loginService.getLoggedInUser() == null)
        {
            System.out.println("Please login first...");
            return;
        }
        System.out.print("Enter movie ID: ");
        int movieId = scanner.nextInt();
        System.out.print("Enter rating (1-5): ");
        int ratingValue = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();

        Rating rating = new Rating(0, loginService.getLoggedInUser().getUserId(), movieId, ratingValue, comment);
        ratingDAO.addRating(rating);
        System.out.println("Rating added.");
    }
    private static void getRecommendations(LoginService loginService, RecommendationService recommendationService)
    {
        if(loginService.getLoggedInUser() == null)
        {
            System.out.println("Please login first...");
            return;
        }
        List<Movie> recommendations = recommendationService.getRecommendationsForUser(loginService.getLoggedInUser().getUserId());
        System.out.println("Recommended Movies: ");
        for(Movie recommendedMovie : recommendations)
        {
            System.out.println(recommendedMovie);
        }
    }
    private static void logoutUser(LoginService loginService)
    {
        loginService.logoutUser();
        System.out.println("Logout successful...");
        isLoggedIn = false;
    }
}
