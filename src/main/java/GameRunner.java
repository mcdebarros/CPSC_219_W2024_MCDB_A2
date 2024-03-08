import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GameRunner {

    private final int MAX_TURNS = 6;
    private final int WORD_LENGTH = 5;
    private int numTurns;
    private State gameState;
    private final ArrayList<String> VALID_WORDS;
    private final Random INDEX = new Random();

    public GameRunner()
    {
        // A note: pre-setting the initial capacity of the HashSet to approximately the right size
        // should make populating the HashSet a bit faster.
        VALID_WORDS = new ArrayList<String>();
        try
        {
            FileReader fReader = new FileReader("src/main/sgb-words.txt");
            BufferedReader bReader = new BufferedReader(fReader);

            String currentLine = null;
            while((currentLine = bReader.readLine()) != null)
            {
                VALID_WORDS.add((currentLine.strip()).toUpperCase());
            }
        }
        catch(IOException ioE)
        {
            System.err.println("There seems to be an issue with sgb-words");
        }

    }

    public void playGame()
    {
        numTurns = 0;
        String guess;
        gameState = new State(VALID_WORDS);
        Scanner input = new Scanner(System.in);

        while ((numTurns < MAX_TURNS) && (!gameState.hasWin()))
        {
            System.out.println("Type a five-letter word");
            guess = (input.nextLine()).toUpperCase();

            if (!isGoodInput(guess))
            {
                System.out.println("Your input was invalid in some way. " +
                        "Make sure you have a six letter word with only characters from A-Z");
               continue;
            }

            gameState.updateState(guess);
            numTurns++;
        }
        if(gameState.hasWin())
        {
            System.out.println("Wow! You won in " + numTurns  + "guesses. Good work!");
        }

    }

    public boolean isGoodInput(String toCheck) throws NullPointerException
    {
        toCheck = InputChecker.fixCase(toCheck);
        return (InputChecker.allAlpha(toCheck) && InputChecker.notNull(toCheck) && InputChecker.correctLength(toCheck,WORD_LENGTH) && InputChecker.isEnglish(toCheck, VALID_WORDS));
    }


}
