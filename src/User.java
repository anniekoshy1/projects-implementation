import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
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

    public static boolean validEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public HashMap<Course, Double> getProgress() {
        return new HashMap<>(this.progress);
    }

    public Course getCurrentCourse() {
        return this.currentCourse;
    }

    public Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    // Methods
    // Register a user 
    public boolean register(UUID id, String username, String email, String password) {
        if (username == null || email == null || password == null || !validEmail(email)) {
            return false; 
            // Registration failed due to missing information
        }
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        return true;
    }

    // user login
    public boolean login(UUID id, String username, String password) {
        return this.id.equals(id) && this.username.equals(username) && this.password.equals(password);
    }

    // Get course list
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    // Set the current course for the user
    public String setCourse(Course course) {
        this.currentCourse = course;
        return "Course set successfully.";
    }

    // Get completed courses
    public ArrayList<Course> getCompletedCourses() {
        return this.completedCourses;
    }

    // Set access to a course
    public void setCourseAccess() {
        if (!courses.contains(currentCourse)) {
            courses.add(currentCourse); 
            // Adds the current course to the user's courses
        }
    }

    // Get the list of languages the user is learning
    public ArrayList<Language> getLanguages() {
        return this.languages;
    }

    // Get progress for a course (returns percentage completed)
    public double getProgress(Course course) {
        if (progress.containsKey(course)) {
            return progress.get(course);
        }
        return 0.0; 
        // No progress if course not found
    }

    // Update the progress of the current course
    public void updateProgress(double totalPercentage) {
        if (currentCourse != null) {
            progress.put(currentCourse, totalPercentage);
        }
    }

    // Mark an assessment as completed
    public void completedAssessment(Assessment assessment) {
        if (currentCourse != null && progress.containsKey(currentCourse)) {
            double currentProgress = progress.get(currentCourse);
            if (currentProgress == 100.0) {
                completedCourses.add(currentCourse);
                courses.remove(currentCourse);
                System.out.println("Course completed: " + currentCourse.getName());
            }
        }
    }

    // Set the current course
    public void setCurrentCourse(Course course) {
        this.currentCourse = course;
    }

    // Set the current language the user is learning
    public void setCurrentLanguage(Language language) {
        this.currentLanguage = language;
    }

    // Generate a new UUID for the user
    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    // Set a new UUID for the user
    public void setUUID() {
        this.id = generateUUID();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getId() {
        return id;
    }
}