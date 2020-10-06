package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import connectfour.Player;

class PlayerTest {

	@Test
	void test() {
		Player player = new Player("Jean", 'X');
		assertEquals("Jean", player.getName());
		assertEquals('X', player.getSymbol());
	}

}
