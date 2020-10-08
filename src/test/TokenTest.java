package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import connectfour.Player;
import connectfour.Token;

// TODO: Auto-generated Javadoc
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
        Token token = new Token(player);
        assertEquals(player, token.getPlayer());
    }

}
