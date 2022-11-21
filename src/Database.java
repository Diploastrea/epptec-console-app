import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public void save(List<Person> people, String filePath) {
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> read(String filePath) {
        Object people = null;
        File file = new File(filePath);
        try {
            boolean createdNewFile = file.createNewFile(); //creates new file only if it doesn't exist
            if (!createdNewFile) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                people = ois.readObject();
                ois.close();
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if (people == null) return new ArrayList<>();
        return people.getClass() == ArrayList.class ?
                (List<Person>) people : new ArrayList<>(List.of((Person) people));
    }
}
