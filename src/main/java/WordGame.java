public class WordGame {
    public static void main(String [] args)
    {
        GameRunner myGame = new GameRunner();
        WordGame.printWelcome();
        myGame.playGame();

    }

    public static void printWelcome()
    {
        System.out.println("Welcome to wordle! A new game has been started and the guess counter is currently 0.");
    }
}
