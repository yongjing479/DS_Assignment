package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SocialMediaGroup {
    LinkedList member = new LinkedList<>();
    String groupName ;
    String description;
    User admin;
    ArrayList content = new ArrayList<>();

    public SocialMediaGroup(String name, User creator){
        groupName = name;
        admin = creator;
    }

    public SocialMediaGroup(String name, String description, User creator){
        groupName = name;
        this.description = description;
        admin = creator;
        addMember(creator);
    }

    public boolean addMember(User user){
        if(member.contains(user)) {
            System.out.println("This user already exists in this group");
            return false;
        }
        else{
            member.add(user);
            return true;
        }
    }

    public boolean removeMember(User user){
        if(!member.contains(user)){
            System.out.println("This user does not exist in this group");
            return false;
        }
        else{
            member.remove(user);
            return true;
        }
    }

    public void leaveGroup(User user){
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure want to leave group?");
        String comfirm = input.next();

        if(comfirm.compareToIgnoreCase("yes")==0){
            member.remove(user);
            System.out.println("You have leave from the group");
        }
    }

    public void addContent(String message){
        content.add(message);
    }

    public void removeContent(String message){
        if(content.contains(message)){
            content.remove(message);
            System.out.println("Message deleted");
        }
    }
}
