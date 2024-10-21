import java.util.ArrayList;

public class LanguageLearningFacade {

    private UserList userList;
    private CourseList courseList;
    private LanguageList languageList;
    private User user;
    private Language language;

    public LanguageLearningFacade() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        languageList = LanguageList.getInstance();
    }

    public User login(String username, String password) {
        User user = userList.getUser(username, password);
        if (user != null) {
            this.user = user;
        }
        return user;
    }

    public User register(String username, String email, String password) {
        if (User.validEmail(email)) {
            User newUser = userList.addUser(username, email, password);
            if (newUser != null) {
                this.user = newUser;
                return newUser;
            }
        }
        return null;
    }

    public User getUser(String username, String password) {
        return userList.getUser(username, password);
    }

    public void setUser(String username, String password) {
        this.user = userList.getUser(username, password);
    }

    public ArrayList<Language> getAllLanguagesByKeyWord(String keyWord) {
        ArrayList<Language> matchingLanguages = new ArrayList<>();
    
    ArrayList<Language> allLanguages = languageList.getLanguages();
    
    for (Language lang : allLanguages) {
        for (String word : lang.getKeyWords()) {
            if (word.equalsIgnoreCase(keyWord)) {
                matchingLanguages.add(lang);
                break;  
            }
        }
    }
    return matchingLanguages;
}

    public boolean confirmRegistration() {
        }
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
        user.setCurrentCourse(course);
        course.setUserAccess(true);
    }
}

    public void startAssessment() {
        user.completedAssessment(assessment);
    }

    public void endAssessment() {
        // Logic to end an assessment
    }

    public void startStarterTest(StarterTest test) {
        // Logic to start the starter test
    }

    public void startLesson(Lesson lesson) {
        user.getCurrentCourse().addLesson(lesson);
    }

    public double getCourseProgress(Language language) {
        return user.getProgress(user.getCurrentCourse());
    }

    public void logout() {
        user = null;
        language = null;
    }
}
