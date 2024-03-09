//package ;

import java.util.*;

public class State {

    private final String SECRET_WORD; // Changed to final
    private int[] letterStatus;
    private final int WORD_LENGTH = 5;
    private final Random GET_INDEX = new Random(); // Random number generator for word list indexing
    private final int NO_MATCH = 0;
    private final int IN_WORD = 1;
    private final int EXACT_MATCH = 2;
    private int INDEX; // Index of word list for secret word

    public State(ArrayList<String> words)
    {
        INDEX = GET_INDEX.nextInt(words.size()); // Generate random index
        SECRET_WORD = words.get(INDEX); // Pick secret word from ArrayList using random index
        letterStatus = new int[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH;i++)
        {
            letterStatus[i] = NO_MATCH;
        }

    }

    public State(String inputWord)
    {
        SECRET_WORD = inputWord;
        letterStatus = new int[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH;i++)
        {
            letterStatus[i] = NO_MATCH;
        }
    }

    public void updateState(String newGuess)
    {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (SECRET_WORD.contains(String.valueOf(newGuess.charAt(i)))) {
                letterStatus[i] = IN_WORD;
                if (SECRET_WORD.charAt(i) == newGuess.charAt(i))
                    letterStatus[i] = EXACT_MATCH;
            }

        }
    }

    public boolean hasWin()
    {
        boolean winState = true;
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (letterStatus[i] < EXACT_MATCH)
                winState = false;
        }
        return winState;
    }

    @Override
    public String toString() {
        return STR."State{secretWord='\{SECRET_WORD}\{'\''}, letterStatus=\{Arrays.toString(letterStatus)}\{'}'}";
    }
}
