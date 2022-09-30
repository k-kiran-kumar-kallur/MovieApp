package com.niit.temp.service;

import com.niit.temp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface MovieDbService<T> {
    public List<Movie> fetchMovieList();
    public List<Movie> SearchByName(String movieName);
    public List<Movie> fetchMovie(long i);

}
