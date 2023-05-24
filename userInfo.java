package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class userInfo implements Serializable {
    private String name;
    private String address;
    private String gender;
    private ArrayList<String> hobbies;
    private ArrayList<String> jobs;
    private String relationshipStatus;
    private String school;
    private int numOfFriends;

    public userInfo() {
    	this.hobbies = new ArrayList<String>();
    	numOfFriends = 0;
    	name = "";
    	gender = "";
    	this.jobs = new ArrayList<String>();
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
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
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
    	if(this.hobbies != null) {
    	this.hobbies.clear(); }
    	
    	for (String content : hobbies) {
    		this.hobbies.add(content);
    	}
    }

    public ArrayList<String> getJobs() {
        return jobs;
    }

    public void setJobs(String[] jobs) {
    	if(this.jobs != null) {
        	this.jobs.clear(); }
        	
        	for (String content : jobs) {
        		this.jobs.add(content);
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
    	return school;
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
    
}
