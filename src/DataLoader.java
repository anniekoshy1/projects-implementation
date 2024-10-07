import java.util.ArrayList;

public class DataLoader {

    private ArrayList<User> users = new ArrayList<>();

    public DataLoader() {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
        users.add(new User("user5", "password5"));
        users.add(new User("user6", "password6"));
        users.add(new User("user7", "password7"));
        users.add(new User("user8", "password8"));
        users.add(new User("user9", "password9"));
    }

    public ArrayList<User> getUserList() {
        return users;
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        ArrayList<User> userList = dataLoader.getUserList();

        for (int i = 0; i < Math.min(userList.size(), 8); i++) {
            User user = userList.get(i);
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        }

        User user2 = userList.get(1); 
        System.out.println("\n--- Displaying User2 ---");
        System.out.println("Username: " + user2.getUsername() + ", Password: " + user2.getPassword());

        System.out.println("Program terminated.");
    }

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