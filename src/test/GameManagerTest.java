package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import connectfour.GameManager;
import connectfour.Grid;
import connectfour.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class GameManagerTest.
 */
class GameManagerTest {

    /** The game manager. */
    GameManager gameManager;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @BeforeEach
    void setUp() throws Exception {
        gameManager = new GameManager();
    }

    /**
     * Test get and set grid.
     */
    @Test
    void testGetAndSetGrid() {
        Grid expectedGrid = new Grid(7, 6);
        this.gameManager.setGrid(expectedGrid);
        assertEquals(expectedGrid, gameManager.getGrid());
    }

    /**
     * Test get turn count.
     */
    @Test
    void testGetTurnCount() {
        final int expectedTurnCount = 3;
        for (int index = 0; index < expectedTurnCount; index++) {
            this.gameManager.incrementTurnCount();
        }
        assertEquals(expectedTurnCount, this.gameManager.getTurnCount());
    }

    /**
     * Test createand get player.
     */
    @Test
    void testCreateandGetPlayer() {
        this.gameManager.createPlayer("Didier", 'x');
        Player player = new Player("Didier", 'x');
        assertEquals(player.getName(), this.gameManager.getPlayerByIndex(0).getName());
        assertEquals(player.getSymbol(), this.gameManager.getPlayerByIndex(0).getSymbol());
    }

    /**
     * Test has won.
     */
    @Test
    void testHasWon() {
        this.gameManager.createPlayer("Philippe", 'O');
        Player player = this.gameManager.getPlayerByIndex(0);
        this.gameManager.setLastColumnChoosed(0);
        assertEquals(false, this.gameManager.hasWon(player));
        for (int index = 0; index < 4; index++) {
            this.gameManager.getGrid().addToken(this.gameManager.getLastColumnChoosed(), player);
        }
        assertEquals(true, this.gameManager.hasWon(player));
    }

    /**
     * Test is out of bound.
     */
    @Test
    void testIsOutOfBound() {
        assertEquals(false, this.gameManager.isOutOfBound(0, 0, 3, 3));
        assertEquals(true, this.gameManager.isOutOfBound(0, 0, -3, -3));
    }

}
