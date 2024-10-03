import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
    // Attributes
    private String username;
    private String email;
    private String password;
    private ArrayList<Course> courses;
    private HashMap<Course, Double> progress;
    private ArrayList<Course> completedCourses;
    private Course currentCourse;
    private ArrayList<Language> languages;
    private Language currentLanguage;
    private UUID id;

    // Constructor
    public User(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.courses = new ArrayList<>();
        this.progress = new HashMap<>();
        this.completedCourses = new ArrayList<>();
        this.languages = new ArrayList<>();
    }

    // Methods
    public boolean register(UUID id, String username, String email, String password) {
        return true;
    }

    public boolean login(UUID id, String username, String password) {
        return true;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public String setCourse(Course course) {
        this.currentCourse = course;
        return "Course set successfully.";
    }

    public ArrayList<Course> getCompletedCourses() {
        return this.completedCourses;
    }

    public void setCourseAccess() {
        // Logic to set course access
    }

    public ArrayList<Language> getLanguages() {
        return this.languages;
    }

    public double getProgress(double coursePercentage) {
        return coursePercentage;
    }

    public void updateProgress(double totalPercentage) {
        // Logic to update course progress
    }

    public void completedAssessment(Assessment assessment) {
        // Logic to handle completed assessments
    }

    public void setCurrentCourse(Course course) {
        this.currentCourse = course;
    }

    public void setCurrentLanguage(Language language) {
        this.currentLanguage = language;
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID() {
        this.id = generateUUID();
    }
}
