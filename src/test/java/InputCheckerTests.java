import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputCheckerTests {

    @Test
    void test_notAlpha() {

        String testInput = "B0NES";
        boolean result = InputChecker.allAlpha(testInput);
        assertFalse(result,"True flag returned for non-alphabetic input. Expected false.");
    }

    @Test
    void test_allAlpha() {

        String testInput = "BONES";
        boolean result = InputChecker.allAlpha(testInput);
        assertTrue(result,"False flag returned for alphabetic input. Expected true.");
    }

    @Test
    void test_notEnglish() {

        String testInput = "AAAAA";
        ArrayList<String> testList = new ArrayList<>();
        testList.add("BONES"); testList.add("SAUCE"); testList.add("DONUT");
        boolean result = InputChecker.isEnglish(testInput,testList);
        assertFalse(result,"True flag returned for gibberish input. Expected false.");
    }

    @Test
    void test_isEnglish() {

        String testInput = "DONUT";
        ArrayList<String> testList = new ArrayList<>();
        testList.add("BONES"); testList.add("SAUCE"); testList.add("DONUT");
        boolean result = InputChecker.isEnglish(testInput,testList);
        assertTrue(result,"False flag returned for english input. Expected true.");
    }

    @Test
    void test_fixCase() {

        String expected = "SAUCE";
        String testInput = "sauce";
        String result = InputChecker.fixCase(testInput);
        assertEquals(expected,result,"Failed to convert lowercase string to uppercase");
    }

    @Test
    void test_isNull() {

        String testInput = null;
        boolean result = InputChecker.notNull(testInput);
        assertFalse(result,"True flag returned for null input. False expected for null input.");
    }

    @Test
    void test_notNull() {

        String testInput = "DONUT";
        boolean result = InputChecker.notNull(testInput);
        assertTrue(result,"False flag returned for populated input. True expected for non-null input.");
    }

    @Test
    void test_tooShort() {

        String testInput = "bane";
        boolean result = InputChecker.correctLength(testInput,5);
        assertFalse(result,"Returned true flag for short input. Expected false.");
    }

    @Test
    void test_tooLong() {

        String testInput = "banana";
        boolean result = InputChecker.correctLength(testInput,5);
        assertFalse(result,"True flag returned for long input. Expected false.");
    }

    @Test
    void test_correctLength() {

        String testInput = "BEANS";
        boolean result = InputChecker.correctLength(testInput,5);
        assertTrue(result,"Returned false for correct length string. Expected true.");
    }
}
