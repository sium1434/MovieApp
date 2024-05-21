package com.moviedb;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService
{
    private RatingDAO ratingDAO;
    private MovieDAO movieDAO;

    public RecommendationService(RatingDAO ratingDAO, MovieDAO movieDAO)
    {
        this.ratingDAO = ratingDAO;
        this.movieDAO = movieDAO;
    }

    public List<Movie> getRecommendationsForUser(int userId)
    {
        List<Movie> recommendedMovies = new ArrayList<>();
        List<Rating> topRatings = ratingDAO.getTopRatings();
        for(Rating rating : topRatings)
        {
            Movie movie = movieDAO.getMovieById(rating.getMovieId());
            if(movie != null)
            {
                recommendedMovies.add(movie);
            }
        }
        return recommendedMovies;
    }
}
