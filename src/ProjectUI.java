import java.util.Scanner;

public class ProjectUI {
    private static final String WELCOME_MESSAGE = "Welcome to Language Fluent!";
    private String[] mainMenuOptions = {"Register", "Login", "Logout"};
    private Scanner scanner;
    private LanguageLearningFacade language;

    ProjectUI() {
        scanner = new Scanner(System.in);
        language = new LanguageLearningFacade();
    }
    
    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while (true) {
            displayMainMenu();
            
            int userCommand = getUserCommand(mainMenuOptions.length);

            if (userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

            if (userCommand == mainMenuOptions.length - 1) {
                language.logout();
                break;
            }

            switch (userCommand) {
                case 0:
                    register();
                    break;
                case 1:
                    login();
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1) return command;
        return -1;
    }

private void register() {
    String userName = getField("Username");
    String email = getField("Email");        // Added email field
    String password = getField("Password"); 

    User newUser = language.register(userName, email, password);  // Call register method with correct params

    if (newUser != null) {
        System.out.println("You have successfully created an account");
    } else {
        System.out.println("Sorry, an account with that username already exists or the email is invalid.");
    }
}

private void login() {
    String userName = getField("Username");
    String password = getField("Password");

    User user = language.login(userName, password); // Store the returned User object

    if (user != null) { // Check if the user is not null
        if (user.getCurrentLanguage() != null) {
        System.out.println("Welcome " + user.getUsername() + "Your selected language is " + user.getCurrentLanguage().getName() + "."); // Welcome message using the retrieved User object
    } else {
        System.out.println("Welcome" + user.getUsername() + "!"); 
    }
    } else {
        System.out.println("Sorry, invalid username or password.");
    }
}

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        ProjectUI projectUI = new ProjectUI();
        projectUI.run();
    }
}
