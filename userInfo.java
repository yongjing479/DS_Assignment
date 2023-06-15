package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class userInfo implements Serializable {
    private String name;
    private String address;
    private String gender;
    private static ArrayList<String> hobbies;
    private Stack<String> jobs;
    private String relationshipStatus;
    private String school;
    private int numOfFriends;

    Scanner sc = new Scanner(System.in);
    public userInfo() {
        this.hobbies = new ArrayList<String>();
        numOfFriends = 0;
        name = "";
        gender = "";
        this.jobs = new Stack<>();
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        boolean privacy = sc.nextBoolean();
        if(privacy)
            return address;
        else
            return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public ArrayList<String> getHobbies() {
        boolean privacy = sc.nextBoolean();
        if(privacy)
            return hobbies;
        else
            return null;
    }



    /**
     * Set the hobbies in multiple choice
     * @param hobbies
     */
    public void setHobbies(ArrayList<Integer> hobbies,ArrayList<String> otherHobbies) {
        if(this.hobbies != null) {
            this.hobbies.clear(); }

        for (int i = 0; i < hobbies.size(); i++) {
            addHobbies(hobbies.get(i));
        }

        for (int i = 0; i < otherHobbies.size(); i++) {
            this.hobbies.add(otherHobbies.get(i));
        }
    }

    public void addHobbies(Integer num){
        switch(num){
            case 1:
                this.hobbies.add("Art");
                break;
            case 2:
                this.hobbies.add("Cooking");
                break;
            case 3:
                this.hobbies.add("Dance");
                break;
            case 4:
                this.hobbies.add("Eating");
                break;
            case 5:
                this.hobbies.add("Listening to music");
                break;
            case 6:
                this.hobbies.add("Reading");
                break;
            case 7:
                this.hobbies.add("Sleeping");
                break;
            case 8:
                this.hobbies.add("Singing");
                break;
            case 9:
                this.hobbies.add("Watching films");
                break;
            default:
        }
    }

    public Stack<String> getJobs() {
        boolean privacy = sc.nextBoolean();
        if(privacy)
            return jobs;
        else
            return null;
    }

    public void setJobs(String[] jobs) {
        for (String content : jobs) {
            this.jobs.push(content);
        }
    }

    public void updateFriends(int i) {
        this.numOfFriends = i;
    }

    public int getNumOfFriends() {
        return numOfFriends;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        boolean privacy = sc.nextBoolean();
        if(privacy)
            return school;
        else
            return null;
    }

    public void setRelationshipStatus(String status) {
        this.relationshipStatus = status;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public String printArraylist(ArrayList<String> arraytoPrint) {
        String full_content = "";
        for (String content: arraytoPrint) {
            full_content += content + " ";
        }
        return full_content;
    }

    public String printStack(Stack<String> stacktoPrint){
        String full_content = "";
        for(String content : stacktoPrint)
            full_content += content + " ";
        return full_content;
    }


    public static void main(String[] args) {
        User user = new User();
        user.setInfo();
        System.out.print("Hobbies: ");
        for (int i = 0; i < hobbies.size(); i++) {
            System.out.print(hobbies.get(i)+", ");
        }
        System.out.println();
    }

}