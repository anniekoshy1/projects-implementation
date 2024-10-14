import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    private boolean isDataBaseConnected;
    private int maxUsers = 100000;
    private int maxCourses = 500;

<<<<<<< HEAD
    private static final String USER_DATA_FILE = "users.json";
    private static final String COURSE_DATA_FILE = "courses.json";
    private static final String LANGUAGE_DATA_FILE = "languages.json";

=======
    private static final String USERS_FILE = "user.json";
    private static final String COURSES_FILE = "courses.json";
    private static final String LANGUAGES_FILE = "language.json";
    private static final String LESSONS_FILE = "lessons.json";


    // Constructor
>>>>>>> 1c657970e10471a114d77874975a43e6f10577be
    public DataWriter() {
    }

<<<<<<< HEAD
    public boolean saveUsers(ArrayList<User> users) {
        JSONArray usersJSON = new JSONArray();

        for (User user : users) {
            usersJSON.add(serializeUser(user));
        }

        return writeToFile(USER_DATA_FILE, usersJSON);
=======
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
>>>>>>> 1c657970e10471a114d77874975a43e6f10577be
    }
    }

    public boolean saveCourses(ArrayList<Course> courses) {
<<<<<<< HEAD
        JSONArray coursesJSON = new JSONArray();

        for (Course course : courses) {
            coursesJSON.add(serializeCourse(course));
        }

        return writeToFile(COURSE_DATA_FILE, coursesJSON);
=======
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
>>>>>>> 1c657970e10471a114d77874975a43e6f10577be
    }

    public boolean saveLanguages(ArrayList<Language> languages) {
        JSONArray languagesJSON = new JSONArray();

        for (Language language : languages) {
            languagesJSON.add(serializeLanguage(language));
        }

        return writeToFile(LANGUAGE_DATA_FILE, languagesJSON);
    }

    public void saveProgress(User user) {
    }

    public void saveAssessmentResults(User user, Assessment assessment) {
    }

    public void setCourseAccess() {
    }

    public boolean connectToDatabase() {
        isDataBaseConnected = true;
<<<<<<< HEAD
=======
        System.out.println("Database connected.");
>>>>>>> 1c657970e10471a114d77874975a43e6f10577be
        return isDataBaseConnected;
    }

    public boolean disconnectFromDatabase() {
        isDataBaseConnected = false;
<<<<<<< HEAD
=======
        System.out.println("Database disconnected");
>>>>>>> 1c657970e10471a114d77874975a43e6f10577be
        return !isDataBaseConnected;
    }

    private JSONObject serializeUser(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put("id", user.getId().toString());
        userJSON.put("username", user.getUsername());
        userJSON.put("email", user.getEmail());
        userJSON.put("password", user.getPassword());

        JSONArray coursesJSON = new JSONArray();
        for (Course course : user.getCourses()) {
            coursesJSON.add(serializeCourse(course));
        }
        userJSON.put("courses", coursesJSON);

        JSONArray completedCoursesJSON = new JSONArray();
        for (Course completedCourse : user.getCompletedCourses()) {
            completedCoursesJSON.add(serializeCourse(completedCourse));
        }
        userJSON.put("completedCourses", completedCoursesJSON);

        return userJSON;
    }

    private JSONObject serializeCourse(Course course) {
        JSONObject courseJSON = new JSONObject();
        courseJSON.put("name", course.getName());
        courseJSON.put("description", course.getDescription());
        courseJSON.put("userAccess", course.isUserAccess());
        courseJSON.put("courseProgress", course.getCourseProgress());

        return courseJSON;
    }

    private JSONObject serializeLanguage(Language language) {
        JSONObject languageJSON = new JSONObject();
        languageJSON.put("name", language.getName());
        languageJSON.put("coursePercentage", language.getCoursePercentage());
        languageJSON.put("totalPercentage", language.getTotalPercentage());

        return languageJSON;
    }

    private boolean writeToFile(String filePath, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}