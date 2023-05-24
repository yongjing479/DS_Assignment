package application;

import java.util.*;

public class main{
	public static void main(String[] args) {
	    LoginSystem loginSystem = new LoginSystem();
	    UserSearch userSearch = new UserSearch(loginSystem);
	    loginSystem.loadFromFile();
	    Scanner scanner = new Scanner(System.in);
	    boolean quit = false;
	    while (!quit) {
	    	System.out.println("1. Login");
	        System.out.println("2. Sign up");	        
	        System.out.println("3. Logout");
	        System.out.println("4. Set your info");
	        System.out.println("5. Display your info");
	        System.out.println("6. Search");
	        System.out.println("7. See pending");	        
	        System.out.println("8. List of User");
	        System.out.println("9. Suggested Friends");
	        System.out.println("10. Quit");
	        System.out.print("Enter a choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // consume the newline character
		        switch (choice) {
		            case 1:
		                loginSystem.login();
		                break;
		            case 2:
		                loginSystem.signUp();
		                break;
		            case 3:
		                loginSystem.logout();
		                break;
		            case 4:
		            	if (loginSystem.isLoggedIn()) {
		            		loginSystem.getCurrentUser().setInfo();
		            		loginSystem.saveToFile();
			            	}
		            	break;
		                
		            case 5:
		            	if (loginSystem.isLoggedIn()) {
		            		loginSystem.getCurrentUser().displayInfo();
		            	
		            	}
		            	break;
		            	
		            case 6:
		            	if (loginSystem.isLoggedIn()) {
		            		userSearch.search();
		            		loginSystem.saveToFile();
		            	}
		                break;
		            case 7:
		            	if (loginSystem.isLoggedIn()) {
		            		loginSystem.getCurrentUser().seePending();
		            		loginSystem.saveToFile();
		            	}
		                break;
		            case 8:
		            	loginSystem.displayAllUsers();
		                break;
		            case 9:
		            	if (loginSystem.isLoggedIn()) {
		            		loginSystem.displaySuggestedFriends();
		            	}
		                break;
		            case 10:
		            	quit = true;
		            	break;
		            default:
		                System.out.println("Invalid choice. Please enter a number between 1 and 8.");
		        }
	    }
	}
}