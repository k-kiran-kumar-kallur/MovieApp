package com.niit.favourite.controller;

import com.niit.favourite.exception.MovieAlreadyExist;
import com.niit.favourite.model.Movies;
import com.niit.favourite.model.User;
import com.niit.favourite.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class FavouriteController {
    @Autowired
    FavouriteService favouriteService;

    ResponseEntity responseEntity;

    @PostMapping("/fav/add/{username}")
    public ResponseEntity<?> addMoviesToFavourites(@PathVariable String username, @RequestBody Movies movie) throws MovieAlreadyExist {
        responseEntity=new ResponseEntity<>(favouriteService.addMoviesToFavourites(username,movie),HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(favouriteService.registerUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/fav/delete/{username}/{movieName}")
    public ResponseEntity<?> deleteMovie(@PathVariable String username,@PathVariable String movieName){
        return new ResponseEntity<>(favouriteService.deleteMovieByMovieName(username,movieName),HttpStatus.OK);
    }

    @GetMapping("/fav/allMovies/{username}")
    public ResponseEntity<?> getAllMovies(@PathVariable String username)
    {
        return new ResponseEntity<>(favouriteService.getAllMovie(username),HttpStatus.OK);
    }
    @GetMapping("/fav/allMovieslist/{username}")
    public ResponseEntity<?> getAllMovieslist(@PathVariable String username)
    {
        return new ResponseEntity<>(favouriteService.getAllMovielist(username),HttpStatus.OK);
    }

    @PostMapping("fav/comments/{username}/{movieName}/{comments}")
    public ResponseEntity<?> postComments(@PathVariable String username,@PathVariable String movieName,@PathVariable String comments ){
        System.out.println(username+""+movieName+""+comments);
             return new ResponseEntity<>(favouriteService.postComment(username,movieName,comments ),HttpStatus.OK);
    }
    @GetMapping("/fav/alluser/{movieName}")
    public ResponseEntity<?> getAlluser(@PathVariable String movieName)
    {
        return new ResponseEntity<>(favouriteService.getalluser(movieName),HttpStatus.OK);
    }

}
