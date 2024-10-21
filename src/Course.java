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

    public Course(User user) {
        this.name = "Default Course Name";
        this.description = "Default Description";
        this.userAccess = false;
        this.courseProgress = 0.0; 
        this.lessons = new ArrayList<>();
        this.assessments = new ArrayList<>();
        this.keyWords = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public Course(UUID id, String name, String description, boolean userAccess, double progress, boolean completed, ArrayList<Lesson> lessons, ArrayList<Assessment> assessments){
        this.id = id;
        this.name = name;
        this.description = description;
        this.userAccess = userAccess;
        this.courseProgress = progress;
        this.completed = lessons;
        this.assessments = assessments;
    }

    public Course(UUID id, double courseProgress){
        this.id = id;
        this.courseProgress = courseProgress;
    }

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

    private boolean completed;

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setUserAccess(boolean access) {
        this.userAccess = access;
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

    public boolean completedCourse() {
        return courseProgress == 100.0;
    }

    public void setCompletedCourse() {
        this.courseProgress = 100.0;
    }
}