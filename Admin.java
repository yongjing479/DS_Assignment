package org.example;

import java.util.ArrayList;

public class Admin {
    private boolean admins;
    private Friend friend ;

    public Admin(){}
    public Admin(boolean admins){
        this.admins = admins;
    }

    //to add any user as admin
    public void addAdmin(User user){
        user.setAdmin(true);
        System.out.println(user.getUsername() + "has set as admin");
    }

    //remove the user from admin
    public void removeAdmin(User user){
        user.setAdmin(false);
        System.out.println(user.getUsername() + "has remove from admin");
    }

    public void setAdmins(boolean admins) {
        this.admins = admins;
    }

    public boolean getAdmins(){
        return admins;
    }

    //to delete any user account
    public boolean deleteAccount(String username){
        if(!admins) System.out.println("Only admins are allowed to delete the account");
        else{
            if(friend.size == 0) {
                System.out.println("There is no account left");
                return false;
            }
            else{
                friend.removeAccount(username);
                System.out.printf("%s account has been removed sucessfully\n",username);
                return true;
            }
        }
        return false;
    }

    public void deletePosts(User users){
        if(!admins) System.out.println("Only admins are allowed to delete the posts");
        else{

        }
    }

}