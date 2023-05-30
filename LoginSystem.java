package org.example;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class LoginSystem {
    private ArrayList<User> login_info; // arraylist to store login info as string arrays
    private boolean loggedIn;
    private User currentUser;
    private int currentUserId;

    public LoginSystem() {
        login_info = new ArrayList<>();
        loggedIn = false;
        currentUser = null;
        currentUserId = -1;
    }

    // Method to create a new account
    public void signUp() {
        if (loggedIn) {
            System.out.println("You are already logged in. Please log out before creating a new account.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();


        System.out.print("Enter birthday(Date/Month/Year eg.21/12/2021): ");
        String birthday = scanner.nextLine();
        String[] birthDayArray = birthday.split("/");

        LocalDate birthdayDate = LocalDate.of(Integer.valueOf(birthDayArray[2]), Integer.valueOf(birthDayArray[1]), Integer.valueOf(birthDayArray[0]));
        boolean flag = true;

        if ( Period.between(birthdayDate, LocalDate.now()).getYears() < 13) {
            flag = false;
            System.out.println("You must be at least 13 years old to use this service");
        }

        if (flag) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            System.out.print("Retype the password: ");
            String Repassword = scanner.nextLine();

            if(password.equals(Repassword) && flag) {
                login_info.add(new User(username, password, email, phone, birthdayDate, login_info.size())); // add the account to the login_info arraylist
                System.out.println("Account created successfully.");
                saveToFile();
            } else {
                System.out.println("Password does not match");
            }
        }
    }

    // Method to check if a username and password are valid and return true if they are
    public boolean login() throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (loggedIn) {
            System.out.println("You are already logged in. Please log out before logging in again.");
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        for (User account : login_info) {
            if (account.getUsername().equals(username) && account.getHash().equals(currentUser.passwordHash(password))) { /** change to password hashing */
                System.out.println("Login successful.");
                loggedIn = true;
                currentUser = account;
                currentUserId = account.getId();
                return true;
            } else if (account.getEmail().equals(username) && account.getHash().equals(currentUser.passwordHash(password))) {
                System.out.println("Login successful.");
                loggedIn = true;
                currentUser = account;
                currentUserId = account.getId();
                return true;
            } else if (account.getPhoneNumber().equals(username) && account.getHash().equals(currentUser.passwordHash(password))) {
                System.out.println("Login successful.");
                loggedIn = true;
                currentUser = account;
                currentUserId = account.getId();
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    // Method to log out the current user
    public void logout() {
        if (loggedIn) {
            System.out.println("Logging out " + currentUser.getUsername());
            loggedIn = false;
            currentUser = null;
            currentUserId = -1;
        } else {
            System.out.println("You are not currently logged in.");
        }
    }

    // Method to save login_info to a file
    public void saveToFile() {
        try {
            String fileName = "login_info";
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(login_info);
            out.close();
            fileOut.close();
            System.out.println("Login info saved to " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {
            String fileName = "login_info";
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            login_info = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Login info loaded from " + fileName);
        } catch (IOException i) {
            System.out.println("File not found, the next save will create a new file");
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    //setter getter
    public ArrayList<User> getUsers(){
        return login_info;
    }

    public User getUser(int id){
        return login_info.get(id);

    }

    public int getCurrentId() {
        return currentUserId;
    }

    public boolean isLoggedIn() {
        if(loggedIn) {
            return true;
        }
        System.out.println("You need to be logged in");
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void displayPendingFriends() {
        currentUser.seePending();
    }

    public void displayAllUsers() {
        for (User user : login_info) {
            System.out.println(user.getUsername());
        }
    }

    public void displaySuggestedFriends() {
        currentUser.getFriendSuggestion(login_info);
    }

    public ArrayList<User> getLogin_info() {
        return login_info;
    }
}

