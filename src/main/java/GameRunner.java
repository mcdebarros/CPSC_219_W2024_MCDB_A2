import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameRunner {

    private final int MAX_TURNS = 6;
    private final int WORD_LENGTH = 5;
    private int numTurns;
    private State gameState;
    private final ArrayList<String> VALID_WORDS; // Modified from HashSet to appreciate indexing features in generating random secret words.

    public GameRunner() {

        VALID_WORDS = new ArrayList<String>();
        try {

            FileReader fReader = new FileReader("src/main/sgb-words.txt");
            BufferedReader bReader = new BufferedReader(fReader);
            String currentLine = null;
            while((currentLine = bReader.readLine()) != null) {
                VALID_WORDS.add(InputChecker.fixCase(currentLine.strip())); // Modified to appreciate the fixCase() method in InputChecker
            }
        }
        catch(IOException ioE) {

            System.err.println("There seems to be an issue with sgb-words");
        }

    }

    public void playGame() {
        numTurns = 0;
        String guess;
        gameState = new State(VALID_WORDS); // GameState initialized by passing ArrayList of english words
        Scanner input = new Scanner(System.in);

        while ((numTurns < MAX_TURNS) && (!gameState.hasWin()))
        {
            System.out.println("Type a five-letter word");
            guess = InputChecker.fixCase(input.nextLine()); // Modified to use the fixCase() method in InputChecker

            if (!isGoodInput(guess))
            {
                System.out.println("Your input was invalid in some way. " +
                        "Make sure you have a six letter word with only characters from A-Z");
               continue;
            }

            gameState.updateState(guess);
            numTurns++;
        }
        if(gameState.hasWin()) {
            System.out.println("Wow! You won in " + numTurns  + "guesses. Good work!");
        }
    }

    public boolean isGoodInput(String toCheck) { // Modified to completely employ the InputChecker class in verifying input validity
        toCheck = InputChecker.fixCase(toCheck);
        return (InputChecker.allAlpha(toCheck) && InputChecker.notNull(toCheck) && InputChecker.correctLength(toCheck,WORD_LENGTH) && InputChecker.isEnglish(toCheck, VALID_WORDS));
    }
}
