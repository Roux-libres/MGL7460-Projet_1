package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.Column;
import connectfour.Grid;
import connectfour.Player;

class GridTest {
	private Grid grid;
	private Player player;

	@BeforeEach
	void setUp() throws Exception {
		this.player = new Player("player", 'X');
	}

	@Test
	void testGrid() {
		final int columns = 8;
		final int rows = 6;
		final Grid grid = new Grid(columns, rows);

		assertEquals(columns, grid.getColumns().length);

		for (final Column column : grid.getColumns()) {
			assertEquals(rows, column.getTiles().length);
		}
	}

	@Test
	void testAddToken() {
		final int columnIndex = 0;

		this.grid.addToken(columnIndex, this.player);
		assertEquals(this.player, this.grid.getColumns()[columnIndex]
				.getTile(this.grid.getColumns()[columnIndex].getIndexEmptyTile()).getToken().getPlayer());
	}

	@Test
	void testGetPlayerFromTile() {
		final int columnIndex = 0;

		this.grid.addToken(columnIndex, this.player);
		assertEquals(this.player, this.grid.getPlayerFromTile(columnIndex, 0));
	}

}
