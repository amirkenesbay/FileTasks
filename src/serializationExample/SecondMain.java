package serializationExample;

import java.io.*;

public class SecondMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TerritoriesInfo territoriesInfo = new TerritoriesInfo("У Испании 6 провинций, у России 10 провинций, у Франции 8 провинций");
        ResourcesInfo resourcesInfo = new ResourcesInfo("У Испании 100 золота, у России 80 золота, у Франции 90 золота");
        DiplomacyInfo diplomacyInfo = new DiplomacyInfo("Франция воюет с Россией, Испания заняла позицию нейтралитета");

        SavedGameObjects savedGameObjects = new SavedGameObjects(territoriesInfo, resourcesInfo, diplomacyInfo);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Codes\\JavaProjects\\FileExample\\Games\\test2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedGameObjects);

        objectOutputStream.close();
    }
}
