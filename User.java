package org.example;




import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.awt.desktop.UserSessionEvent;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class User<T> implements Serializable {
    private String username;
    private String password;

    private String email;
    private String phoneNumber;
    private userInfo info;
    private userFriends friends;
    private LocalDate birthday;
    private int id;
     Admin admin;
    private byte[] salt;
    private byte[] hash;

    public User(String username, String password, String email, String phoneNumber, LocalDate birthdayDate, int id)  {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.info = new userInfo();
        this.friends = new userFriends();
        this.birthday = birthdayDate;
        this.admin = new Admin(false);
        try {
            this.hash = passwordHash(password);
        }catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        }
        catch(InvalidKeySpecException e){
            System.out.println("Th Key Spec is invalid");
        }
    }

    public User(){}

    // Getters and setters for username, password, email, and phoneNumber
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge(){
        if(birthday != null){
            return Period.between(birthday,LocalDate.now()).getYears();
        }
        else{
            return 0;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public userFriends getFriends() {
        return friends;
    }

    public byte[] getHash() {
        return hash;
    }

    public void displayInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("Name: " + info.getName());
        System.out.println("Id: " + this.id);
        System.out.println("Birthday: " + this.getBirthday());
        System.out.println("Age: " + this.getAge());
        System.out.println("Gender: " + info.getGender());
        System.out.println("Job(s): " + info.printArraylist(info.getJobs()));
        System.out.println("Hobbies: " + info.printArraylist(info.getHobbies()));
    }

    public void displayInfo2(User currentUser) {
        System.out.println("Username: " + this.username);
        System.out.println("Name: " + info.getName());
        System.out.println("Id: " + this.id);
        System.out.println("Birthday: " + this.getBirthday());
        System.out.println("Age: " + this.getAge());
        System.out.println("Gender: " + info.getGender());
        System.out.println("Job(s): " + info.printArraylist(info.getJobs()));
        System.out.println("Hobbies: " + info.printArraylist(info.getHobbies()));
        System.out.println("Mutual friend(s): " + friends.mutualFriends(currentUser).size());
        System.out.print("List of Mutual Friends: ");
        for (User user: friends.mutualFriends(currentUser)) {
            System.out.print(user.getUsername() + " ");
        }
        System.out.println("");

    }

    public void setInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to skip");

        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!name.isBlank()) {
            info.setName(name);
        }

        System.out.print("Gender: ");
        String gender = sc.nextLine();
        if (!gender.isBlank()) {
            info.setGender(gender);
        }

        System.out.print("Address: ");
        String address = sc.nextLine();
        if (!address.isBlank()) {
            info.setAddress(address);
        }

        System.out.print("School: ");
        String School = sc.nextLine();
        if (!School.isBlank()) {
            info.setSchool(School);
        }

        System.out.print("Relationship status: ");
        String status = sc.nextLine();
        if (!status.isBlank()) {
            info.setRelationshipStatus(status);
        }

        System.out.print("Jobs (separate with ,): ");
        String jobs = sc.nextLine();
        if (!jobs.isBlank()) {
            String[] job = jobs.split(",");
            info.setJobs(job);
        }

        System.out.print("Hobbies (separate with ,): ");
        String hobbies = sc.nextLine();
        if (!hobbies.isBlank()) {
            String[] hob = hobbies.split(",");
            info.setHobbies(hob);
        }


    }

    public void updateFriend() {
        int numofFriend = friends.getFriends().size();
        info.updateFriends(numofFriend);
    }

    public boolean isFriend(User user) {
        return friends.checkifFriend(user);
    }

    public void addFriend(User user) {
        if (!isFriend(user)) {
            friends.addFriends(user);
            user.friends.addFriends(this);
            System.out.printf("Successfully sent a friend request to %s\n", user.getUsername());
        } else {
            System.out.println("Already a friend");
        }
    }

    public void setAdmin(boolean admin) {
        this.admin.setAdmins(admin);
    }

    public void removeFriend(User user) {
        if (isFriend(user)) {
            removeFriend(user);
            user.removeFriend(this);
            updateFriend();
            user.updateFriend();
            System.out.printf("%s successfully removed as a friend\n", user.getUsername());
        } else {
            System.out.printf("%s is not your friend\n", user.getUsername());
        }
    }

    public void seePending() {
        Scanner scanner = new Scanner(System.in);
        for (User user: friends.getPending()) {
            System.out.println(user.getUsername());
        }
        System.out.println("Which user do you want to interact with?");
        int toInteract = scanner.nextInt() - 1;
        if (toInteract > friends.getPending().size()) {
            System.out.println("Invalid index");
        } else {
            System.out.println("1 to accept, 2 to decline");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    acceptFriend(friends.getPending().get(toInteract));
                    break;
                case 2:
                    declineFriend(friends.getPending().get(toInteract));
                    break;
                default:
                    System.out.println("type 1 or 2 only");
            }
        }

    }


    public void acceptFriend(User user) {
        friends.acceptFriend(user);
        user.friends.acceptFriend(this);
        updateFriend();
        user.updateFriend();
    }

    public void declineFriend(User user) {
        friends.declineFriend(user);
        user.friends.declineFriend(this);
    }

    public void getFriendSuggestion(ArrayList<User> UsersList) {
        System.out.println("Lists of suggested friends: ");
        int amount = 0;
        for(User user : friends.suggestedFriends(UsersList, this)) {
            System.out.println(user.getUsername() + ": " + friends.mutualFriends(user).size());
            if (amount == 5) {
                break;
            }
            amount++;
        }
        if (amount == 0) {
            System.out.println("No suggested friends found");
        }
    }

    public int compareTo(User user){
        if(this.getId() > user.getId()) return 1;
        else if (this.getId() == user.getId()) { return 0;
        }
        else return -1;
    }

    /**
     * When the user first sign up an account or renew the acount password
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public byte[] passwordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if(hash == null){
            SecureRandom random = new SecureRandom();
            salt = new byte[16];
            random.nextBytes(salt);
        }
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        hash = factory.generateSecret(spec).getEncoded();
        return hash;
    }

    /**
     * Everytime user login account
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public byte[] verifyPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] verifyHash = factory.generateSecret(spec).getEncoded();
        return verifyHash;
    }



}
