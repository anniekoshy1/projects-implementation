import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Language {

    // Attributes
    private User user;
    private StarterTest starterTest;
    private String name;
    private double coursePercentage;
    private double totalPercentage;
    private double languageProgress;
    private ArrayList<String> keyWords;
    private ArrayList<Course> completedCourses;
    private ArrayList<Assessment> completedAssessments;
    private HashMap<Course, Boolean> courseAccess;

    // Constructors
    public Language() {
        this.keyWords = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.completedAssessments = new ArrayList<>();
        this.courseAccess = new HashMap<>();
    }

    public Language(User user) {
        this();
        this.user = user;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setCourseAccess(Course course, boolean access) {
        courseAccess.put(course, access);
    }

    public double getTotalPercentage() {
        return totalPercentage;
    }

    public double getCoursePercentage() {
        return coursePercentage;
    }

    public double getLanguageProgress() {
        return languageProgress;
    }

    public void setLanguageProgress(double progress) {
        this.languageProgress = progress;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public boolean takenStarterTest() {
        return starterTest != null;
    }

    public void addKeyWord(String keyWord) {
        keyWords.add(keyWord);
    }
}
