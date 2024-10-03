import java.util.ArrayList;
import java.util.UUID;

public class Course {

    // Attributes
    private String name;
    private String description;
    private boolean userAccess;
    private double courseProgress;
    private ArrayList<Lesson> lessons;
    private ArrayList<Assessment> assessments;
    private ArrayList<String> keyWords;
    private UUID id;

    // Constructor
    public Course(User user) {
        // Initialize attributes here
        this.lessons = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.keyWords = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCourseProgress() {
        return courseProgress;
    }

    public void setCourseProgress(double progress) {
        this.courseProgress = progress;
    }

    public boolean getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(boolean access) {
        this.userAccess = access;
    }

    public ArrayList<Lesson> getAllLessons() {
        return lessons;
    }

    public ArrayList<Assessment> getAllAssessments() {
        return assessments;
    }

    public ArrayList<String> getCompletedAssessments() {
        // No code for now
        return new ArrayList<>();
    }

    public void setCompletedAssessments() {
        // No code for now
    }

    public void setCompletedCourse() {
        // No code for now
    }

    public void addKeyWord(String keyWord) {
        keyWords.add(keyWord);
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void setUUID(UUID id) {
        this.id = id;
    }
}
