import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataLoader {
    private static final String USERS_FILE = "docs/JSON/User.json";
    private static final String COURSES_FILE = "docs/JSON/Courses.json";
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

    //done
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

                JSONArray coursesJson = (JSONArray) userJson.get("courses");
            ArrayList<Course> courses = new ArrayList<>();
            for (Object courseObj : coursesJson) {
                JSONObject courseJson = (JSONObject) courseObj;
                UUID courseID = UUID.fromString((String) courseJson.get("courseID"));
                double courseProgress = (Double) courseJson.get("courseProgress");
                courses.add(new Course(courseID, courseProgress));
            }

            // Handle progress, completed courses, and current course
            JSONObject progressJson = (JSONObject) userJson.get("progress");
            // Convert progress to a Map or handle as needed
            Map<UUID, Double> progress = new HashMap<>();
            for (Object key : progressJson.keySet()) {
                UUID courseId = UUID.fromString((String) key);
                double courseProgress = (Double) progressJson.get(key);
                progress.put(courseId, courseProgress);
            }

            JSONArray completedCoursesJson = (JSONArray) userJson.get("completedCourses");
            ArrayList<UUID> completedCourses = new ArrayList<>();
            for (Object completedCourseId : completedCoursesJson) {
                completedCourses.add(UUID.fromString((String) completedCourseId));
            }

            // Extract current course
            JSONObject currentCourseJson = (JSONObject) userJson.get("currentCourse");
            UUID currentCourseID = UUID.fromString((String) currentCourseJson.get("courseID"));

            // Extract languages
            JSONArray languagesJson = (JSONArray) userJson.get("languages");
            ArrayList<Language> languages = new ArrayList<>();
            for (Object languageObj : languagesJson) {
                JSONObject languageJson = (JSONObject) languageObj;
                UUID languageID = UUID.fromString((String) languageJson.get("languageID"));
                String languageName = (String) languageJson.get("name");
                languages.add(new Language(languageID, languageName));
            }

            // Extract current language
            JSONObject currentLanguageJson = (JSONObject) userJson.get("currentLanguage");
            UUID currentLanguageID = UUID.fromString((String) currentLanguageJson.get("languageID"));
            String currentLanguageName = (String) currentLanguageJson.get("name");

            // Create a new User object and add it to the list.
            User user = new User(id, username, email, password, courses, progress, completedCourses, currentCourseID, languages, currentLanguageID, currentLanguageName);
            users.add(user);
        }
            System.out.println("Users loaded successfully.");
        } catch (IOException | ParseException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    //should be done
    public boolean confirmUser(String username, String password) {
        ArrayList<User> users = getUsers();
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //done
    public ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(COURSES_FILE)) {
            Object obj = jsonParser.parse(fileReader);
            JSONArray courseArray = (JSONArray) obj;

            // Iterate through each object in the JSONArray.
            for (Object courseObject : courseArray) {
                // Cast each object into a JSONObject.
                JSONObject courseJson = (JSONObject) courseObject;

                // Extract course attributes from the JSONObject.
                UUID courseID = UUID.fromString((String) courseJson.get("courseID"));
                String name = (String) courseJson.get("name");
                String description = (String) courseJson.get("description");
                boolean userAccess = (boolean) courseJson.get("userAccess");
                double courseProgress = ((Number) courseJson.get("courseProgress")).doubleValue();
                boolean completed = (boolean) courseJson.get("completed");

                // Parse lessons
                JSONArray lessonsJson = (JSONArray) courseJson.get("lessons");
                ArrayList<Lesson> lessons = new ArrayList<>();
                for (Object lessonObject : lessonsJson) {
                    JSONObject lessonJson = (JSONObject) lessonObject;
                    UUID lessonID = UUID.fromString((String) lessonJson.get("lessonID"));
                    double lessonProgress = ((Number) lessonJson.get("lessonProgress")).doubleValue();
                    String lessonDescription = (String) lessonJson.get("description");

                    // Create the Lesson object
                    Lesson lesson = new Lesson(lessonID, lessonProgress, lessonDescription);
                    lessons.add(lesson);
                }

                // Parse assessments
                JSONArray assessmentsJson = (JSONArray) courseJson.get("assessments");
                ArrayList<Assessment> assessments = new ArrayList<>();
                for (Object assessmentObject : assessmentsJson) {
                    JSONObject assessmentJson = (JSONObject) assessmentObject;
                    UUID assessmentID = UUID.fromString((String) assessmentJson.get("assessmentID"));
                    String type = (String) assessmentJson.get("type");
                    String userScore = (String) assessmentJson.get("userScore");
                    int attempts = ((Number) assessmentJson.get("attempts")).intValue();

                    // Create the Assessment object
                    Assessment assessment = new Assessment(assessmentID, type, userScore, attempts);
                    assessments.add(assessment);
                }

                // Create the Course object
                Course course = new Course(courseID, name, description, userAccess, courseProgress, completed, lessons, assessments);
                courses.add(course);
            }

            System.out.println("Courses loaded successfully.");
        } catch (IOException | ParseException e) {
            System.err.println("Error loading courses: " + e.getMessage());
        }

        return courses;
    }

    //done
    public ArrayList<Language> getLanguages() {
        return new ArrayList<>();
    }

    //done
    public void loadUserProgress(User user) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(USERS_FILE)) {
            // Parse the JSON file
            Object obj = jsonParser.parse(fileReader);
            JSONArray usersArray = (JSONArray) obj;

            // Iterate through the JSON array to find the user
            for (Object userObject : usersArray) {
                JSONObject userJson = (JSONObject) userObject;
                String username = (String) userJson.get("username");

                // If the username matches, load the progress
                if (username.equals(user.getUsername())) {
                    JSONObject progressJson = (JSONObject) userJson.get("progress");
                    Map<UUID, Double> progressMap = new HashMap<>();

                    for (Object key : progressJson.keySet()) {
                        UUID courseId = UUID.fromString((String) key);
                        double progress = ((Number) progressJson.get(key)).doubleValue();
                        progressMap.put(courseId, progress);
                    }

                    user.setProgress(progressMap);
                    System.out.println("User progress loaded successfully.");
                    return;
                }
            }

        } catch (IOException | ParseException e) {
            System.err.println("Error loading user progress: " + e.getMessage());
        }
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