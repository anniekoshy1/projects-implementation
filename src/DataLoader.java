import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataLoader {
    private static final String USERS_FILE = "user.json";
    private ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        // DataLoader dataLoader = new DataLoader();
        // ArrayList<User> userList = dataLoader.getUserList();

        // for (int i = 0; i < Math.min(userList.size(), 8); i++) {
        //     User user = userList.get(i);
        //     System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        // }

        // User user2 = userList.get(1); 
        // System.out.println("\n--- Displaying User2 ---");
        // System.out.println("Username: " + user2.getUsername() + ", Password: " + user2.getPassword());

        // System.out.println("Program terminated.");
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(USERS_FILE)) {
            // Parse the JSON file into an Object.
            Object obj = jsonParser.parse(fileReader);
            // Cast the parsed object into a JSONArray.
            JSONArray userArray = (JSONArray) obj;

            // Iterate through each object in the JSONArray.
            for (Object userObject : userArray) {
                // Cast each object into a JSONObject.
                JSONObject userJson = (JSONObject) userObject;

                // Extract user attributes from the JSONObject.
                UUID id = UUID.fromString((String) userJson.get("id"));
                String username = (String) userJson.get("username");
                String email = (String) userJson.get("email");
                String password = (String) userJson.get("password");

                // Create a new User object and add it to the list.
                User user = new User(id, username, email, password);
                users.add(user);
            }
            System.out.println("Users loaded successfully.");
        } catch (IOException | ParseException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public boolean confirmUser(String username, String password) {
        ArrayList<User> users = getUsers();
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        
        return false;
    }

    public ArrayList<Language> getLanguages() {
        return new ArrayList<>();
    }

    public void loadUserProgress(User user) {
    }

    public ArrayList<Assessment> loadAssessmentHistory(User user) {
        return new ArrayList<>();
    }

    public ArrayList<Phrase> loadPhrases() {
        return new ArrayList<>();
    }

    public ArrayList<Lesson> getLessons() {
        return new ArrayList<>();
    }

    public void saveUserProgress(User user) {
    }

    public void saveAssessmentHistory(User user, Assessment assessment) {
    }

    public void saveCourses(ArrayList<Course> courses) {
    }

    public void saveLanguages(ArrayList<Language> languages) {
    }
}