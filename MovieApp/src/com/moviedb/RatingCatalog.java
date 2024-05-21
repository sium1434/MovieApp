package com.moviedb;

import java.util.List;

public class RatingCatalog
{
    private RatingDAO ratingDAO;

    public RatingCatalog(RatingDAO ratingDAO)
    {
        this.ratingDAO = ratingDAO;
    }

    public void displayAllRatings()
    {
        List<Rating> ratings = ratingDAO.getTopRatings();
        if(ratings.isEmpty())
        {
            System.out.println("No ratings found in the database.");
        }
        else{
            System.out.println("Ratings in the database:");
            for(Rating rating : ratings)
            {
                System.out.println(rating);
            }
        }
    }
}
