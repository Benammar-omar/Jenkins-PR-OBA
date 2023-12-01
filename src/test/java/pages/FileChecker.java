package pages;

import java.io.File;

public class FileChecker {
    public boolean checkFileContains(String directoryPath, String searchName) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(searchName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
