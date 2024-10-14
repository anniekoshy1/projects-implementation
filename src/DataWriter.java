import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    private boolean isDataBaseConnected;
    private int maxUsers = 100000;
    private int maxCourses = 500;

    private static final String USER_DATA_FILE = "users.json";
    private static final String COURSE_DATA_FILE = "courses.json";
    private static final String LANGUAGE_DATA_FILE = "languages.json";

    public DataWriter() {
    }

    public boolean saveUsers(ArrayList<User> users) {
        JSONArray usersJSON = new JSONArray();

        for (User user : users) {
            usersJSON.add(serializeUser(user));
        }

        return writeToFile(USER_DATA_FILE, usersJSON);
    }

    public boolean saveCourses(ArrayList<Course> courses) {
        JSONArray coursesJSON = new JSONArray();

        for (Course course : courses) {
            coursesJSON.add(serializeCourse(course));
        }

        return writeToFile(COURSE_DATA_FILE, coursesJSON);
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
        return isDataBaseConnected;
    }

    public boolean disconnectFromDatabase() {
        isDataBaseConnected = false;
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