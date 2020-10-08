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
    void setUp() {
        this.tile = new Tile();
        this.player = new Player("foo", 'x');
    }



    /**
     * Test tile.
     */
    @Test
    void testTile() {
        assertNull(this.tile.getToken());
    }

    /**
     * Test get and set token.
     */
    @Test
    void testGetAndSetToken() {
        this.tile.setToken(this.player);
        final Token token = this.tile.getToken();
        assertEquals(this.player, token.getPlayer());
    }


    /**
     * Test is empty.
     */
    @Test
    void testIsEmpty() {
        assertTrue(this.tile.isEmpty());
        this.tile.setToken(this.player);
        assertFalse(this.tile.isEmpty());
    }

}
