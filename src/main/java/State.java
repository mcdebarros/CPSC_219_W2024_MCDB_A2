//package ;

import java.util.*;

public class State {

    private final String secretWord;
    private int[] letterStatus;
    private final int WORD_LENGTH = 5;
    private final Random INDEX = new Random();

    private final int NO_MATCH = 0;
    private final int IN_WORD = 1;
    private final int EXACT_MATCH = 2;

    public State(ArrayList<String> words)
    {
         secretWord = words.get(INDEX.nextInt(words.size()));
         letterStatus = new int[WORD_LENGTH];
         for (int i = 0; i < WORD_LENGTH;i++)
         {
             letterStatus[i] = NO_MATCH;
         }

    }

    public State(String inputWord)
    {
        secretWord = inputWord;
        letterStatus = new int[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH;i++)
        {
            letterStatus[i] = NO_MATCH;
        }
    }

    public void updateState(String newGuess)
    {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (secretWord.contains(String.valueOf(newGuess.charAt(i)))) {
                letterStatus[i] = IN_WORD;
                if (secretWord.charAt(i) == newGuess.charAt(i))
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
        return STR."State{secretWord='\{secretWord}\{'\''}, letterStatus=\{Arrays.toString(letterStatus)}\{'}'}";
    }
}
