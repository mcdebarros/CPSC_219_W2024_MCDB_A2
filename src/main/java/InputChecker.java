import java.util.*;

public class InputChecker {

    public static boolean allAlpha(String word) {

        boolean onlyAlpha = true;
        for (Character letter:word.toCharArray()) {
            if (!Character.isLetter(letter)) {
                onlyAlpha = false;
                break;
            }
        }
        return onlyAlpha;
    }

    public static boolean correctLength(String word, int length) {

        return word.length() == length;
    }

    public static boolean isEnglish(String word, ArrayList<String> list) {

        return list.contains(word);
    }

    public static String fixCase(String word) {

        return word.toUpperCase();
    }

    public static boolean notNull(String word) {

        return (word != null);
    }
}
