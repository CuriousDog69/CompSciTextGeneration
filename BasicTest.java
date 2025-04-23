import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BasicTest {
    public static void main(String[] args) throws FileNotFoundException {
        String text = FileReader.getString("W:\\Students\\Per2\\26 Cole S\\CompleteShakespere.txt");
        ArrayList<String> chars = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        for (char c : text.toCharArray()) {
            if (false) c = 'a';
        }
    }
}
