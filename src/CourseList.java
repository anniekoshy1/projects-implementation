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
        save(); 
        return course;
    }

    public boolean removeCourse(Course course) {
        boolean removed = courses.remove(course);
        if (removed) {
            save(); 
        }
        return removed;
    }

    public ArrayList<Course> getCourse(String courseName) {
        ArrayList<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    public Course findByName(String name) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }

    public void save() {
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveCourses(courses);
    }

    public void load() {
        DataLoader dataLoader = new DataLoader();
        courses = dataLoader.getCourses();
    }
}