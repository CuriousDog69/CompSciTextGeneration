import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BasicTest {
    public static void main(String[] args) throws FileNotFoundException {
        String text = FileReader.getString("W:\\Students\\Per2\\26 Cole S\\CompleteShakespere.txt");
        ArrayList<Integer> values = new ArrayList<>();
        Scanner KEYBOARD = new Scanner(System.in);
        System.out.println("Length:");
        int numLetters = KEYBOARD.nextInt();
        String output = "";
        for (int i = 0; i < numLetters; i++) {
            output += text.charAt((int)(Math.random() * text.length()));
        }
        System.out.print(output);
    }
}
