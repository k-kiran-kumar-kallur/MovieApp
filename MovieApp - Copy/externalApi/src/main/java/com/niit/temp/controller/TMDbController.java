package com.niit.temp.controller;


import com.niit.temp.entity.MovieEntity;
import com.niit.temp.service.Impl.TMDbServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/tmdb")

public class TMDbController {
    @Autowired
    private TMDbServiceImpl movieService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllTopRatedMovies(){
       return new ResponseEntity<>(movieService.fetchMovieList(), HttpStatus.OK);
    }
    @GetMapping("/listname/{name}")
    public ResponseEntity<?> getMovieByName(@PathVariable String name){
        MovieEntity m =new MovieEntity();
        m.setName(name);
        return new ResponseEntity<>(movieService.SearchByName(m.getName()), HttpStatus.OK);
    }
    @GetMapping("/listid/{id}")
    public ResponseEntity<?> getMovieByName(@PathVariable long id){
        MovieEntity m =new MovieEntity();
        m.setMovieId(id);
        return new ResponseEntity<>(movieService.SearchById(m.getMovieId()), HttpStatus.OK);
    }
    @GetMapping("/listed/{page}")
    public ResponseEntity<?> getAllTopRatedMovie(@PathVariable long page){
        MovieEntity m =new MovieEntity();
        m.setPage(page);
        return new ResponseEntity<>(movieService.fetchMovie(m.getPage()), HttpStatus.OK);
    }

}