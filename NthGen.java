import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class NthGen {

    private String text;
    private HashMap<String,String[]> cache = new HashMap<>();
    private int keyLength;

    public NthGen(int keyLength) {
        this.keyLength = keyLength;
    }

    public String getRandomFromString(String key) {
        ArrayList<String> choices = new ArrayList<>();
        int index = text.indexOf(key);
        while (index != -1 && index < text.length() - keyLength) {
            if (index + keyLength < text.length()) {
                choices.add(text.substring(index + keyLength, index + keyLength + 1));
            }
            index = text.indexOf(key, index + 1);
        }

        String[] arrayToCache = new String[choices.size()];
        choices.toArray(arrayToCache);
        cache.put(key, arrayToCache);
        return choices.get((int) (Math.random() * choices.size()));
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        int index = (int) (Math.random() * text.length());
        return text.substring(index, index + keyLength);
    }


    public String run(int length) {
        String output = getKey();
        String key = output;
        System.out.println(key);
        while (output.length() < length) {
            if (cache.containsKey(key)) {
                output += cache.get(key)[(int) (cache.get(key).length * Math.random())];
            } else {
                output += getRandomFromString(key);
            }

            key = output.substring(output.length() - keyLength);

        }
        return output;
    }

    public static void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void main(String[] args) throws FileNotFoundException {
        NthGen fg = new NthGen(25);
        fg.setText(FileReader.getString("C:\\Users\\xxjbr\\IdeaProjects\\CompSciTextGeneration\\bible.txt"));
        String output = fg.run(5000);
        //System.out.println("\n\n\n" + output);
        copyToClipboard(output);

    }
}
