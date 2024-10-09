import java.util.ArrayList;
import java.util.UUID;

public class UserList {

    private static UserList instance;
    private ArrayList<User> users;

    private UserList() {
        users = new ArrayList<>();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    //adding to check for duplicate username or emails 
    private boolean userExists(String username, String email) {
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password much be at least 8 characters long.");
            return false;
        } 
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password much contain at least one number.");
            return false;
        }
        if (!password.matches(".*[!@#$%^&*].")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }
        return true;
        }

    public User addUser(String username, String password, String email) {

        if(userExists(username, email)) {
            System.out.println("User with this username or email already exists.");
            return null;
        }

        if(!validatePassword(password)){
            System.out.println("Password does not meet the requirements.");
            return null;
        }

        UUID newId = UUID.randomUUID();
        User newUser = new User(newId, username, email, password);
        users.add(newUser);
        return newUser;
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public boolean containsUser(User user) {
        return users.contains(user);
    }

    public void save() {
    }
}
