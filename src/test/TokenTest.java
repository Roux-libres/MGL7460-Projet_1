package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import connectfour.Player;
import connectfour.Token;

/**
 * The Class TokenTest.
 */
class TokenTest {

    /**
     * Test get player.
     */
    @Test
    void testGetPlayer() {
        final Player player = new Player("Jean", 'X');
        final Token token = new Token(player);
        assertEquals(player, token.getPlayer());
    }

}
