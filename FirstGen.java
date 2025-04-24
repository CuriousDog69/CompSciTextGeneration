import java.io.FileNotFoundException;
import java.util.HashMap;

public class FirstGen {
    public static void main(String[] args) throws FileNotFoundException {
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcd";
        HashMap<Character,ProbabilitySet> Chars = new HashMap<>();

        for (int i = 0; i < a.length() - 1; i++) {
            Character c = a.charAt(i);
            if (!Chars.containsKey(c)) {
                Chars.put(c, new ProbabilitySet( (int) a.charAt(i+1) - 33));
            } else {
                Chars.get(c).inc((int) a.charAt(i+1) - 33);
            }
        }

    }
}
