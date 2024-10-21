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

    private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}
	
	private void register() {
		String userName = getField("Username");
		String firstName = getField("First Name");
		String lastName = getField("Last Name");
		int age = Integer.parseInt(getField("Age"));
		String phoneNumber = getField("Phone Number");
		
		if(library.createAccount(userName, firstName, lastName, age, phoneNumber)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}
	
	private void login() {
		String userName = getField("Username");
		
		if(library.login(userName)) {
			User currentUser = library.getCurrentUser();
			System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
		} else {
			System.out.println("Sorry, invalid username ");
		}
	}

	
	public static void main(String[] args) {
		LibraryUI libraryInterface = new LibraryUI();
		libraryInterface.run();

	}

}