package main;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Sesame {
    public static final String FILENAME = "/Users/momar/Documents/dev/the-pink-channel/sesame-prototype/res/data.json";
    static JSONArray scales = getScales(FILENAME);
    private static boolean isInputValid = false;


    public static void main(String[] args) {
        String[] input;
        Scanner in = new Scanner(System.in);

        input = readUserInput(in);

        while (!isInputValid) {
            System.out.println("Your input is invalid.");
            input = readUserInput(in);
        }

        in.close();

        List<String> result = getScale(input);
        System.out.println(result);
    }

    // Get JSON data
    public static JSONArray getScales(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            JSONTokener token = new JSONTokener(reader);
            JSONArray data = new JSONArray(token);

            reader.close();

            return data;
        } catch (IOException e) {
            System.out.println("Can't read file.");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get the scale given an array of notes
     * @param notes the array of notes
     * @return a list of scale that corresponds
     */
    public static List<String> getScale(String[] notes) {
        List<String> results = new ArrayList<>();

        for (Object o : scales) {
            JSONObject a = (JSONObject) o;
            JSONArray arr = (JSONArray) a.get((String) a.names().get(0));

            for (Object i : arr) {
                JSONArray array = (JSONArray) i;

                int counter = 0;

                for (String str : notes) {

                    for (int x = 0; x < array.length(); x++) {
                        if (str.equals(array.get(x))) {
                            counter++;
                            break;
                        }
                        ;
                    }
                }

                String scale = (String) a.names().get(0);

                if (counter == notes.length && !results.contains(scale)) {
                    results.add(scale);
                }
            }
        }

        return results;
    }

    // Get User Input
    public static String[] readUserInput(Scanner in) {
        String[] formattedInput;

        System.out.println("Enter notes (i.e. C F# G A): ");

        String input = in.nextLine();

        if (validateInput(input)) {
            isInputValid = true;
            formattedInput = formatInput(input);
            return formattedInput;
        } else {
            return null;
        }
    }

    // Format input
    public static String[] formatInput(String input) {
        return input.split("[\s]");
    }

    // Validate input
    public static boolean validateInput(String input) {
        input = input.concat(";");
        String regex = "^([A-G][#|b]{0,1}[\\s|;]{1}){0,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        boolean isInputValid =  false;

        if (matcher.find()) isInputValid = true;

        return isInputValid;
    }
}