import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String student = "26 Cole S";

    public FileReader() {}

    public FileReader(String studentName) {
        student = studentName;
    }

    public String getString(String fileName) throws FileNotFoundException {
        File file = new File("W:\\Students\\Per2\\" + student + "\\CompSciTextGeneration\\" + fileName);
        String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
        return content;
    }
}
