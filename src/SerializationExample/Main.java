package SerializationExample;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] territoryInfo = {"У Испании 6 провинции", "У России 10 провинции", "У Франции 8 провинции"};
        String[] resourcesInfo = {"У Испании 100 золото", "У России 80 золото", "У Франции 90 золото"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Codes\\JavaProjects\\FileExample\\Games\\test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(savedGame);

        FileInputStream fileInputStream = new FileInputStream("D:\\Codes\\JavaProjects\\FileExample\\Games\\test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SavedGame savedGame1 = (SavedGame) objectInputStream.readObject();
        System.out.println(savedGame1);

        objectOutputStream.close();
    }
}
