package com.niit.temp.repository;

import com.niit.temp.entity.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends MongoRepository<MovieEntity, Long> {

}
