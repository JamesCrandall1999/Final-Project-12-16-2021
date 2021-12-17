package com.company.views;

import com.company.models.Account;
import com.company.models.Movie;
import com.company.models.PersonalMovie;

import java.util.ArrayList;
import java.util.Scanner;

    public class UserView {

        public void willContinue(){

            System.out.println("Enter Y/y To Continue:");
            Scanner input = new Scanner(System.in);
            char letter = input.next().charAt(0);


            while((letter != 'y')&&(letter !='Y')){
                System.out.println("Enter Y or y To Continue:");
                input = new Scanner(System.in);
                letter = input.next().charAt(0);


            };


        }
        public void startup(){
            System.out.println("Welcome to my Movie List App\n");
            System.out.println("Alpha warning: To see changes in the database, restart the application");
            willContinue();

        }
        public void help(){
            System.out.println("Starting Menu Options");
            System.out.println("1. Select Account: Allows user to select an account");
            System.out.println("2. Create Account: Allows user to create an account");
            System.out.println("3. Delete Account: Allows user to delete an account");
            System.out.println("4. Exit Application:  Restart to see changes to database\n");
            System.out.println("Main Menu Options");
            System.out.println("1. Display Group Movie List: View the list of all general movies");
            System.out.println("2. Add Group Movie: Add movie to the general list");
            System.out.println("3. Delete Group Movie: Delete row of given id for general list");
            System.out.println("4. Diplay Your Personal Movie List: View your accounts's movies in the personal list");
            System.out.println("5. Add Movie To Personal List: Add a Movie from general list, with interest meter, to personal list");
            System.out.println("6. Delete Movie From Personal List: Select ID for Movie to be deleted from personal list");
            System.out.println("7. Display All Personal Movies: Shows everyone's personal lists. ");
            System.out.println("8. Back: Allows to go back to start screen\n");
            willContinue();



        }

    public void invalid1(){
    System.out.println("Invalid, Enter A Number From 1 To 5");

    }
    public void invalid2(){
        System.out.println("Invalid, Enter A Number From 1 To 8");

    }

    public String inputTitle(){
        System.out.println("Enter Movie Title: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }
    public String inputReleaseYear(){
        System.out.println("Enter Release Year: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();

    }
    public String inputRating(){
        System.out.println("Enter Rating: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();

    }
    public String inputInterest(){
        System.out.println("Enter Interest(1-10): ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();

    }

    public String inputid(){
        System.out.println("Enter Movie ID To Delete: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }

    public String inputaccount(){
        System.out.println("Enter Account ID To Delete: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }


    public String startMenu(){

        System.out.println("1. Select Account");
        System.out.println("2. Create Account");
        System.out.println("3. Delete Account");
        System.out.println("4. Help");
        System.out.println("5. Exit Program\n");
        System.out.println("Select Option: ");

        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String loginMenu(ArrayList<Account> accountList){
        System.out.println("Current Accounts\n");
        showAccounts(accountList);
        System.out.println("Enter Account Number:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String getDeletePMovie() {
        System.out.println("Personal Movie Number To Delete:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String getPMovieInput() {
        System.out.println("Movie Number To Add:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String getInput() {
        System.out.println("Movie Number To Delete:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String accountCreateMenu(){
        System.out.println("Creating Account\n");
        System.out.println("Enter Account Name: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public String mainMenu(String name, int id){
        System.out.println("Account #"+ id + ", "+ name + ", Options Are Listed Below.\n");
        System.out.println("1. Display Group Movie List");
        System.out.println("2. Add Group Movie");
        System.out.println("3. Delete Group Movie");
        System.out.println("4. Display Your Personal Movie List");
        System.out.println("5. Add Movie To Personal List");
        System.out.println("6. Delete Movie From Personal List");
        System.out.println("7. Display All Personal Movies");
        System.out.println("8. Back\n");
        System.out.println("Select: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();


    }

    public String groupMovieMenu(){

        System.out.println("1. View Movies");
        System.out.println("2. Add Movie");
        System.out.println("3. Redo Movie");
        System.out.println("4. Delete Movie");
        System.out.println("5. Back");
        System.out.println("Select Option:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();

    }

    public void showMovies(ArrayList<Movie> theMovies){
        for(Movie movie : theMovies){
            System.out.println(movie.toString());
        }


    }

    public void showPersonalMovies(ArrayList<PersonalMovie> pMovies){
        for(PersonalMovie pmovie : pMovies){
            System.out.println(pmovie.toString());
        }


    }

    public void showAccounts(ArrayList<Account> accounts){
        for(Account account : accounts){
            System.out.println(account.toString());
        }


    }

    public void personalMovieList(){
        System.out.println("Select Option\n");
        System.out.println("1. View Group Movies\n");
        System.out.println("2. View Personal Movies\n");


    }






}

