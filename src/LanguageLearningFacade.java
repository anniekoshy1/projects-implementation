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

    // Login user by username and password
    public User login(String username, String password) {
        User user = userList.getUser(username, password);
        if (user != null) {
            this.user = user;
            this.langauge = user.getCurrentLanguage;
        }
        return user;
    }

    // Register a new user with username, email, and password
    public User register(String username, String email, String password) {
        if (User.validEmail(email)) {
            User newUser = userList.addUser(username, email, password);
            if (newUser != null) {
                this.user = newUser;
                return newUser;
            }
        }
        return null; // Registration failed
    }

    // Get an existing user
    public User getUser(String username, String password) {
        return userList.getUser(username, password);
    }

        // Get the current user
    public User getCurrentUser() {
        return user; // Return the currently logged-in user
    }

    // Set the current user
    public void setUser(String username, String password) {
        this.user = userList.getUser(username, password);
    }

    // Search languages by a keyword
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

    // Confirm registration
    public boolean confirmRegistration(String username, String password, String email) {
        if (!User.validEmail(email)) {
            System.out.println("Invalid email.");
            return false;
        }

        User newUser = userList.addUser(username, email, password);
        if (newUser != null) {
            System.out.println("Registration successful.");
            this.user = newUser;
            return true;
        }

        System.out.println("Registration failed.");
        return false;
    }

    public String setLanguage(Language language) {
        this.language = language;
        user.setCurrentLanguage(language);  
        return "Language set successfully";
    }

    public ArrayList<Course> getAllCourses() {
        return courseList.getCourse(null);
    }

    public void startCourse(Course course) {
        if (user != null && course != null) {
            user.setCurrentCourse(course);
            course.setUserAccess(true); 
        } else {
            System.out.println("User or course is null.");
        }
    }

    public void startAssessment(Assessment assessment) {
        if (user != null && assessment != null) {
            user.completedAssessment(assessment);
        } else {
            System.out.println("User or assessment is null.");
        }
    }

    public void endAssessment() {
        System.out.println("Assessment ended.");
    }

    public void startStarterTest(StarterTest test) {
    
        System.out.println("Starter test started.");
    }

    public void startLesson(Lesson lesson) {
        if (user != null && user.getCurrentCourse() != null) {
            user.getCurrentCourse().addLesson(lesson);
        } else {
            System.out.println("User or current course is null.");
        }
    }
    
    public double getCourseProgress(Language language) {
        if (user != null && user.getCurrentCourse() != null) {
            return user.getProgress(user.getCurrentCourse());
        }
        return 0.0;
    }
    
    public void logout() {
        user = null;
        language = null;
        System.out.println("User logged out.");
    }
}