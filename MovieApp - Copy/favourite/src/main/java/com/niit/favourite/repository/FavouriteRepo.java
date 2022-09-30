package com.niit.favourite.repository;

import com.niit.favourite.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FavouriteRepo extends MongoRepository<User,String> {

}
