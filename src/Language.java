import java.util.ArrayList;
import java.util.UUID;

public class Language {

    // Attributes
    private UUID id;
    private String name;
    private double coursePercentage;
    private double totalPercentage;
    private ArrayList<Course> completedCourses;

    // Constructor
    public Language(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.completedCourses = new ArrayList<>();
    }

    // Getter for ID
    public UUID getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter and Setter for course percentage
    public double getCoursePercentage() {
        return coursePercentage;
    }

    public void setCoursePercentage(double coursePercentage) {
        this.coursePercentage = coursePercentage;
    }

    // Getter and Setter for total percentage
    public double getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(double totalPercentage) {
        this.totalPercentage = totalPercentage;
    }

    // Getter and Setter for completed courses
    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }
}