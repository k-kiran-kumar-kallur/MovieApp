package com.niit.favourite.repository;

import com.niit.favourite.model.GenreIds;
import com.niit.favourite.model.Movies;
import com.niit.favourite.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class FavouriteRepository {
    @Autowired
    private  FavouriteRepo favouriteRepo;
    private Movies movies;
    private User user;
    private GenreIds genreIds;

    private Movies movies1;
    private User user1;
    private GenreIds genreIds1;


//    private Movies movies1;
//    private User user1;
//    private GenreIds genreIds1;


    @BeforeEach
    public void settingUp()
    {

        user = new User("kiran@1231","kiran123233","12345","7899601441", (List<Movies>) movies);
        movies= new Movies("prey","20/2/1997","ghghdghdg","7","goodmovie", (List<GenreIds>) genreIds, List.of(new String[]{"good"}));
        genreIds = new GenreIds(10);

        user1 = new User("kiran@12311","kiran122223333","12345","7899601441", (List<Movies>) movies1);
        movies1= new Movies("prey","20/2/1997","ghghdghdg","7","goodmovie", (List<GenreIds>) genreIds1,List.of(new String[]{"nice movie"}));
        genreIds1 = new GenreIds(10);


    }
    @AfterEach
    public void refreshing(){
        movies =null;
        user=null;
        genreIds = null;
        favouriteRepo.deleteAll();


    }


    @Test
    public void  givenMovieDataToSaveAndReturnMoviesData(){
        favouriteRepo.insert(user);
        User user1 = favouriteRepo.findById(user.getUsername()).get();
        assertNotNull(user1);
        assertEquals(user.getUsername(),user1.getUsername());
    }
    @Test
    public void givenUserDataDelete(){
        favouriteRepo.insert(user);
        User user1 = favouriteRepo.findById(user.getUsername()).get();

        favouriteRepo.delete(user1);
        assertEquals(Optional.empty(),favouriteRepo.findById(user.getUsername()));

    }



}
