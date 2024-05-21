package com.moviedb;

public class Rating
{
    private int ratingId;
    private int userId;
    private int movieId;
    private int rating;
    private String comment;

    public Rating(int ratingId, int userId, int movieId, int rating, String comment)
    {
        this.ratingId = ratingId;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRatingId()
    {
        return ratingId;
    }
    public void setRatingId(int ratingId)
    {
        this.ratingId = ratingId;
    }
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public int getMovieId()
    {
        return movieId;
    }
    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }
    public int getRating()
    {
        return rating;
    }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    public String getComment()
    {
        return comment;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
