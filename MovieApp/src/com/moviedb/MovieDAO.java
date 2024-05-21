package com.moviedb;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO
{
    private List<Movie> movies = new ArrayList<>();
    private int nextId = 1;

    public void addMovie(Movie movie)
    {
        movie.setMovieId(nextId++);
        movies.add(movie);
    }

    public List<Movie> getAllMovies()
    {
        return new ArrayList<>(movies);
    }

    public Movie getMovieById(int movieId)
    {
        return movies.stream().filter(m -> m.getMovieId() == movieId).findFirst().orElse(null);
    }
}
