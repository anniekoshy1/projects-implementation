import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private ArrayList<Course> courses;
    private Map<UUID, Double> progress;
    private ArrayList<UUID> completedCourses;
    private UUID currentCourseID;
    private ArrayList<Language> languages;
    private UUID currentLanguageID;
    private String currentLanguageName;

    // Constructor (adjusted for DataLoader)
    public User(UUID id, String username, String email, String password, ArrayList<Course> courses, 
                Map<UUID, Double> progress, ArrayList<UUID> completedCourses, UUID currentCourseID, 
                ArrayList<Language> languages, UUID currentLanguageID, String currentLanguageName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.progress = progress;
        this.completedCourses = completedCourses;
        this.currentCourseID = currentCourseID;
        this.languages = languages;
        this.currentLanguageID = currentLanguageID;
        this.currentLanguageName = currentLanguageName;
    }

    // Check if email is valid
    public static boolean validEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Getter for progress
    public Map<UUID, Double> getProgress() {
        return new HashMap<>(this.progress);
    }

    // Setter for progress
    public void setProgress(Map<UUID, Double> progress) {
        this.progress = progress;
    }

    public Course getCurrentCourse() {
        // In this case, you'd need to fetch the course using the UUID
        return this.courses.stream()
                .filter(course -> course.getId().equals(this.currentCourseID))
                .findFirst()
                .orElse(null);
    }

    public Language getCurrentLanguage() {
        // Fetch the current language based on ID
        return this.languages.stream()
                .filter(language -> language.getId().equals(this.currentLanguageID))
                .findFirst()
                .orElse(null);
    }

    // Register method
    public boolean register(UUID id, String username, String email, String password) {
        if (username == null || email == null || password == null || !validEmail(email)) {
            return false;
        }
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        return true;
    }

    // Login method
    public boolean login(UUID id, String username, String password) {
        return this.id.equals(id) && this.username.equals(username) && this.password.equals(password);
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public String setCourse(Course course) {
        this.currentCourseID = course.getId();
        return "Course set successfully.";
    }

    public ArrayList<UUID> getCompletedCourses() {
        return this.completedCourses;
    }

    public void setCourseAccess() {
        if (this.currentCourseID != null && !this.courses.contains(currentCourseID)) {
            this.courses.add(getCurrentCourse());
        }
    }

    public ArrayList<Language> getLanguages() {
        return this.languages;
    }

    public double getProgress(Course course) {
        return this.progress.getOrDefault(course.getId(), 0.0);
    }

    public void updateProgress(double totalPercentage) {
        if (currentCourseID != null) {
            this.progress.put(currentCourseID, totalPercentage);
        }
    }

    public void completedAssessment(Assessment assessment) {
        if (currentCourseID != null && this.progress.containsKey(currentCourseID)) {
            double currentProgress = this.progress.get(currentCourseID);
            if (currentProgress == 100.0) {
                this.completedCourses.add(currentCourseID);
                this.courses.remove(getCurrentCourse());
                System.out.println("Course completed: " + getCurrentCourse().getName());
            }
        }
    }

    public void setCurrentCourse(Course course) {
        this.currentCourseID = course.getId();
    }

    public void setCurrentLanguage(Language language) {
        this.currentLanguageID = language.getId();
        this.currentLanguageName = language.getName();
    }

    public UUID getId() {
        return id;
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
}