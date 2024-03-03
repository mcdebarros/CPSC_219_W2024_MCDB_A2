import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTests {

    @Test
    void test_isGoodInput_Basic()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begin";
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        assertTrue(test_result, "Used word <begin>. Result should have been true.");
    }

    @Test
    void test_isGoodInput_tooLong()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begins";
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        assertFalse(test_result, "Used word <begins>. Result should have been False.");
    }

    @Test
    void test_isGoodInput_tooShort()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begs";
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        assertFalse(test_result, "Used word <begs>. Result should have been False.");
    }

    @Test
    void test_isGoodInput_nullInput()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = null;
        assertThrows(NullPointerException.class,() -> {testGameRunner.isGoodInput(toCheck);});
    }

    @Test
    void test_isGoodInput_notAlpha()
    {
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "beg1n";
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        assertFalse(test_result, "Used word <beg1n>. Result should have been false.");
    }

    @Test
    void test_isGoodInput_notWord() {

        GameRunner testGameRunner = new GameRunner();
        String toCheck = "aaaaa";
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        assertFalse(test_result,"User word <aaaaa>. Result should have been false.");
    }
}
