package com.company.controllers;

import com.company.models.Account;
import com.company.models.Movie;
import com.company.models.PersonalMovie;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private String dbName;
    private String url;

    public DBConnect(String dbName) {
        this.dbName = dbName;
        this.url = "jdbc:sqlite:C:/sqlite/db/" + dbName;
    }

    public void createNewDatabase() {

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                //System.out.println("The driver name is " + meta.getDriverName());
                //System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addMovieTable(){

        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	title text NOT NULL,\n"
                + "	releaseDate text NOT NULL,\n"
                + " rating text NOT NULL\n"
                + ");";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Tables added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //"PersonalMovie#" + pMovieID + " Movie#" + movieID  +"Account#"+ accountID + "Interest: " + interest  +  " Title: " + title  + " ReleaseYear: " + releaseYear + "  Rating: " + rating;
    public void addPersonalMovieTable(){

        String sql = "CREATE TABLE IF NOT EXISTS personalMovies (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	movieID integer NOT NULL,\n"
                + " accountID integer NOT NULL,\n"
                + " interest integer NOT NULL,\n"
                + "	title text NOT NULL,\n"
                + "	releaseDate text NOT NULL,\n"
                + " rating text NOT NULL\n"
                + ");";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Personal Table added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<PersonalMovie> getPersonalMovies(){
        String sql = "SELECT id, movieID, accountID, interest, title, releaseDate, rating FROM personalmovies";
        ArrayList<PersonalMovie> personalMovieList = new ArrayList<PersonalMovie>();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            ResultSet pMovies = statement.executeQuery(sql);
            while(pMovies.next())
            {
                int id = pMovies.getInt("id");
                int movieID = pMovies.getInt("movieID");
                int accountID = pMovies.getInt("accountID");
                int interest = pMovies.getInt("interest");
                String title = pMovies.getString("title");
                String releaseDate = pMovies.getString("releaseDate");
                String rating = pMovies.getString("rating");
                PersonalMovie pMovie = new PersonalMovie(id, movieID, accountID, interest, title, releaseDate, rating);

                personalMovieList.add(pMovie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return personalMovieList;
    }

    public void addPersonalMovie(Integer movieID, Integer accountID, Integer interest, String title, String releaseDate, String rating){

        String sql = "INSERT INTO personalmovies(movieID, accountID, interest, title, releaseDate, rating) VALUES ('"+movieID+"', '"+accountID+"', '"+ interest + "', '" + title + "', '" + releaseDate + "', '" + rating + "');";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Personal Movie added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ArrayList<PersonalMovie> getIDPersonalMovies(int accountID){
        String sql = "SELECT id, movieID, accountID, interest, title, releaseDate, rating "
                + "FROM personalmovies WHERE accountID = ?";
        ArrayList<PersonalMovie> personalMovieList = new ArrayList<PersonalMovie>();
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,accountID);
            ResultSet pMovies = statement.executeQuery();

            while(pMovies.next())
            {
                int id = pMovies.getInt("id");
                int movieID = pMovies.getInt("movieID");
                accountID = pMovies.getInt("accountID");
                int interest = pMovies.getInt("interest");
                String title = pMovies.getString("title");
                String releaseDate = pMovies.getString("releaseDate");
                String rating = pMovies.getString("rating");
                PersonalMovie pMovie = new PersonalMovie(id, movieID, accountID, interest, title, releaseDate, rating);

                personalMovieList.add(pMovie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return personalMovieList;
    }

    public void addAccountTable(){

        String sql = "CREATE TABLE IF NOT EXISTS accounts (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL\n"
                + ");";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Tables added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addMovie(String title, String releaseDate, String rating){

        String sql = "INSERT INTO movies(title, releaseDate, rating) VALUES ('" + title + "', '" + releaseDate + "', '" + rating + "');";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Movie added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void addAccount(String name){

        String sql = "INSERT INTO accounts(name) VALUES ('" + name + "');";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            //System.out.println("Account added");
            statement.close();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ArrayList<Account> getAccounts(){
        String sql = "SELECT id, name FROM Accounts";
        ArrayList<Account> accountList = new ArrayList<Account>();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            ResultSet accounts = statement.executeQuery(sql);
            while(accounts.next())
            {
                int id = accounts.getInt("id");

                String name = accounts.getString("name");
                Account account = new Account(id, name);

                accountList.add(account);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return accountList;
    }

    public void deleteMovie(int id){
        String sql = "DELETE FROM movies WHERE id = ?";


        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void deleteAccount(int id){
        String sql = "DELETE FROM accounts WHERE id = ?";


        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deletePersonalMovie(int id){
        String sql = "DELETE FROM personalmovies WHERE id = ?";


        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public String getName(int id){
        String sql = "SELECT name "
                + "FROM accounts WHERE id = ?";
        String name = "";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet accounts = statement.executeQuery();

            while(accounts.next())
            {
                //System.out.println(name);
                name = accounts.getString("name");
                //System.out.println(name);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return name;
    }

    public ArrayList<Movie> getMovies(){
        String sql = "SELECT id, title, releaseDate, rating FROM movies";
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            ResultSet movies = statement.executeQuery(sql);
            while(movies.next())
            {
                int id = movies.getInt("id");
                String title = movies.getString("title");
                String releaseDate = movies.getString("releaseDate");
                String rating = movies.getString("rating");
                Movie movie = new Movie(id, title, releaseDate, rating);

                movieList.add(movie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return movieList;
    }
    public String getMovieTitle(int id){
        String sql = "SELECT title "
                + "FROM movies WHERE id = ?";
        String title = "";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet accounts = statement.executeQuery();

            while(accounts.next())
            {

                title = accounts.getString("title");
                //System.out.println(title);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return title;
    }

    public String getMovieRelease(int id){
        String sql = "SELECT releaseDate "
                + "FROM movies WHERE id = ?";
        String release = "";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet accounts = statement.executeQuery();

            while(accounts.next())
            {

                release = accounts.getString("releaseDate");
                //System.out.println(release);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return release;
    }

    public String getMovieRating(int id){
        String sql = "SELECT rating "
                + "FROM movies WHERE id = ?";
        String rating = "";
        //System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url)){
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet accounts = statement.executeQuery();

            while(accounts.next())
            {

                rating = accounts.getString("rating");
                //System.out.println(rating);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rating;
    }

}
