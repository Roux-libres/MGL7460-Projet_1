package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import connectfour.Column;
import connectfour.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Class ColumnTest.
 */
class ColumnTest {

    /** The column. */
    Column column;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() {
        this.column = new Column(6);
    }

    /**
     * Test constructor.
     */
    @Test
    void testConstructor() {
        assertFalse(this.column.isFull());
    }

    /**
     * Test get index empty tile.
     */
    @Test
    void testGetIndexEmptyTile() {
        this.column.addToken(new Player("Jean", 'X'));
        assertEquals(1, this.column.getIndexEmptyTile());
    }

}
