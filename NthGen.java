import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


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
        System.out.println("Key: \""+key+"\"");
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
        Scanner s = new Scanner(System.in);
        System.out.print("Choose your analysis level from 1-10: ");
        int level = s.nextInt();
        NthGen fg = new NthGen(level);
        System.out.print("Choose your output length in characters: ");
        int length = s.nextInt();
        System.out.println("1): Bible, 2): A Christmas Carol 3): The Odyssey 4): Paradise Lost 5): The Works of William Shakespeare");
        System.out.println("For a random choice of the five above, enter 0.");
        System.out.print("Choose your input: ");
        int input = s.nextInt();
        String[] strings = {"Bible.txt", "ChristmasCarol.txt", "Odyssey.txt", "ParadiseLost.txt", "Shakespeare.txt"};
        if ((input>0)&&(input<6)) {
            fg.setText(FileReader.getString(strings[input-1]));
            System.out.println("You have chosen to read from "+strings[input-1]);
        }
        else if (input == 0) {
            input = (int) (Math.random()*5);
            fg.setText(FileReader.getString(strings[input]));
            System.out.println("You have chosen to read from "+strings[input]);
        }
        else {
            System.out.println("Invalid entry type: "+input+" not in the desired range");
        }




        String output = fg.run(length);
        System.out.println("Output: \""+output+"\"");
        //System.out.println("\n\n\n" + output);
        copyToClipboard(output);

    }
}
