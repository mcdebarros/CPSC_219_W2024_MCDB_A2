import java.util.*;

public class InputChecker {

    public static boolean allAlpha(String word) { // Check that string contains only alphabetic characters

        boolean onlyAlpha = true;
        for (Character letter:word.toCharArray()) {
            if (!Character.isLetter(letter)) {
                onlyAlpha = false;
                break;
            }
        }
        return onlyAlpha;
    }

    public static boolean correctLength(String word, int length) { // Check that string is exactly of specified length

        return word.length() == length;
    }

    public static boolean isEnglish(String word, ArrayList<String> list) { // Check that string is contained in provided ArrayList

        return list.contains(word);
    }

    public static String fixCase(String word) { // Convert string to uppercase

        return word.toUpperCase();
    }

    public static boolean notNull(String word) { // Verify that string is not null

        return (word != null);
    }
}

