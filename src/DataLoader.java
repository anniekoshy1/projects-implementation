import java.util.ArrayList;

public class DataLoader {

    public ArrayList<User> getUsers() {
        return new ArrayList<>();
    }

    public boolean confirmUser(String username, String password) {
        return false;
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>();
    }

    public ArrayList<Language> getLanguages() {
        return new ArrayList<>();
    }

    public void loadUserProgress(User user) {
    }

    public ArrayList<Assessment> loadAssessmentHistory(User user) {
        return new ArrayList<>();
    }

    public ArrayList<Phrase> loadPhrases() {
        return new ArrayList<>();
    }

    public ArrayList<Lesson> getLessons() {
        return new ArrayList<>();
    }

    public void saveUserProgress(User user) {
    }

    public void saveAssessmentHistory(User user, Assessment assessment) {
    }

    public void saveCourses(ArrayList<Course> courses) {
    }

    public void saveLanguages(ArrayList<Language> languages) {
    }
}
