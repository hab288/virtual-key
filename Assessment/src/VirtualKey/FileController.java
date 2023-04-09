package VirtualKey;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class FileController {


    private static File file_path;
    public static String primary_path = Paths.get("").toAbsolutePath() + File.separator + "MainFolder";


    // If folder not exist, creat new one
    public static void createNewFolder(String new_folder_to_be_created) {
        file_path = new File(new_folder_to_be_created);
        if (!file_path.exists()) {
            file_path.mkdirs();
        }
    }

    // Display all files
    public static void displayAllFiles() {
        file_path = new File(primary_path);
        if (Objects.requireNonNull(file_path.list()).length > 0) {

            String[] list_of_files = file_path.list();
            Arrays.sort(list_of_files);

            System.out.println("  Displaying all files\n");
            for (String file : list_of_files) {
                System.out.println(" " + file);
            }

        } else {
            System.out.println("  No file exist! \n");
        }
    }


    //Add file
    public static void addFile(String file_name) {
        try {
            File new_file = new File(primary_path + File.separator + file_name);
            String[] files_list = file_path.list();
            for (String each_file : files_list) {
                if (file_name.equalsIgnoreCase(each_file)) {
                    System.out.println(file_name + " file already exist in the MainFolder directory");
                    return;
                }
            }
            new_file.createNewFile();
            System.out.println("File created ");
        } catch (IOException e) {
            System.out.println("Error file not created");
            System.out.println(e.getMessage());
        }

    }

    // Delete file
    public static void deleteFile(String file_name) {
        File new_file = new File(primary_path + File.separator + file_name);
        file_path = new File(primary_path);
        String[] file_list = file_path.list();

        for (String each_file : file_list) {
            if (each_file.equals(file_name)) {
                new_file.delete();
                System.out.println("File Deleted Successfully\n");
                return;
            }
        }
        System.out.println("File Can't Be Deleted!");
        System.out.println(file_name + " File Not Exist In Directory\n");

    }


    // Search file
    public static void searchFile(String file_name) {
        file_path = new File(primary_path);
        String[] file_list = file_path.list();
        for (String each_file : file_list) {
            if (each_file.equals(file_name)) {
                System.out.println(file_name + " File found at " + file_path);
                return;
            }
        }
        System.out.println(file_name + " File Not Found\n");
    }
}
