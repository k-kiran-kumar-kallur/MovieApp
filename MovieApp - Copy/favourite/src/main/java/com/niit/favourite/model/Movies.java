package com.niit.favourite.model;

import java.util.List;

public class Movies {

    private String movieName;
    private String releaseDate;
    private String pictureURL;
    private String popularity;
    private String overview;
    private List<GenreIds> genreId;
    private List<String> comments;

    public Movies() {
    }

    public Movies(List<String> comments) {
        this.comments = comments;
    }

    public Movies(String movieName, String releaseDate, String pictureURL, String popularity, String overview, List<GenreIds> genreId, List<String> comments) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.pictureURL = pictureURL;
        this.popularity = popularity;
        this.overview = overview;
        this.genreId = genreId;
        this.comments = comments;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<GenreIds> getGenreId() {
        return genreId;
    }

    public void setGenreId(List<GenreIds> genreId) {
        this.genreId = genreId;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieName='" + movieName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", pictureURL='" + pictureURL + '\'' +
                ", popularity='" + popularity + '\'' +
                ", overview='" + overview + '\'' +
                ", genreId=" + genreId +
                ", comments=" + comments +
                '}';
    }
}
