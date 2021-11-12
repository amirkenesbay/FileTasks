package FileSaves;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String FIRST_DIR = "D:\\Codes\\JavaProjects\\FileExample\\Games\\savegames\\save1.dat";
    private static final String SECOND_DIR = "D:\\Codes\\JavaProjects\\FileExample\\Games\\savegames\\save2.dat";
    private static final String THIRD_DIR = "D:\\Codes\\JavaProjects\\FileExample\\Games\\savegames\\save3.dat";
    private static final String ZIP_DIR = "D:\\Codes\\JavaProjects\\FileExample\\Games\\savegames\\example.zip";

    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(20, 30, 15, 85.42);
        GameProgress gameProgress2 = new GameProgress(15, 61, 84, 22.36);
        GameProgress gameProgress3 = new GameProgress(33, 80, 11, 33.58);
        saveGame(FIRST_DIR, gameProgress1);
        saveGame(SECOND_DIR, gameProgress2);
        saveGame(THIRD_DIR, gameProgress3);
        readObjectFile(FIRST_DIR, gameProgress1);
        readObjectFile(SECOND_DIR, gameProgress2);
        readObjectFile(THIRD_DIR, gameProgress3);
        List<String> list = new ArrayList<>();
        list.add(FIRST_DIR);
        list.add(SECOND_DIR);
        list.add(THIRD_DIR);
        zipFiles(ZIP_DIR, list);
        File file1 = new File(FIRST_DIR);
        File file2 = new File(SECOND_DIR);
        File file3 = new File(THIRD_DIR);
        List<File> listFiles = new ArrayList<>();
        listFiles.add(file1);
        listFiles.add(file2);
        listFiles.add(file3);
        deleteFile(listFiles);
    }

    public static void saveGame(String src, GameProgress gameProgress) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(src)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameProgress);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String srcArchive, List<String> list) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(srcArchive))) {
            for (String value : list) {
                try (FileInputStream fileInputStream = new FileInputStream(value)) {
                    ZipEntry entry = new ZipEntry(value);
                    zipOutputStream.putNextEntry(entry);
                    while (fileInputStream.available() > 0) {
                        zipOutputStream.write(fileInputStream.read());
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(List<File> listFiles) {
        for (File fileVal : listFiles) {
            if (fileVal.delete()) {
                System.out.println(fileVal.getName() + " - file was deleted");
            }
        }
    }

    public static void readObjectFile(String src, GameProgress gameProgress) {
        try (FileInputStream fileInputStream = new FileInputStream(src)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            GameProgress gameProgress1 = (GameProgress) objectInputStream.readObject();
            System.out.println(gameProgress1);
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
