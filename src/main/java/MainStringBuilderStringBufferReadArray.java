import java.io.*;
import java.util.Arrays;

public class MainStringBuilderStringBufferReadArray {
//    public static void main(String[] args) {
//        File directory = new File("folder");
//        directory.mkdir();
//        File file = new File(directory, "names.txt");
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
//            int a = reader.read();
//            StringBuilder result = new StringBuilder();
//            while (a > 0) {
//                result.append((char) a);
//                a = reader.read();
//            }
//            System.out.println(result.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

    public static void main(String[] args) {
        File directory = new File("folder");
        File file = new File(directory, "names.txt");
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            char[] array = new char[128];
            int count = reader.read(array);
            StringBuilder result = new StringBuilder();
            while (count > 0) {
                result.append(new String(array, 0, count));
                count = reader.read(array);
            }
            String[] names = result.toString().split(" ");
            Arrays.stream(names)
                    .filter(name -> name.startsWith("A"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

