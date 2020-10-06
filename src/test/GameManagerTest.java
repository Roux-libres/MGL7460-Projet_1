package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.GameManager;
import connectfour.Grid;
import connectfour.Player;
import connectfour.Token;

class GameManagerTest {

	GameManager gameManager;
	
	@BeforeEach
	void setUp() throws Exception {
		gameManager = new GameManager();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAndSetAlignedToken() {
		int actualValue = 5;
		gameManager.setAlignedToken(actualValue);
		assertEquals(actualValue, gameManager.getAlignedToken());
	}


	@Test
	void testGetAndSetGrid() {
		int actualWidth = 5;
		int actualHeight = 6;
		gameManager.setGrid(actualWidth, actualHeight);
	
		Grid testGrid = new Grid(actualWidth, actualHeight);
		assertEquals(testGrid, gameManager.getGrid());
	}

	@Test
	void testGetTurnCount() {
		final int expectedTurnCount = 3;
		for(int index = 0; index < expectedTurnCount; index++) {
			this.gameManager.incrementTurnCount();
		}
		assertEquals(expectedTurnCount, this.gameManager.getTurnCount());
	}

	@Test
	void testPlayGame() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateandGetPlayer() {
		gameManager.createPlayer("Didier", 'x');
		Player player = new Player("Didier", 'x');
		assertEquals(player.getName(), gameManager.getPlayerByIndex(0).getName());
		assertEquals(player.getSymbol(), gameManager.getPlayerByIndex(0).getSymbol());
	}
	
	@Test
	void testHasWon() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayGrid() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayVictory() {
		fail("Not yet implemented");
	}

}
