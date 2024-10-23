import java.util.ArrayList;

public class CourseList {

    private static CourseList instance;  
    private ArrayList<Course> courses; 

    
    private CourseList() {
        courses = new ArrayList<>();
    }

    public static CourseList getInstance() {
        if (instance == null) {
            instance = new CourseList();
        }
        return instance;
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course findByName(String name) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;  // Return null if the course is not found
    }

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getId().toString().equals(courseId)) {
                return course;
            }
        }
        return null;  // Return null if the course is not found
    }

    public void save() {
    }
}