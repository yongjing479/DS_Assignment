package application;


import java.util.ArrayList;
import java.util.Scanner;

public class UserSearch {
    private LoginSystem loginSystem;

    public UserSearch(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a search query (minimum 3 characters): ");
        String searchQuery = scanner.nextLine();
        if (searchQuery.length() < 3) {
            System.out.println("Search query must have at least 3 characters.");
            return;
        }
        ArrayList<User> foundUsers = new ArrayList<>();
        for (User user : loginSystem.getUsers()) {
            if (user.getUsername().contains(searchQuery) ||
                    user.getEmail().equals(searchQuery) ||
                    user.getPhoneNumber().equals(searchQuery)) {
                foundUsers.add(user);
            }
        }
        if (foundUsers.size() > 0) {
        	
        	// Manual sorting by username in descending order
            for (int i = 0; i < foundUsers.size() - 1; i++) {
                for (int j = i + 1; j < foundUsers.size(); j++) {
                    User user1 = foundUsers.get(i);
                    User user2 = foundUsers.get(j);
                    if (user1.getUsername().compareTo(user2.getUsername()) < 0) {
                        // Swap the users
                        foundUsers.set(i, user2);
                        foundUsers.set(j, user1);
                    }
                }
            }
   
            System.out.println("Found " + foundUsers.size() + " user(s):");
            for (User user : foundUsers) {
                System.out.println("Username: " + user.getUsername());
                System.out.println();
            }
            System.out.println("Which profile do you want to open? ");
            int profiletoOpen = scanner.nextInt() - 1;
            if (profiletoOpen < foundUsers.size()) {
            	foundUsers.get(profiletoOpen).displayInfo2(loginSystem.getCurrentUser());
            	add(foundUsers.get(profiletoOpen));
            } else {
				System.out.println("Out of bound");
			}
            
        } else {
            System.out.println("No users found.");
        }
    }
    
    public void add(User user) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Type 1 to add friend\nType 2 to go back");
    	if (scanner.nextInt() == 1) {
    		loginSystem.getCurrentUser().addFriend(user);
    		loginSystem.saveToFile();
    	}
	}
    
}