package fileExample;

import java.io.*;

public class Main {
    private static final String DIRECTORY_OF_THE_MAIN_DIR = "D:\\Codes\\JavaProjects\\FileExample\\Games\\";
    private static final String FILE_LOG = DIRECTORY_OF_THE_MAIN_DIR + "temp//temp.txt";
    private static final StringBuilder LOG = new StringBuilder();

    public static void main(String[] args) {
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "src");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "res");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "savegames");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "temp");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "src\\main");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "src\\test");
        createFile(DIRECTORY_OF_THE_MAIN_DIR + "src\\main\\Main.java");
        createFile(DIRECTORY_OF_THE_MAIN_DIR + "src\\main\\Utils.java");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "res\\drawables");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "res\\vectors");
        createDirectory(DIRECTORY_OF_THE_MAIN_DIR + "res\\icons");
        createFile(DIRECTORY_OF_THE_MAIN_DIR + "temp\\temp.txt");
        String file_log = FILE_LOG.toString();
        writeLog(file_log);
        readLog(file_log);
    }


    public static void createFile(String fileName) {
        try {
            if (new File(fileName).createNewFile()) {
                LOG.append(fileName).append(" file was created\n");
            } else {
                LOG.append(fileName).append(" file is exists, try again\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void createDirectory(String dirName) {
        if (new File(dirName).mkdir()) {
            LOG.append(dirName).append(" directory was created\n");
        } else {
            LOG.append(dirName).append(" directory is exists, try again!\n");
        }
    }

    private static void writeLog(String logFileName){
        try (FileOutputStream fileOutputStream = new FileOutputStream(logFileName)) {
            fileOutputStream.write(LOG.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readLog(String logFileName){
        try (FileInputStream fileInputStream = new FileInputStream(logFileName);) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
