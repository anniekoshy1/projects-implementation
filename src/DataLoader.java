import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataLoader {

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
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_USERNAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);

            // Further parsing logic goes here (e.g., convert each JSON object into a User object)

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean confirmUser(String username, String password) {
        return false;
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>();
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