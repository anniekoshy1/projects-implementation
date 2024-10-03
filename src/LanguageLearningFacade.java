import java.util.ArrayList;

public class LanguageLearningFacade {

    private UserList userList;
    private CourseList courseList;
    private LanguageList languageList;
    private User user;
    private Language language;

    // Constructor
    public LanguageLearningFacade() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        languageList = LanguageList.getInstance();
    }

    // Methods
    public User login(String username, String password) {
        return userList.getUser(username, password);
    }

    public User register(String username, String password) {
        return userList.addUser(username, password);
    }

    public User getUser(String username, String password) {
        return userList.getUser(username, password);
    }

    public void setUser(String username, String password) {
        this.user = userList.getUser(username, password);
    }

    public ArrayList<Language> getAllLanguagesByKeyWord(String keyWord) {
        // Implement search logic for languages by keyword
        return new ArrayList<>();
    }

    public boolean confirmRegistration() {
        // Implement registration confirmation logic
        return true;
    }

    public String setLanguage(Language language) {
        this.language = language;
        return "Language set successfully";
    }

    public ArrayList<Course> getAllCourses() {
        return courseList.getCourse(null);
    }

    public void startCourse() {
        // Logic to start a course
    }

    public void startAssessment() {
        // Logic to start an assessment
    }

    public void endAssessment() {
        // Logic to end an assessment
    }

    public void startStarterTest(StarterTest test) {
        // Logic to start the starter test
    }

    public void startLesson(Lesson lesson) {
        // Logic to start a lesson
    }

    public double getCourseProgress(Language language) {
        // Implement logic to get course progress for the language
        return 0.0;
    }

    public void logout() {
        // Implement logout logic
        user = null;
    }
}
