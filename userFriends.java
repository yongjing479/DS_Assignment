package org.example;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;


//empty for now haven't done anything in it
public class userFriends implements Serializable{
    private ArrayList<User> friends;
    private ArrayList<User> pending;
    private ArrayList<User> blocked;

    private ArrayList<User> mutualFriends;

    public userFriends() {
        friends = new ArrayList<User>();
        pending = new ArrayList<User>();
        blocked = new ArrayList<User>();
        mutualFriends = new ArrayList<>();
    }

    public ArrayList<User> getFriends(){
        return friends;
    }

    public ArrayList<User> getPending(){
        return pending;
    }

    public ArrayList<User> getMutualFriends() {
        return mutualFriends;
    }

    public boolean checkifFriend(User user) {
        if (friends.contains(user)) {
            return true;
        }
        return false;
    }

    public boolean checkifPending(User user) {
        if (pending.contains(user)) {
            return true;
        }
        return false;
    }


    public void addFriends(User user) {
        pending.add(user);
    }

    public void acceptFriend(User user) {
        if	(checkifPending(user)) {
            pending.remove(user);
            friends.add(user);
        }
    }

    public void declineFriend(User user) {
        if	(checkifPending(user)) {
            pending.remove(user);
        }
    }

    public void removeFriends(User user) {
        for (User account : friends) {
            if (account.equals(user)) {
                friends.remove(account);
            }
        }
    }

    public void setMutualFriends(User user){
        for (int i = 0; i < friends.size(); i++) { //my friend
            userFriends friend = user.getFriends();
            for (int j = 0; j < friend.friends.size(); j++) {// another user friends
                if(friends.get(i).equals(friend.friends.get(j))){
                    mutualFriends.add(friends.get(i));
                }
            }
        }
    }
}
