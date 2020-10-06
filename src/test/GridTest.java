package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.Grid;
import connectfour.Tile;

class GridTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGrid() {
		final int columns = 8;
		final int rows = 6;
		final Grid grid = new Grid(columns, rows);

		assertEquals(columns, grid.getColumns().length);

		for (final Tile tile : grid.getColumns()[0].getTiles()) {

		}
	}

	@Test
	void testAddToken() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlayerFromTile() {
		fail("Not yet implemented");
	}

}
