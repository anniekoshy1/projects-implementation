import java.util.ArrayList;
import java.util.UUID;

public class Course {

    private String name;  // Name of the course
    private String description;  // Description of the course
    private boolean userAccess;  // Access status of the course
    private double courseProgress;  // Progress of the course (0.0 to 100.0)
    private ArrayList<Lesson> lessons;  // List of lessons in the course
    private ArrayList<Assessment> assessments;  // List of assessments in the course
    private ArrayList<String> keyWords;  // Keywords related to the course
    private UUID id;  // Unique identifier for the course
    private boolean completed;  // Indicates whether the course is completed

    // Default constructor for creating a course for a user
    public Course(User user) {
        this.name = "Default Course Name";
        this.description = "Default Description";
        this.userAccess = false;
        this.courseProgress = 0.0;
        this.lessons = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.keyWords = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.completed = false;
    }

    // Full constructor to set up a course with all details
    public Course(UUID id, String name, String description, boolean userAccess, double courseProgress, boolean completed, ArrayList<Lesson> lessons, ArrayList<Assessment> assessments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userAccess = userAccess;
        this.courseProgress = courseProgress;
        this.completed = completed;
        this.lessons = lessons;
        this.assessments = assessments;
        this.keyWords = new ArrayList<>();
    }
    public Course(UUID id, double courseProgress) {
        this.id = id;
        this.courseProgress = courseProgress;
    }
    
    public double getCourseProgress() {
        return this.courseProgress;
    }

    // Get the name of the course
    public String getName() {
        return name;
    }

    // Set the name of the course
    public void setName(String name) {
        this.name = name;
    }

    // Get the description of the course
    public String getDescription() {
        return description;
    }

    // Set the description of the course
    public void setDescription(String description) {
        this.description = description;
    }

    // Get the progress of the course
    public void calculateProgress() {
        int totalItems = lessons.size() + assessments.size();
        int completedItems = 0;

        for (Lesson lesson : lessons) {
            if (lesson.isCompletedLesson()) {
                completedItems++;
            }
        }
        for (Assessment assessment : assessments) {
            if (assessment.calculateRating() >= 70) { // 70% = pass
                completedItems++;
            }
        }
        this.courseProgress = (double) completedItems / totalItems * 100;
    }

    public void setCourseProgress(double courseProgress) {
        if (courseProgress >= 0.0 && courseProgress <= 100.0) {
            this.courseProgress = courseProgress;
        }
    }

    public boolean getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(boolean userAccess) {
        this.userAccess = userAccess;
    }

    // Check if the course is completed
    public boolean isCompletedCourse() {
        return completed;
    }

    // Set the course as completed
    public void setCompleted(boolean completed) {
        this.completed = completed;
        if (completed) {
            this.courseProgress = 100.0;  // If the course is marked completed, set progress to 100%
        }
    }

    // Get all the lessons in the course
    public ArrayList<Lesson> getAllLessons() {
        return lessons;
    }

    // Add a lesson to the course
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    // Get all the assessments in the course
    public ArrayList<Assessment> getAllAssessments() {
        return assessments;
    }

    // Add an assessment to the course
    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    // Get the completed assessments in the course
    public ArrayList<String> getCompletedAssessments() {
        ArrayList<String> completed = new ArrayList<>();
        for (Assessment assessment : assessments) {
            if (assessment.getResults() >= 60) {  
                completed.add(assessment.toString());  
            }
        }
        return completed;
    }

    public void setCompletedAssessments(ArrayList<String> completedAssessments) {
    }

    public void addKeyWord(String keyWord) {
        keyWords.add(keyWord);
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
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

    // Mark the course as completed
    public void setCompletedCourse() {
        this.completed = true;
        this.courseProgress = 100.0;
    }

    // Check if the course is fully completed based on progress
    public boolean completedCourse() {
        return this.courseProgress == 100.0;
    }
}