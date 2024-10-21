import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    private boolean isDataBaseConnected;
    private int maxUsers = 100000;
    private int maxCourses = 500;

    private static final String USERS_FILE = "users.json";
    private static final String COURSES_FILE = "courses.json";
    private static final String LANGUAGES_FILE = "languages.json";

    public DataWriter() {

    }

    //done
    public boolean saveUsers(ArrayList<User> users) {
        if (users.size() > maxUsers) {
            System.err.println("Cannot save users: maximum user limit reached.");
            return false;
        }

        JSONArray usersJSON = new JSONArray();

        for (User user : users) {
            usersJSON.add(serializeUser(user));
        }

        return writeToFile(USERS_FILE, usersJSON);
    }

    //done
    public boolean saveCourses(ArrayList<Course> courses) {
        if (courses.size() > maxCourses) {
            System.err.println("Cannot save courses: maximum course limit reached.");
            return false;
        }

        JSONArray coursesJSON = new JSONArray();

        for (Course course : courses) {
            coursesJSON.add(serializeCourse(course));
        }

        return writeToFile(COURSES_FILE, coursesJSON);
    }

    //done
    public boolean saveLanguages(ArrayList<Language> languages) {
        JSONArray languagesJSON = new JSONArray();

        for (Language language : languages) {
            languagesJSON.add(serializeLanguage(language));
        }

        return writeToFile(LANGUAGES_FILE, languagesJSON);
    }

    public void saveProgress(User user) {
    }

    public void saveAssessmentResults(User user, Assessment assessment) {

    }

    public void setCourseAccess() {
    }

    public boolean connectToDatabase() {
        isDataBaseConnected = true;
        System.out.println("Database connected.");
        return isDataBaseConnected;
    }
    //done
    public boolean disconnectFromDatabase() {
        isDataBaseConnected = false;
        System.out.println("Database disconnected.");
        return !isDataBaseConnected;
    }

    //done
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

    //done
    private JSONObject serializeCourse(Course course) {
        JSONObject courseJSON = new JSONObject();
        courseJSON.put("name", course.getName());
        courseJSON.put("description", course.getDescription());
        courseJSON.put("userAccess", course.isUserAccess());
        courseJSON.put("courseProgress", course.getCourseProgress());

        return courseJSON;
    }

    //done
    private JSONObject serializeLanguage(Language language) {
        JSONObject languageJSON = new JSONObject();
        languageJSON.put("name", language.getName());
        languageJSON.put("coursePercentage", language.getCoursePercentage());
        languageJSON.put("totalPercentage", language.getTotalPercentage());

        return languageJSON;
    }
    
    //done
    private boolean writeToFile(String filePath, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
            System.out.println("Data saved successfully to " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error writing data to " + filePath + ": " + e.getMessage());
            return false;
        }
    }
}