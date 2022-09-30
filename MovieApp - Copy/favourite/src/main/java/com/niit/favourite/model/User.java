package com.niit.favourite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class User {


   private String emailID;
    @Id
    private String username;

    private String password;

   private String contactNO;

   private List<Movies> movie;

    public User() {
    }

    public User(String emailID, String username, String password, String contactNO, List<Movies> movie) {
        this.emailID = emailID;
        this.username = username;
        this.password = password;
        this.contactNO = contactNO;
        this.movie = movie;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNO() {
        return contactNO;
    }

    public void setContactNO(String contactNO) {
        this.contactNO = contactNO;
    }

    public List<Movies> getMovie() {
        return movie;
    }

    public void setMovie(List<Movies> movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailID='" + emailID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactNO='" + contactNO + '\'' +
                ", movie=" + movie +
                '}';
    }
}
