import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class LanguageLearningFacade {

    private UserList userList;  // List of all users
    private CourseList courseList;  // List of all available courses
    private LanguageList languageList;  // List of all languages in the system
    private User user;  // The currently logged-in user
    private Language currentLanguage;  // The language the user is currently learning
    DataLoader dataLoader = new DataLoader();

    public LanguageLearningFacade() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        languageList = LanguageList.getInstance();
    }

    // User login using username and password
    public boolean login(String username, String password) {
        User foundUser = userList.findUserByUsername(username);
        if (foundUser != null && foundUser.getPassword().equals(password)) {
            this.user = foundUser;

            dataLoader.loadUserProgress(this.user);    

            return true;
        }
        return false;
    }

    // User logout to reset the current session
    public void logout() {
        this.user = null;
        this.currentLanguage = null;
    }

    // Start a new course for the user
    public void startCourse(Course course) {
        if (user != null) {
            user.getCourses().add(course);
            course.setUserAccess(true);  // Grant access to the course
        }
    }

    // Track the progress of the current course
    public double trackCourseProgress(Course course) {
        if (user != null && course.getUserAccess()) {
            return course.getCourseProgress();
        }
        return 0.0;
    }

    // Start an assessment for the current course
    public void startAssessment(Assessment assessment) {
        if (user != null) {
            assessment.retakeAssessment();  
        }
    }

    // Get a list of all languages supported in the system
    public ArrayList<Language> getAllLanguages() {
        return languageList.getLanguages();
    }

    // Select a language for the user to learn
    public void selectLanguage(String languageName) {
        Language language = languageList.findLanguageByName(languageName);
        if (language != null) {
            this.currentLanguage = language;
        }
    }

    // Track the user's progress in the current language
    public double trackLanguageProgress() {
        if (currentLanguage != null) {
            return currentLanguage.getLanguageProgress();
        }
        return 0.0;
    }

    // Get all courses available in the system
    public ArrayList<Course> getAllCourses() {
        return courseList.getCourses();
    }

    // Track overall progress in all courses for a user
    public double trackOverallProgress() {
        if (user != null) {
            double totalProgress = 0.0;
            for (Course course : user.getCourses()) {
                totalProgress += course.getCourseProgress();
            }
            return totalProgress / user.getCourses().size();
        }
        return 0.0;
    }

    // Find all languages that match a specific keyword
    public ArrayList<Language> getAllLanguagesByKeyWord(String keyWord) {
        ArrayList<Language> matchingLanguages = new ArrayList<>();
        for (Language language : languageList.getLanguages()) {
            if (language.getKeyWords().contains(keyWord)) {
                matchingLanguages.add(language);
            }
        }
        return matchingLanguages;
    }

    // Get the current user who is logged in
    public User getCurrentUser() {
        return user;
    }

    // Save user progress and logout
    public void saveAndLogout() {
        if (user != null) {
            new DataWriter().saveUserProgress(user);
            logout();
        }
    }

    // Add a new user to the system
    public void registerUser(String username, String email, String password) {
        UUID userId = UUID.randomUUID();
        User newUser = new User(userId, username, email, password, new ArrayList<>(), new HashMap<>(), new ArrayList<>(), null, new ArrayList<>(), null, "English");
        userList.addUser(newUser);
    }

    public boolean hasCourseAccess(Course course) {
        if (user != null) {
            return course.getUserAccess();
        }
        return false;
    }

    public void loadAssessmentQuestions(UUID assessmentId) {
        String assessmentIDSTR = assessmentId.toString();
    }
}