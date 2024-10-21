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
    
    public void run () {
        System.out.println(WELCOME_MESSAGE);

        while(true){
            displayMainMenu();
            
            int userCommand = getUserCommand(mainMenuOptions.length);

            if(userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }

        if(userCommand == mainMenuOptions.length - 1) {
            language.logout();
            break;
        }

        switch(userCommand) {
				case(0):
					register();
					break;
				case(1):
					login();
					break;
			}
		}

        System.out.println("Goodbye!");

    }

    private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
}