package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.Column;
import connectfour.Grid;
import connectfour.Player;

class GridTest {
	private Grid grid;
	private Player player;
	final int columns = 8;
	final int rows = 6;

	@BeforeEach
	void setUp() throws Exception {
		this.player = new Player("player", 'X');
		this.grid = new Grid(this.columns, this.rows);
	}

	@Test
	void testGrid() {
		assertEquals(this.columns, this.grid.getColumns().length);

		for (final Column column : this.grid.getColumns()) {
			assertEquals(this.rows, column.getTiles().length);
		}
	}

	@Test
	void testAddToken() {
		final int columnIndex = 0;

		this.grid.addToken(columnIndex, this.player);
		assertEquals(this.player, this.grid.getColumns()[columnIndex]
				.getTile(this.grid.getColumns()[columnIndex].getIndexEmptyTile() - 1).getToken().getPlayer());
	}

	@Test
	void testGetPlayerFromTile() {
		final int columnIndex = 0;

		this.grid.addToken(columnIndex, this.player);
		assertEquals(this.player, this.grid.getPlayerFromTile(columnIndex, 0));
	}

}
