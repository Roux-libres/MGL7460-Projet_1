/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.Player;
import connectfour.Tile;
import connectfour.Token;

/**
 * @author Nelson
 *
 */
class TileTest {
	
	Tile tile;
	Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 tile = new Tile();
		 player = new Player("foo", 'x');	 
	}


	/**
	 * Test method for {@link connectfour.Tile#Tile()}.
	 */
	@Test
	void testTile() {
		assertNull(tile.getToken());
	}

	/**
	 * Test method for {@link connectfour.Tile#getToken()} and {@link connectfour.Tile#setToken()}
	 */
	@Test
	void testGetAndSetToken() {
		tile.setToken(player);
		Token token = tile.getToken();
		assertEquals(player, token.getPlayer());
	}


	/**
	 * Test method for {@link connectfour.Tile#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(tile.isEmpty());
		tile.setToken(player);
		assertFalse(tile.isEmpty());
	}

}
