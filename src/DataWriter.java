import java.util.ArrayList;

public class DataWriter {

    // Attributes
    private boolean isDataBaseConnected;
    private int maxUsers = 100000;
    private int maxCourses = 500;

    // Constructor
    public DataWriter() {
        // No code for now
    }

    // Methods
    public boolean saveUsers(ArrayList<User> users) {
        // No code for now
        return false;
    }

    public boolean saveCourses(ArrayList<Course> courses) {
        // No code for now
        return false;
    }

    public boolean saveLanguages(ArrayList<Language> languages) {
        // No code for now
        return false;
    }

    public boolean saveLessons(ArrayList<Lesson> lessons) {
        // No code for now
        return false;
    }

    public void saveProgress(User user) {
        // No code for now
    }

    public void saveAssessmentResults(User user, Assessment assessment) {
        // No code for now
    }

    public void setCourseAccess() {
        // No code for now
    }

    public boolean connectToDatabase() {
        // No code for now
        return false;
    }

    public boolean disconnectFromDatabase() {
        // No code for now
        return false;
    }

    public boolean savePhrase(Phrase phrase) {
        // No code for now
        return false;
    }
}
