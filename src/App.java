import java.util.List;
import java.util.Scanner;

public class App {
    private static final String filePath = "db.txt";
    private final Scanner scanner;
    private List<Person> people;

    public App(Scanner scanner, Database database) {
        this.scanner = scanner;
        this.people = database.read(filePath);
    }

    public void start() {
        printMenu();
        boolean exitApp = false;
        while (!exitApp) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> addPerson();
                case "2" -> System.out.println(people);
                case "3" -> System.out.println("find");
                default -> {
                    System.out.println("Invalid input, please try again.");
                    printMenu();
                }
            }
            System.out.println("Press 'C' to continue or press 'X' to exit");
            userInput = scanner.nextLine();
            if ("c".equals(userInput)) {
                printMenu();
            } else {
                exitApp = true;
            }
        }
        System.out.println("Program finished");
    }

    private void addPerson() {
        String firstName, lastName, id;
        System.out.println("Adding new person");
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();
        System.out.print("Enter ID number: ");
        id = scanner.nextLine();
        Person person = new Person(firstName, lastName, id);
        people.add(person);
    }

    private void read() {
    }

    private void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add new person");
        System.out.println("2 - Remove person");
        System.out.println("3 - Find person by ID number");
        System.out.println("----------------------------");
    }
}
