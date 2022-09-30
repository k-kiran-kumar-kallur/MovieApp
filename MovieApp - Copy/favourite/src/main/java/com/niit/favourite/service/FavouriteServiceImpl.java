package com.niit.favourite.service;

import com.niit.favourite.exception.MovieAlreadyExist;
import com.niit.favourite.model.Movies;
import com.niit.favourite.model.User;
import com.niit.favourite.proxy.Proxy;
import com.niit.favourite.repository.FavouriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FavouriteServiceImpl implements FavouriteService {
    @Autowired
    FavouriteRepo favouriteRepo;
    @Autowired
    Proxy proxy;


    @Override
    public User registerUser(User user) {
        proxy.saveUser(user);
        return favouriteRepo.save(user);
    }

    @Override
    public List<Movies> addMoviesToFavourites(String username, Movies movies) throws MovieAlreadyExist {

        if (favouriteRepo.findById(username).isEmpty()) {
            return null;
        }
        else if (favouriteRepo.findById(username).get().getMovie() == null) {

            User u = favouriteRepo.findById(username).get();
            ArrayList<Movies> arrayList = new ArrayList<>();
            arrayList.add(movies);
            u.setMovie(arrayList);
            favouriteRepo.save(u);
            return u.getMovie();

        } else {
           List<Movies> m= favouriteRepo.findById(username).get().getMovie();
           long count= m.stream().filter(x->x.getMovieName().equalsIgnoreCase(movies.getMovieName())).count();
           if(count==0){
            User u = favouriteRepo.findById(username).get();
            List<Movies> movies1 = u.getMovie();
            movies1.add(movies);
            u.setMovie(movies1);
            favouriteRepo.save(u);
            return u.getMovie();}
           else {
          throw new MovieAlreadyExist();
           }
           }
        }




    @Override
    public boolean deleteMovieByMovieName(String username, String moviename) {
        if (favouriteRepo.findById(username).isPresent()) {
            User user = favouriteRepo.findById(username).get();
            List<Movies> moviesList = user.getMovie();
            List<Movies> movie2 = moviesList.stream().filter(f -> !f.getMovieName().equals(moviename)).toList();
            user.setMovie(movie2);
            favouriteRepo.save(user);

        }
        return true;
    }
@Override
    public User getAllMovie(String username){
        return favouriteRepo.findById(username).get();
}
    @Override
    public List<Movies> getAllMovielist(String username){
        return favouriteRepo.findById(username).get().getMovie();
    }

    @Override
    public Movies postComment(String username, String movieName, String comment) {
        User user=favouriteRepo.findById(username).get();
        List<Movies> movies = user.getMovie();
        Movies movie =  movies.stream().filter(x -> x.getMovieName().equalsIgnoreCase(movieName)).findAny().get();
        System.out.println(movie);

        if(movie.getComments() == null){
            System.out.println("first condition");
            ArrayList<String> comm=new ArrayList<>();
       comm.add(comment);
       movie.setComments(comm);
       favouriteRepo.save(user);

            return movie;
        }else {
            System.out.println("2nd condtion");
         List<String> commenting=movie.getComments();
         commenting.add(comment);
         movie.setComments(commenting);
  favouriteRepo.save(user);
            return movie;
        }


    }
    public List<User> getalluser(String movie){
      List<User> userlist =new ArrayList<>();
        List<User> user=favouriteRepo.findAll();

   for(User a :user){
       if(a.getMovie()!=null){

           for(Movies b:a.getMovie()){
               if(b.getMovieName().equalsIgnoreCase(movie)){
               if(b.getComments()!=null){
                  List<Movies> moviess= a.getMovie().stream().filter(x->x.getMovieName().equalsIgnoreCase(movie)).toList();
                a.setMovie(moviess);
                   userlist.add(a);
               }}
           }
       }
   }
   return userlist;
    }

}
