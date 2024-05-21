package com.moviedb;

import java.util.List;

public class MovieCatalog
{
    private MovieDAO movieDAO;

    public MovieCatalog(MovieDAO movieDAO)
    {
        this.movieDAO = movieDAO;
    }

    public void displayAllMovies()
    {
        List<Movie> movies = movieDAO.getAllMovies();
        if(movies.isEmpty())
        {
            System.out.println("No movies found in the database.");
        }
        else
        {
            System.out.println("Movies in the database:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }
}
