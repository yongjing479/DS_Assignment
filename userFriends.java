package org.example;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


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

//    public ArrayList<User> mutualFriends(User user) {
//        ArrayList<User> MutualFriends = new ArrayList<User>();
//        int mutuals = 0;
//        for (User friends : user.getFriends().getFriends()) {
//            for (User friends2 : this.getFriends()) {
//                if (friends.equals(friends2)) {
//                    MutualFriends.add(friends);
//                    mutuals++;
//                    break;
//                }
//            }
//        }
//        return MutualFriends;
//    }

    public ArrayList<User> suggestedFriends(ArrayList<User> listOfUsers, User cUser, Friend userGraph){
        ArrayList<User> suggestedFriends = new ArrayList<User>();
        for(User users : listOfUsers) {
            if (checkIfEligible(users) && !cUser.equals(users)) {
                if (findMutualFriend(userGraph,users).size() != 0) {
                    suggestedFriends.add(users);
                }
            }
        }

        sortUsersByMutualFriends(suggestedFriends, userGraph);
        return suggestedFriends;
    }

    private boolean checkIfEligible(User user){
        if (checkifFriend(user) || checkifPending(user)) {
            return false;
        }
        return true;
    }

    private ArrayList<User> sortUsersByMutualFriends(ArrayList<User> listOfUsers, Friend userGraph) {
        for (int i = 0; i < listOfUsers.size() - 1; i++) {
            for (int j = i + 1; j < listOfUsers.size(); j++) {
                User user1 = listOfUsers.get(i);
                User user2 = listOfUsers.get(j);
                if (this.findMutualFriend(userGraph,user1).size() < this.findMutualFriend(userGraph,user2).size()) {
                    // Swap the users
                    listOfUsers.set(i, user2);
                    listOfUsers.set(j, user1);
                }
            }
        }
        return listOfUsers;
    }

    /**
     * To find the mutual friends with the current user and the another user
     * Prerequisite: The friends list for the current user have to add into the arraylist<User> friends
     * the size of arrayList mutualfriend is the number of mutual friend
     * @param listOfUsers : Friend
     * @param owner : User (the another user want to compare)
     * @return the arrayList of mutual friend
     */
    public ArrayList<User> findMutualFriend(Friend listOfUsers, User owner){
        if(listOfUsers == null) return null;
        if(!listOfUsers.hasVertex(owner)) return null;
        ArrayList<User> mutualFriend = new ArrayList<>();
        Vertex temp = listOfUsers.head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(owner)==0){
                Edge current = temp.firstEdge;
                while(current != null){
                    for (User friend: this.getFriends()) {
                        if(current.toVertex.vertexInfo.equals(friend)){
                            mutualFriend.add(friend);
                        }

                    }
                    current = current.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        mutualFriends = mutualFriend;
        return mutualFriend;
    }




//    public static void main(String[] args) {
//        userFriends ff = new userFriends();
//        Friend fr = new Friend<>();
//        LocalDate x = LocalDate.ofEpochDay(22/03/102);
//        User a = new User<>("a","a","a","a",x,1);
//        User b = new User<>("ab","ab","ab","ab",x,12);
//        User c = new User<>("ac","ac","ac","ac",x,13);
//        User d = new User<>("ad","ad","ad","ad",x,14);
//        User e = new User<>("ae","ae","ae","ae",x,15);
//        User f = new User<>("af","af","af","af",x,16);
//        User g = new User<>("afg","afg","afg","afg",x,167);
//        fr.addVertex(a);
//        fr.addVertex(b);
//        fr.addVertex(c);
//        fr.addVertex(d);
//        fr.addVertex(e);
//        fr.addVertex(f);
//        fr.addFriend(a,c);
//        fr.addFriend(a,d);
//        fr.addFriend(a,e);
//        ff.friends.add(c);
//        ff.friends.add(d);
//        ff.friends.add(e);
//        System.out.println(ff.friends.get(0).getUsername());
//        System.out.println(ff.friends.get(1).getUsername());
//        System.out.println(ff.friends.get(2).getUsername());
//
//        fr.addFriend(b,c);
//        fr.addFriend(b,e);
//        fr.addFriend(b,f);
//        fr.printEdges();
//        System.out.println(ff.findMutualFriend(fr,c));
//        for (User print : ff.mutualFriends) {
//            System.out.println(print.getUsername());
//        }
//        System.out.println(ff.mutualFriends.size());
//    }
}
