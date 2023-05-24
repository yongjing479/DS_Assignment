package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


//empty for now haven't done anything in it
public class userFriends implements Serializable {
	private ArrayList<User> friends;
	private ArrayList<User> pending;
    
    
	public userFriends() {
		friends = new ArrayList<User>();
		pending = new ArrayList<User>();
		
	}
	
	public ArrayList<User> getFriends(){
		return friends;
	}
	
	public ArrayList<User> getPending(){
		return pending;
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
	
	public ArrayList<User> mutualFriends(User user) {
		ArrayList<User> MutualFriends = new ArrayList<User>();
		int mutuals = 0;
		for (User friends : user.getFriends().getFriends()) {
			for (User friends2 : this.getFriends()) {
				if (friends.equals(friends2)) {
					MutualFriends.add(friends);
					mutuals++;
					break;
				}
			}
		}
		return MutualFriends;
	}
	
	public ArrayList<User> suggestedFriends(ArrayList<User> listOfUsers, User cUser){
		ArrayList<User> suggestedFriends = new ArrayList<User>();
		for(User users : listOfUsers) {
			if (checkIfEligible(users) && !cUser.equals(users)) {
				if (mutualFriends(users).size() != 0) {
				suggestedFriends.add(users);
				}
			}
		}
		
		sortUsersByMutualFriends(suggestedFriends);
		return suggestedFriends;
	}
	
	private boolean checkIfEligible(User user){
		if (checkifFriend(user) || checkifPending(user)) {
			return false;
		}
		return true;
	}
	
	private ArrayList<User> sortUsersByMutualFriends(ArrayList<User> listOfUsers) {
		for (int i = 0; i < listOfUsers.size() - 1; i++) {
            for (int j = i + 1; j < listOfUsers.size(); j++) {
                User user1 = listOfUsers.get(i);
                User user2 = listOfUsers.get(j);
                if (this.mutualFriends(user1).size() < this.mutualFriends(user2).size()) {
                    // Swap the users
                    listOfUsers.set(i, user2);
                    listOfUsers.set(j, user1);
                }
            }
        }
		return listOfUsers;
	}
	
}