import java.util.ArrayList;
import java.util.UUID;

public class Course {

    private String name;
    private String description;
    private boolean userAccess;
    private double courseProgress;
    private ArrayList<Lesson> lessons;
    private ArrayList<Assessment> assessments;
    private ArrayList<String> keyWords;
    private UUID id;
    private boolean completed;  // This tracks whether the course is completed

    // Default constructor
    public Course(User user) {
        this.name = "Default Course Name";
        this.description = "Default Description";
        this.userAccess = false;
        this.courseProgress = 0.0;
        this.lessons = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.keyWords = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.completed = false;  // Initialize completed as false
    }

    public Course(UUID id, String name, String description, boolean userAccess, double progress, boolean completed, ArrayList<Lesson> lessons, ArrayList<Assessment> assessments){
        this.id = id;
        this.name = name;
        this.description = description;
        this.userAccess = userAccess;
        this.courseProgress = progress;
        this.completed = completed;  // Set the completed status
        this.lessons = lessons;  // Set the lessons list
        this.assessments = assessments;
    }

    public Course(UUID id, double courseProgress){
        this.id = id;
        this.courseProgress = courseProgress;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUserAccess(){
        return this.userAccess;
    }

    public String getDescription() {
        return description;
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

    public boolean isCompleted(){
        return completed;  // Check if the course is completed
    }

    public void setCompleted(boolean completed){
        this.completed = completed;  // Set course as completed or not
    }

    public ArrayList<Lesson> getAllLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public ArrayList<Assessment> getAllAssessments() {
        return assessments;
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void addKeyWord(String keyWord) {
        keyWords.add(keyWord);
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Method to check if the course is fully completed based on progress
    public boolean completedCourse() {
        return courseProgress == 100.0;
    }

    // Mark course as completed
    public void setCompletedCourse() {
        this.courseProgress = 100.0;
        this.completed = true;  // Mark the course as completed
    }
}