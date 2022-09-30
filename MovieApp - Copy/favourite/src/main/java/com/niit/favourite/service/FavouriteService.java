package com.niit.favourite.service;

import com.niit.favourite.exception.MovieAlreadyExist;
import com.niit.favourite.model.Movies;
import com.niit.favourite.model.User;

import java.util.List;

public interface FavouriteService {

    public User registerUser(User user);

    public List<Movies> addMoviesToFavourites(String username,Movies movies) throws MovieAlreadyExist;

    public boolean deleteMovieByMovieName(String username,String moviename);

    public User getAllMovie(String username);
    public List<Movies> getAllMovielist(String username);

     public Movies postComment(String username,String movieName,String comment);
    public List<User> getalluser(String movie);
}
