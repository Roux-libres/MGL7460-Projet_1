package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import connectfour.Column;
import connectfour.Player;


// TODO: Auto-generated Javadoc
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
    void setUp() throws Exception {
        column = new Column(6);
    }

    /**
     * Test constructor.
     */
    @Test
    void testConstructor() {
        assertEquals(false, column.isFull());
    }

    /**
     * Test get index empty tile.
     */
    @Test
    void testGetIndexEmptyTile() {
        column.addToken(new Player("Jean", 'X'));
        assertEquals(1, column.getIndexEmptyTile());
    }

}
