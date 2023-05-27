package org.example;

import java.util.ArrayList;

public class Admin {
//    private ArrayList<User> admin;
    private boolean admins;
    private String report;

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
        LoginSystem userAccount = new LoginSystem();
        if(!admins) System.out.println("Only admins are allowed to delete the account");
        else{
            if(userAccount.login_info.size() == 0) {
                System.out.println("There is no account left");
                return false;
            }
            else{
                for (int i = 0; i < userAccount.login_info.size(); i++) {
                    if(userAccount.login_info.get(i).equals(username)){
                        userAccount.login_info.remove(i);
                        return true;
                    }
                }
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