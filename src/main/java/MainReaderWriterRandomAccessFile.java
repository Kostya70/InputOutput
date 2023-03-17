import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainReaderWriterRandomAccessFile {
//    public static void main(String[] args) {
//        File directory = new File("folder");
//        File file = new File(directory, "names.txt");
//        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
//            randomAccessFile.seek(5000);
//            byte[] array = new byte[1024];
//            randomAccessFile.read(array);
//            System.out.println(new String(array));
//            randomAccessFile.seek(0);
//            randomAccessFile.read(array);
//            System.out.println(new String(array));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

    public static void main(String[] args) {
        File directory = new File("folder");
        File file = new File(directory, "names.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter next page or \"stop\" to exit");
            byte[] pageText = new byte[3000];
            String input = scanner.nextLine();
            while (!input.equals("stop")) {
                int page = Integer.parseInt(input);
                randomAccessFile.seek((page - 1) * pageText.length);
                int count = randomAccessFile.read(pageText);
                System.out.println(new String(pageText, 0, count));
                System.out.println("Enter next page or \"stop\" to exit");
                input = scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

