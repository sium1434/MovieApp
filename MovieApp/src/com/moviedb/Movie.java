package com.moviedb;

public class Movie
{
    private int movieId;
    private String title;
    private int releaseYear;
    private String director;
    private String description;

    public Movie(int movieId, String title, int releaseYear, String director, String description)
    {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.description = description;
    }

    public int getMovieId()
    {
        return movieId;
    }
    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public int getReleaseYear()
    {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
    public String getDirector()
    {
        return director;
    }
    public void setDirector(String director)
    {
        this.director = director;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String toString()
    {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
