package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import connectfour.Column;
import connectfour.Grid;
import connectfour.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class GridTest.
 */
class GridTest {

    /** The grid. */
    private Grid grid;

    /** The player. */
    private Player player;

    /** The columns. */
    static int columns = 8;

    /** The rows. */
    static int rows = 6;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {
        this.player = new Player("player", 'X');
        this.grid = new Grid(GridTest.columns, GridTest.rows);
    }

    /**
     * Test grid.
     */
    @Test
    void testGrid() {
        assertEquals(GridTest.columns, this.grid.getColumns().length);

        for (final Column column : this.grid.getColumns()) {
            assertEquals(GridTest.rows, column.getTiles().length);
        }
    }

    /**
     * Test add token.
     */
    @Test
    void testAddToken() {
        final int columnIndex = 0;

        this.grid.addToken(columnIndex, this.player);
        assertEquals(this.player,
                this.grid.getColumns()[columnIndex]
                        .getTile(this.grid.getColumns()[columnIndex].getIndexEmptyTile() - 1)
                        .getToken().getPlayer());
    }

    /**
     * Test get player from tile.
     */
    @Test
    void testGetPlayerFromTile() {
        final int columnIndex = 0;

        this.grid.addToken(columnIndex, this.player);
        assertEquals(this.player, this.grid.getPlayerFromTile(columnIndex, 0));
    }

}
