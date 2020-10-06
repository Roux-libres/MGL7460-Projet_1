package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import connectfour.Player;
import connectfour.Token;

class TokenTest {
	
	@Test
	void testGetPlayer() {
		final Player player = new Player("Jean", 'X');
		Token token = new Token(player);
		assertEquals(player, token.getPlayer());
	}

}