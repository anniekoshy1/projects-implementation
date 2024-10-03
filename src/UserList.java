import java.util.ArrayList;

public class UserList {

    // Attributes
    private static UserList instance;
    private ArrayList<User> users;

    // Constructor
    private UserList() {
        users = new ArrayList<>();
    }

    // Method to get the singleton instance
    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    // Methods
    public User getUser(String username, String password) {
        // No code for now
        return null;
    }

    public User addUser(String username, String password) {
        // No code for now
        return null;
    }

    public boolean removeUser(User user) {
        // No code for now
        return false;
    }

    public ArrayList<User> getAllUsers() {
        // No code for now
        return new ArrayList<>();
    }

    public boolean containsUser(User user) {
        // No code for now
        return false;
    }

    public void save() {
        // No code for now
    }
}
