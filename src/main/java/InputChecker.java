import java.util.HashSet;

public class InputChecker {

    public boolean allAlpha(String word) {

        boolean onlyAlpha = true;
        for (Character letter:word.toCharArray()) {
            if (!Character.isLetter(letter)) {
                onlyAlpha = false;
                break;
            }
        }
        return onlyAlpha;
    }

    public boolean correctLength(String word) {

        return word.length() == 5;
    }

    public boolean isEnglish(String word, HashSet<String> list) {

        return list.contains(word);
    }

    public String fixCase(String word) {

        return word.toUpperCase();
    }
}
