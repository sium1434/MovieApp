package com.moviedb;

import java.util.ArrayList;
import java.util.List;

public class RatingDAO
{
    private List<Rating> ratings = new ArrayList<>();
    private int nextId = 1;

    public void addRating(Rating rating)
    {
        rating.setRatingId(nextId++);
        ratings.add(rating);
    }

    public List<Rating> getTopRatings()
    {
        return ratings;
    }
}
