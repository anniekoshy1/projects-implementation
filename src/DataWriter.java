import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    // Attributes
    private boolean isDataBaseConnected;
    private int maxUsers = 100000;
    private int maxCourses = 500;

    private static final String USERS_FILE = "user.json";
    private static final String COURSES_FILE = "courses.json";
    private static final String LANGUAGES_FILE = "language.json";
    private static final String LESSONS_FILE = "lessons.json";


    // Constructor
    public DataWriter() {
        // No code for now
    }

    // Methods
    @SuppressWarnings("unchecked")
	public boolean saveUsers(ArrayList<User> users) {
        if (users.size() > maxUsers) {
            System.err.println("Cannot save users: maximum user limit reached.");
            return false;
        }

        JSONArray userArray = new JSONArray();

        for (User user : users) {
            JSONObject userJson = new JSONObject();
            userJson.put("id", user.getId().toString());
            userJson.put("username", user.getUsername());
            userJson.put("email", user.getEmail());
            userJson.put("password", user.getPassword());

            // Add user object to JSON array.
            userArray.add(userJson);
        }

        return writeToFile(USERS_FILE, userArray);
    }

    private boolean writeToFile(String filePath, JSONArray jsonArray) {
    try (FileWriter fileWriter = new FileWriter(filePath)) {
        // Write the JSON array as a string to the file.
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        System.out.println("Data saved successfully to " + filePath);
        return true;
    } catch (IOException e) {
        // Print an error message if writing fails.
        System.err.println("Error writing data to " + filePath + ": " + e.getMessage());
        return false;
    }
    }

    public boolean saveCourses(ArrayList<Course> courses) {
        JSONArray courseArray = new JSONArray();

        for (Course course : courses) {
            JSONObject courseJson = new JSONObject();
            courseJson.put("id", course.getId().toString());
            courseJson.put("name", course.getName());
            courseJson.put("description", course.getDescription());

            // Add course object to JSON array.
            courseArray.add(courseJson);
        }

        return writeToFile(COURSES_FILE, courseArray);
    }

    public boolean saveLanguages(ArrayList<Language> languages) {
        // No code for now
        return false;
    }

    public boolean saveLessons(ArrayList<Lesson> lessons) {
        // No code for now
        return false;
    }

    public void saveProgress(User user) {
        // No code for now
    }

    public void saveAssessmentResults(User user, Assessment assessment) {
        // No code for now
    }

    public void setCourseAccess() {
        // No code for now
    }

    public boolean connectToDatabase() {
        isDataBaseConnected = true;
        System.out.println("Database connected.");
        return isDataBaseConnected;
    }

    public boolean disconnectFromDatabase() {
        isDataBaseConnected = false;
        System.out.println("Database disconnected");
        return !isDataBaseConnected;
    }

    public boolean savePhrase(Phrase phrase) {
        // No code for now
        return false;
    }
}
