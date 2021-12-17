package com.company.models;

public class PersonalMovie {

    private int id;
    private int movieID;
    private int accountID;
    private int interest;
    private String title;
    private String releaseYear;
    private String rating;


    public PersonalMovie(int id, int movieID, int accountID, int interest, String title, String releaseYear, String rating) {
        this.id = id;
        this.movieID = movieID;
        this.accountID = accountID;
        this.interest = interest;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getid() {
        return id;
    }

    public void setpMovieID(int id) {
        this.id = id;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int userID) {
        this.accountID = accountID;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public String toString(){
        return "PMovie#" + id + " Movie#" + movieID  +" Account#"+ accountID + " Interest: " + interest  +  " Title: " + title  + " ReleaseYear: " + releaseYear + "  Rating: " + rating;
    }
}
