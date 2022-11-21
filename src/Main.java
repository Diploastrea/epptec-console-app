import java.util.Scanner;

public class Main {
    private static final String filePath = "db.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IOUtils ioUtils = new IOUtils();
        Database database = new Database(scanner, ioUtils, filePath);
        App app = new App(scanner, database);
        app.start();
    }
}
