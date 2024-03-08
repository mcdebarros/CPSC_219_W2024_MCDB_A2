import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTests {

    @Test
    void test_constructor() {

        GameRunner testGameRunner = new GameRunner();
        assertNotNull(testGameRunner);
    }

    @Test
    void test_isGoodInput_bad() {

        GameRunner testGameRunner = new GameRunner();
        String testInput = "sports are bad";
        boolean result = testGameRunner.isGoodInput(testInput);
        assertFalse(result,"True flag received for bad input. Should be false.");
    }

    @Test
    void test_isGoodInput_good() {

        GameRunner testGameRunner = new GameRunner();
        String testInput = "nerdy";
        boolean result = testGameRunner.isGoodInput(testInput);
        assertTrue(result,"Returned false for good input. Expected true.");
    }
}
