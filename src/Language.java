import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Language {

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

    public Language() {
        this.keyWords = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.completedAssessments = new ArrayList<>();
        this.courseAccess = new HashMap<>();
    }

    public Language(User user, String name) {  
        this();
        this.user = user;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {  
        this.name = name;
    }

    public void setCourseAccess(Course course, boolean access) {
        if (course != null) {
            courseAccess.put(course, access);
        } else {
            System.out.println("Cannot set access for a null course.");
        }
    }

    public double getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(double totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    public double getCoursePercentage() {
        return coursePercentage;
    }

    public void setCoursePercentage(double coursePercentage) {
        this.coursePercentage = coursePercentage;
    }

    public double getLanguageProgress() {
        return languageProgress;
    }

    public void setLanguageProgress(double progress) {
        this.languageProgress = progress;
    }

    public void addCompletedCourse(Course course) {
        if (course != null && !completedCourses.contains(course)) {
            completedCourses.add(course);
        } else if (course == null) {
            System.out.println("Cannot add a null course to completed courses.");
        }
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
        if (keyWord != null && !keyWord.trim().isEmpty()) {
            keyWords.add(keyWord);
        } else {
            System.out.println("Invalid keyword.");
        }
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }
}