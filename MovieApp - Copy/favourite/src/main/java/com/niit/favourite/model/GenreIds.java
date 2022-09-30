package com.niit.favourite.model;

public class GenreIds {

    private int id;

    public GenreIds() {
    }

    public GenreIds(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Genreid{" +
                "id=" + id +
                '}';
    }
}
