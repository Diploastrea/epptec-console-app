import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final Database database;

    public App(Scanner scanner, Database database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() {
        printMenu();
        boolean exitApp = false;
        while (!exitApp) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> database.addPerson();
                case "2" -> database.removePerson();
                case "3" -> database.printDetails();
                case "4" -> database.list();
                default -> {
                    System.out.println("Invalid option, please try again.");
                    printMenu();
                    continue;
                }
            }
            System.out.println("Press 'C' to continue or press 'X' to exit.");
            userInput = scanner.nextLine();
            if ("c".equals(userInput)) {
                printMenu();
            } else {
                exitApp = true;
                database.save();
            }
        }
        System.out.println("Program finished!");
    }

    private void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1 - Add new person");
        System.out.println("2 - Remove person");
        System.out.println("3 - Find person by ID number");
        System.out.println("----------------------------");
    }
}
