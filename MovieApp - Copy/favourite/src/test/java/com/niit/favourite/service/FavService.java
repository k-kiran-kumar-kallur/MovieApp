package com.niit.favourite.service;

import com.niit.favourite.exception.MovieAlreadyExist;
import com.niit.favourite.model.GenreIds;
import com.niit.favourite.model.Movies;
import com.niit.favourite.model.User;
import com.niit.favourite.repository.FavouriteRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class FavService {
    @Mock
    private FavouriteRepo favouriteRepo;

    @InjectMocks
    private FavouriteServiceImpl favouriteServiceimpl;
    private User user1,user2;

    List<User> userList;
    List<Movies> moviesList;
    Movies movies1,movies2;
    GenreIds genreIds1,genreIds2;
    @BeforeEach
    public void setUp(){
        user1 = new User("kiran@1231","kiran123233","12345","7899601441", (List<Movies>) movies1);
        movies1= new Movies("prey","20/2/1997","ghghdghdg","7","goodmovie", (List<GenreIds>) genreIds1,List.of(new String[]{"good"}));
        genreIds1 = new GenreIds(10);

        user2 = new User("kiran@12311","kiran122223333","12345","7899601441", (List<Movies>) movies2);
        movies2= new Movies("prey","20/2/1997","ghghdghdg","7","goodmovie", (List<GenreIds>) genreIds2,List.of(new String[]{"nice movie"}));
        genreIds2 = new GenreIds(10);

        userList = Arrays.asList(user1,user2);
        moviesList = Arrays.asList(movies1);

    }
    @AfterEach
    public void tearDown()
    {
        user1=null;
        user2=null;
    }

    @Test
    public void givenUserDataSaveAndReturnUserData() throws MovieAlreadyExist {
        when(favouriteRepo.findById(user1.getUsername())).thenReturn(Optional.ofNullable(user1));
        when(favouriteRepo.save(any())).thenReturn(user1);
        assertEquals(moviesList,favouriteServiceimpl.addMoviesToFavourites(user1.getUsername(), movies1));
        verify(favouriteRepo,times(1)).save(any());
        verify(favouriteRepo,times(3)).findById(any());

    }

    //
//    @Test
//    public void givenUserDataToSaveReturnUserDataFailure(){
//        when(favouriteRepo.findById(user1.getUsername())).thenReturn(Optional.ofNullable(user1));
//        assertThrows(MovieAlreadyExist.class,()->favouriteServiceimpl.addMoviesToFavourites(user1.getUsername(), movies1));
//        verify(favouriteRepo,times(1)).save(any());
//        verify(favouriteRepo,times(3)).findById(any());
//    }
//@Test
//public void givenCustomerToDeleteShouldDeleteSuccess() {
//    when(favouriteRepo.findById(user2.getUsername())).thenReturn(Optional.ofNullable(user2));
//    boolean flag =favouriteServiceimpl.deleteMovieByMovieName(user2.getUsername(),movies2.getMovieName());
//    assertEquals(true,flag);
//
////    verify(favouriteRepo,times(1)).deleteById(any());
//    verify(favouriteRepo,times(2)).findById(any());
//}
    @Test
    public void givenUserDataSaveAndReturnUser()  {
        when(favouriteRepo.findById(user1.getUsername())).thenReturn(Optional.ofNullable(user1));
//    when(favouriteRepo.save(any())).thenReturn(user1);
        assertEquals(user1,favouriteServiceimpl.getAllMovie(user1.getUsername()));
//    verify(favouriteRepo,times(1)).save(any());
        verify(favouriteRepo,times(1)).findById(any());

    }
}
