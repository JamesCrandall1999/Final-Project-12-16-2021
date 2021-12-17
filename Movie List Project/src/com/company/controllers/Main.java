package com.company.controllers;


import com.company.models.Account;
import com.company.models.Movie;
import com.company.models.PersonalMovie;
import com.company.views.UserView;

import java.util.ArrayList;

public class Main {







    public static void main(String[] args) {
        int num = 0;
        int num2 = 0;
        String name = "";
        String title;
        String releaseYear;
        String rating;
        int interest;
        int id = 0;


        UserView view = new UserView();
        DBConnect db = new DBConnect("MovieList.db");
        db.createNewDatabase();
        db.addMovieTable();
        db.addPersonalMovieTable();
        db.addAccountTable();
        ArrayList<Movie> theMovies = db.getMovies();
        ArrayList<PersonalMovie> personalMovies = db.getPersonalMovies();
        ArrayList<Account> accounts = db.getAccounts();
        view.startup();
        startmenu: while (num != 5) {

            num = Integer.parseInt(view.startMenu());
            while ((num != 1)&&(num != 2)&& (num != 3)&&(num != 4)&&(num != 5)){
               view.invalid1();
                num = Integer.parseInt(view.startMenu());
            }
            switch (num) {

                 case 1:
                    try {

                        id = Integer.parseInt(view.loginMenu(accounts));
                        name = db.getName(id);
                    }
                    catch (NumberFormatException e)
                    {
                        id = 0;
                    }
                     mainmenu:while (num != 8) {
                        num2 = Integer.parseInt(view.mainMenu(name, id));
                        while ((num2 != 1) && (num2 != 2) && (num2 != 3) && (num2 != 4) && (num2 != 5) && (num2 != 6) && (num2 != 7) && (num2 != 8)) {
                            view.invalid2();
                            num2 = Integer.parseInt(view.mainMenu(name, id));



                        }

                         switch (num2) {
                            case 1:
                                view.showMovies(theMovies);
                                view.willContinue();

                                continue mainmenu;

                            case 2:
                                title = view.inputTitle();
                                releaseYear = view.inputReleaseYear();
                                rating = view.inputRating();
                                db.addMovie(title, releaseYear, rating);

                                continue mainmenu;

                            case 3:
                                int numberinput = Integer.parseInt(view.inputid());
                                db.deleteMovie(numberinput);

                                continue mainmenu;

                            case 4:
                                personalMovies = db.getIDPersonalMovies(id);
                                view.showPersonalMovies(personalMovies);
                                view.willContinue();

                                continue mainmenu;

                            case 5:
                                numberinput = Integer.parseInt(view.getPMovieInput());
                                title = db.getMovieTitle(numberinput);
                                releaseYear = db.getMovieRelease(numberinput);
                                rating = db.getMovieRating(numberinput);
                                interest = Integer.parseInt(view.inputInterest());
                                db.addPersonalMovie(numberinput, id, interest, title, releaseYear, rating);

                                continue mainmenu;

                            case 6:
                                numberinput = Integer.parseInt(view.inputid());
                                db.deletePersonalMovie(numberinput);

                                continue mainmenu;

                            case 7:
                                personalMovies = db.getPersonalMovies();
                                view.showPersonalMovies(personalMovies);
                                view.willContinue();
                                continue mainmenu;

                            case 8:

                                continue startmenu;

                        }

                         continue mainmenu;
                    }

                case 2:
                    name = view.accountCreateMenu();
                    db.addAccount(name);

                    continue startmenu;
                case 3:

                    num = Integer.parseInt(view.inputaccount());
                    db.deleteAccount(num);

                    continue startmenu;
                case 4:
                    view.help();

                    continue startmenu;

                case 5:
                    System.exit(0);

                    break;


            }
        }








    }


}