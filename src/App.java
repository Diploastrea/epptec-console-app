import java.util.Scanner;

public class App {
    private Scanner scanner;

    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        printMenu();
        String userInput = "";
        while (!"x".equals(userInput)) {
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> System.out.println("add");
                case "2" -> System.out.println("remove");
                case "3" -> System.out.println("find");
            }
            System.out.println("continue or exit?");
        }
    }

    private void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add new person");
        System.out.println("2 - Remove person");
        System.out.println("3 - Find person by ID number");
    }
}
