import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StateTests {

    @Test
    void test_constructor_noInput() {

        State testState = new State();
        assertNotNull(testState,"Failed to construct state object.");
    }

    @Test
    void test_constructor_input() {

        State testState= new State("DONUT");
        assertNotNull(testState,"Failed to construct state object.");
    }

    @Test
    void test_updateState() {

        State defaultState = new State("DONUT");
        State testState = new State("DONUT");
        testState.updateState("DONUT");
        assertNotEquals(defaultState,testState,"State remains unchanged from default.");
    }

    @Test
    void test_noWin() {

        State testState = new State();
        boolean winner = testState.hasWin();
        assertFalse(winner,"Game won despite no state update from default.");
    }

    @Test
    void test_hasWin() {

        State testState = new State("DONUT");
        testState.updateState("DONUT");
        boolean winner = testState.hasWin();
        assertTrue(winner,"Game lost despite correct guess.");
    }

    @Test
    void test_toString() {

        State testState = new State();
        String expect = "State{secretWord='BLAST', letterStatus=[0, 0, 0, 0, 0]}";
        String actual = testState.toString();
        assertEquals(expect,actual,"toString() method failed to produce expected string.");
    }
}
