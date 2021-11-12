package SerializationExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SecondMainReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Codes\\JavaProjects\\FileExample\\Games\\test2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGameObjects savedGameObjects = (SavedGameObjects) objectInputStream.readObject();

        System.out.println(savedGameObjects);
        objectInputStream.close();
    }
}
