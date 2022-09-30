package com.niit.temp.service.Impl;
import com.niit.temp.model.Movie;
import com.niit.temp.model.MovieResults;
import com.niit.temp.service.MovieDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;
@Service
public class TMDbServiceImpl implements MovieDbService<Movie> {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Movie> fetchMovieList() {
     return Objects.requireNonNull(restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=46e31cc13e0b6fa30f404cef8227affd&with_genres=28", MovieResults.class)).getResults();
    }
    @Override
    public List<Movie> SearchByName(String movieName) {
        return Objects.requireNonNull(restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=46e31cc13e0b6fa30f404cef8227affd&query="+movieName, MovieResults.class)).getResults();
    }
    public List<Movie>  SearchById(long id) {
        return Objects.requireNonNull(restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=46e31cc13e0b6fa30f404cef8227affd&with_genres="+id, MovieResults.class)).getResults();
    }
    @Override
    public List<Movie> fetchMovie(long i) {
    return Objects.requireNonNull(restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=46e31cc13e0b6fa30f404cef8227affd&&page="+i, MovieResults.class)).getResults();
    }
}
