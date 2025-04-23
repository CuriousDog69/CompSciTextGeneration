import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static String getString(String fileName) throws FileNotFoundException {
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        return content;
    }
}
