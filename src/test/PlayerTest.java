package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import connectfour.Player;

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
