package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import connectfour.Player;
import org.junit.jupiter.api.Test;

/**
 * The Class PlayerTest.
 */
class PlayerTest {

    /**
     * Test.
     */
    @Test
    void test() {
        final Player player = new Player("Jean", 'X');
        assertEquals("Jean", player.getName());
        assertEquals('X', player.getSymbol());
    }

}
