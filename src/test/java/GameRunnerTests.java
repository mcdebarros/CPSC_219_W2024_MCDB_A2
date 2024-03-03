import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTests {
    @Test
    void test_isGoodInput_Basic()
    {
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begin";
        // Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        // Assert
        assertTrue(test_result, "Used word <begin>. Result should have been true.");
    }


    // TODO: Rewrite using the Arrange/Act/Assert pattern
    @Test
    void test_isGoodInput_tooLong()
    {
        GameRunner testGameRunner = new GameRunner();
        assertFalse(testGameRunner.isGoodInput("begins"), "Used word <begins>. Result should have been true.");
    }

    // TODO: Create a test for a word that is too short. Use the Arrange, Act, Assert pattern

    // TODO: Fix this.
    @Test
    void test_isGoodInput_notAlpha()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "beg1n";
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        assertTrue(test_result, "Used word <beg1n>. Result should have been false.");
    }


}
