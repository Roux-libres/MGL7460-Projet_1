package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.GameManager;
import connectfour.Grid;
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
		assertEquals(actualWidth, gameManager.getGrid());
	}

	@Test
	void testSetPlayers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTurnCount() {
		fail("Not yet implemented");
	}


	@Test
	void testGetPlayerByIndex() {
		fail("Not yet implemented");
	}

	@Test
	void testPlayGame() {
		fail("Not yet implemented");
	}

	
	@Test
	void testInitGame() {
		fail("Not yet implemented");
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
