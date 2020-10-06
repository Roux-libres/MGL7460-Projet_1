package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connectfour.Column;
import connectfour.Player;

class ColumnTest {
	Column column;

	@BeforeEach
	void setUp() throws Exception {
		column = new Column(6);
	}
	
	@Test
	void testConstructor() {
		assertEquals(false, column.isFull());
	}
	
	@Test
	void testGetIndexEmptyTile() {
		column.addToken(new Player("Jean", 'X'));
		assertEquals(1, column.getIndexEmptyTile());
	}

}
