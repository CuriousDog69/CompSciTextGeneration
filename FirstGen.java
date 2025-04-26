import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;


public class FirstGen {

    private String text;
    private HashMap<String,String[]> cache = new HashMap<>();

    public String getRandomFromString(String key) {
        String temp = text;
        ArrayList<String> choices = new ArrayList<>();
        while (temp.indexOf(key) > 0 && temp.indexOf(key) < temp.length()-1) {
            choices.add(temp.substring(temp.indexOf(key) + 1,temp.indexOf(key) + 2));
            temp = temp.substring(temp.indexOf(key) + 1);
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
        int index = (int) (Math.random() * text.length()) ;
        return text.substring(index, index + 1);
    }


    public String run(int length) {
        String output = getKey();
        String key = output;
        while (output.length() < length) {
            if (cache.containsKey(key)) {
                output += cache.get(key)[(int) (cache.get(key).length * Math.random())];
            } else {
                output += getRandomFromString(key);
            }

            key = output.substring(output.length() - 1);
            System.out.println("Output: " + output + ", Key: " + key);
        }
        return output;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FirstGen fg = new FirstGen();
        fg.setText(FileReader.getString("C:\\Users\\xxjbr\\IdeaProjects\\CompSciTextGeneration\\manifesto.txt"));
        fg.run(10);
    }
}
