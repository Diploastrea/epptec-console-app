import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Database {
    private final Scanner scanner;
    private final IOUtils ioUtils;
    private final String filePath;
    private final List<Person> people;

    public Database(Scanner scanner, IOUtils ioUtils, String filePath) {
        this.scanner = scanner;
        this.ioUtils = ioUtils;
        this.filePath = filePath;
        this.people = ioUtils.readFromFile(filePath);
    }

    public void list() {
        System.out.println(people);
    }

    public void save() {
        ioUtils.writeToFile(people, filePath);
    }

    public void remove() {
        System.out.print("Enter ID of the person you want to remove ('YYMMDDXXXX' or 'YYMMDD/XXXX' format): ");
        String id = scanner.nextLine();
        String idNumber = parseIdNumber(id);
        Optional<Person> person = people.stream().filter(p -> idNumber.equals(p.getIdNumber())).findFirst();
        try {
            Person toRemove = person.orElseThrow(() -> new IllegalArgumentException("No person found with provided ID!"));
            people.remove(toRemove);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addPerson() {
        String firstName, lastName, id;
        System.out.println("Adding new person");
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();
        System.out.print("Enter ID number in 'YYMMDDXXXX' or 'YYMMDD/XXXX' format: ");
        id = scanner.nextLine();
        boolean inputIsValid = false;
        try {
            inputIsValid = validateInput(firstName, lastName, id);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        if (inputIsValid) {
            id = parseIdNumber(id);
            Person person = new Person(firstName, lastName, id);
            people.add(person);
            System.out.println("Added new person successfully.");
        }
    }

    private boolean validateInput(String firstName, String lastName, String id) throws IllegalArgumentException {
        if (firstName.isBlank()) throw new IllegalArgumentException("First name cannot be blank!");
        if (lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be blank!");
        if (!id.matches("[0-9]{10}") && !id.matches("[0-9]{6}/[0-9]{4}"))
            throw new IllegalArgumentException("ID number must be in 'YYMMDDXXXX' or 'YYMMDD/XXXX' format!");
        id = parseIdNumber(id);
        for (Person p: people) {
            if (id.equals(p.getIdNumber())) throw new IllegalArgumentException("ID number must be unique!");
        }
        return true;
    }

    private String parseIdNumber(String id) {
        //parse id if not already in YYMMDD/XXXX format
        if (id.matches("[0-9]{10}")) id = id.substring(0, 6) + "/" + id.substring(6);
        return id;
    }
}
