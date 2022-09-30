package com.niit.temp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document
public class MovieEntity {
    @Id
    private Long movieId;

    private String name;

    private long page;

    public MovieEntity() {
    }

    public MovieEntity(Long movieId, String name, long page) {
        this.movieId = movieId;
        this.name = name;
        this.page = page;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
