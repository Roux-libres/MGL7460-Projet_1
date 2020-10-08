package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import connectfour.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
class PlayerTest {

    /**
     * Test.
     */
    @Test
    void test() {
        Player player = new Player("Jean", 'X');
        assertEquals("Jean", player.getName());
        assertEquals('X', player.getSymbol());
    }

}
