import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        File directory = new File("folder/folder2/folder1");
//        File file = new File("folder/folder2/folder1/file1.txt");
//        File file2 = new File("folder/folder2/folder1/file2.txt");
//        File file3 = new File("folder/folder2/folder1/file3.txt");
//        try {
//            directory.mkdirs();
//            file.createNewFile();
//            file2.createNewFile();
//            file3.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File[] files = directory.listFiles((dir, name) -> name.contains("1"));
//        for (File f : files) {
//            System.out.println(f.getName());
//        }
//    }
public static void main(String[] args) {
    String path = "folder1/folder2/folder3";
    File directories = new File(path);
    List<File> files = new ArrayList<>();
    files.add(new File(path + "/A1.txt"));
    files.add(new File(path + "/A2.txt"));
    files.add(new File(path + "/A3.txt"));
    files.add(new File(path + "/B1.txt"));
    files.add(new File(path + "/B2.txt"));
    directories.mkdirs();
    for (File file : files) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    File[] filtered = directories.listFiles((dir, name) -> name.startsWith("A"));
    for (File file : filtered) {
        System.out.println(file.getAbsolutePath());
    }
}
}
