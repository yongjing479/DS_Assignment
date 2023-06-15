package application;

import java.sql.SQLException;
import java.util.Random;
public class MockDataCreation {
    private DatabaseConnection dbConnection;
    private int rowCount;

    public MockDataCreation(int rowCount) {
        this.rowCount = rowCount;
        dbConnection = new DatabaseConnection();
    }

    public void generateMockData() {
        try {
            dbConnection.connect();

            String[] firstNames = {"Zaghlool", "Jihaad", "Hijau", "Daniel", "Kaarim", "Mushtaaq", "Baheej", "Faai", "Intan", "Melati", "Kiambang", "Tuah", "Tam", "Som", "Lai"
                                    , "Ratnasari", "Joyo", "Kesuma", "Wira", "Darma", "Wati", "Abdul", "Abdullah", "Ahmad", "Aimi", "Aishah", "Akma", "Abas", "Abdull", "Abiddin"};

            String[] lastNames = {"Tan","Lim","Lee","Wong","Wan","Ng","bin Ismail","bin Abdullah","bin Ahmad","binti Ismail","binti Abdullah","binti Ahmad","Chong","Rahman"
                                    , "Chan","Ali","bin Ibrahim","binti Ibrahim","Ong","Chin","Nor","Noor","Yap","Che","Yusof","bin Othman","binti Othman","bin Mohamad","Isa"
                                        ,"binti Mohamad","Aziz ","Yong ","Bakar ","Goh ","Low ","Liew ","bin Hassan ","bin Mohamed ","binti Hassan ","Leong ","Hamid ","Lai ","bin Zakaria"};


            String[] states = {"Johor", "Kedah", "Kelantan", "Melaka (Malacca)", "Negeri Sembilan", "Pahang", "Perak", "Perlis", "Pulau Pinang (Penang)", "Sabah", "Sarawak", "Selangor", "Terengganu"};


            String[][] userData = generateRandomUserData(rowCount, firstNames, lastNames);
            fillUserTable(userData);
            fillUserInfoTable(userData, firstNames, lastNames, states);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String[][] generateRandomUserData(int rowCount, String[] firstNames, String[] lastNames) {
        String[][] userData = new String[rowCount][5];

        Random random = new Random();
        for (int i = 0; i < rowCount; i++) {
            String username = "User" + (i + 1);
            String email = "user" + (i + 1) + "@example.com";
            String phoneNumber = "011" + random.nextInt(9999999);
            String password = generateRandomPassword();
            String birthday = generateRandomBirthday();

            userData[i][0] = username;
            userData[i][1] = email;
            userData[i][2] = phoneNumber;
            userData[i][3] = password;
            userData[i][4] = birthday;
        }

        return userData;
    }

    public String generateRandomPassword() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        int passwordLength = 8 + random.nextInt(3);

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public String generateRandomBirthday() {
        Random random = new Random();
        int year = 1950 + random.nextInt(53);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);

        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public void fillUserTable(String[][] userData) throws SQLException {
        for (String[] user : userData) {
            String username = user[0];
            String email = user[1];
            String phoneNumber = user[2];
            String password = user[3];

            dbConnection.addUser(username, email, phoneNumber, password);
        }
    }

    public void fillUserInfoTable(String[][] userData, String[] firstNames, String[] lastNames, String[] states) throws SQLException {
        Random random = new Random();
        String[] Hobbies = {"Art", "Cooking", "Dance", "Eating", "Listening to music", "Reading", "Sleeping", "Singing", "Watching films", "Other"};
        String[] Jobs = {"Accountant", "Actor", "Actuary", "Architect", "Artist", "Astronomer", "Attorney", "Author", "Baker", "Barber", "Bartender", "Biologist", "Bookkeeper", "Builder", "Butcher", "Carpenter", "Cashier", "Chef", "Chemist", "Coach", "Dentist", "Designer", "Detective", "Dietitian", "Doctor", "Driver",
                    "Economist", "Editor", "Electrician", "Engineer", "Farmer", "Firefighter", "Fisherman", "Florist", "Gardener", "Geologist", "Hairdresser", "Historian", "Interpreter", "Janitor", "Journalist", "Judge", "Lawyer", "Librarian", "Lifeguard", "Linguist", "Manager", "Mechanic", "Model", "Musician", "Nurse",
                    "Optician", "Painter", "Pharmacist", "Photographer", "Physician", "Pilot", "Plumber", "Police officer", "Politician", "Programmer", "Psychologist", "Scientist", "Secretary", "Singer", "Soldier", "Statistician", "Surgeon", "Tailor", "Teacher", "Technician", "Translator", "Waiter", "Writer"};

        String[] Countries = {"Malaysia", "Singapore", "Indonesia", "Thailand", "Vietnam", "Myanmar", "Cambodia", "Laos", "Philippines", "Brunei"};
        for (String[] user : userData) {
            int age = 18 + random.nextInt(50);
            String address = generateRandomAddress(states, random);
            String gender = random.nextBoolean() ? "Male" : "Female";
            String countryOfOrigin = Countries[random.nextInt(Countries.length)];
            String hobbies = Hobbies[random.nextInt(Hobbies.length)];
            String jobs = Jobs[random.nextInt(Jobs.length)];
            String birthday = user[4];
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String name = firstName + " " + lastName;

            String [] MaritalStatusList = {"Single","Married","Divorced","Widowed"};
            String maritalStatus = MaritalStatusList[random.nextInt(MaritalStatusList.length)];

            dbConnection.addUserInfo(name, birthday, age, address, gender, countryOfOrigin, hobbies, jobs, maritalStatus);
        }
    }

    public String generateRandomAddress(String[] states, Random random) {
        String state = states[random.nextInt(states.length)];
        int zipCode = 10000 + random.nextInt(90000);
        String randomString = generateRandomString(15);

        return state + " " + zipCode + " Jalan " +" "+ randomString;
    }

    public String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }
}
