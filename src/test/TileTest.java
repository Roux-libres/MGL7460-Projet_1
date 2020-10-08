/**
* 
*/
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import connectfour.Player;
import connectfour.Tile;
import connectfour.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class TileTest.
 */
class TileTest {

    /** The tile. */
    Tile tile;

    /** The player. */
    Player player;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {
        tile = new Tile();
        player = new Player("foo", 'x');
    }



    /**
     * Test tile.
     */
    @Test
    void testTile() {
        assertNull(tile.getToken());
    }

    /**
     * Test get and set token.
     */
    @Test
    void testGetAndSetToken() {
        tile.setToken(player);
        Token token = tile.getToken();
        assertEquals(player, token.getPlayer());
    }


    /**
     * Test is empty.
     */
    @Test
    void testIsEmpty() {
        assertTrue(tile.isEmpty());
        tile.setToken(player);
        assertFalse(tile.isEmpty());
    }

}
