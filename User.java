package org.example;


import jdk.internal.icu.text.UnicodeSet;

import java.awt.desktop.UserSessionEvent;
import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

public class User implements Serializable, Comparable<User> {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private userInfo info;
    private userFriends friends;
    private int id;
    //private ArrayList<User> mutualFriends ;
    private Admin admin;

    public User(String username, String password, String email, String phoneNumber, int id, boolean admin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.info = new userInfo();
        this.friends = new userFriends();
        this.admin = new Admin(admin);

        //this.mutualFriends = friends.getMutualFriends();
    }

    public User(){}

    // Getters and setters for username, password, email, and phoneNumber
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public ArrayList<User> getMutualFriends() {
//        return mutualFriends;
//    }

    public userFriends getFriends() {
        return friends;
    }

    public void displayInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("Name: " + info.getName());
        System.out.println("Id: " + this.id);
        System.out.println("Birthday: " + info.getBirthday());
        System.out.println("Age: " + info.getAge());
        System.out.println("Gender: " + info.getGender());
        System.out.println("Job(s): " + info.getJobs());
        System.out.println("Hobbies: " + info.printArraylist(info.getHobbies()));
    }

    public void setInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to skip");

        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!name.isBlank()) {
            info.setName(name);
        }

        System.out.print("Birthday (year): ");
        String year = sc.nextLine();
        if (!year.isBlank()) {
            System.out.print("Birthday (month): ");
            String month = sc.nextLine();
            if (!month.isBlank()) {
                System.out.print("Birthday (date): ");
                String date = sc.nextLine();
                if (!date.isBlank()) {
                    LocalDate birthdayDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(date));
                    info.setBirthday(birthdayDate);
                }
            }
        }

        System.out.print("Gender: ");
        String gender = sc.nextLine();
        if (!gender.isBlank()) {
            info.setGender(gender);
        }

        System.out.print("Job: ");
        String Job = sc.nextLine();
        if (!Job.isBlank()) {
            info.setJobs(Job);
        }

        System.out.print("Hobbies (separate with ,): ");
        String hobbies = sc.nextLine();
        if (!hobbies.isBlank()) {
            String[] hob = hobbies.split(",");
            info.setHobbies(hob);
        }

    }

    public void setAdmin(boolean admin) {
        this.admin.setAdmins(admin);
    }

    @Override
    public int compareTo(User user){
        if(this.getId() > user.getId()) return 1;
        else if (this.getId() == user.getId()) { return 0;
        }
        else return -1;
    }


}
