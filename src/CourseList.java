import java.util.ArrayList;

public class CourseList {

    // Attributes
    private static CourseList instance;
    private ArrayList<Course> courses;

    // Constructor
    private CourseList() {
        courses = new ArrayList<>();
    }

    // Method to get the singleton instance
    public static CourseList getInstance() {
        if (instance == null) {
            instance = new CourseList();
        }
        return instance;
    }

    // Methods
    public Course addCourse(Course course) {
        // No code for now
        return null;
    }

    public boolean removeCourse(Course course) {
        // No code for now
        return false;
    }

    public ArrayList<Course> getCourse(String courseName) {
        // No code for now
        return new ArrayList<>();
    }

    public Course findByName(String name) {
        // No code for now
        return null;
    }

    public void save() {
        // No code for now
    }
}
