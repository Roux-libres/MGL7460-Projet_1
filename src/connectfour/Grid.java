package connectfour;

public class Grid {
	private int columnAmount;
	private int rowAmount;
	private int emptyTilesAmount;
	private Column[] grid;
	private int defaultColumnAmount = 7;
	private int defaultRowAmount = 6;
	private int defaultEmptyTilesAmount = defaultColumnAmount * defaultRowAmount;
	private int lastTokenColumnIndex = 0;
	private int lastTokenRowIndex = 0;
	
	public Grid() {
		
	}
	
	public Grid(int columnAmount, int rowAmount) {
		// TODO
	}
	
	public int getColumnAmount() {
		return this.columnAmount;
	}

	public int getRowAmount() {
		return this.rowAmount;
	}

	public int getEmptyTilesAmount() {
		return this.emptyTilesAmount;
	}

	public int getLastTokenColumnIndex() {
		return this.lastTokenColumnIndex;
	}

	public int getLastTokenRowIndex() {
		return this.lastTokenRowIndex;
	}
	
	public void resetGrid() {
		
	}
	
	private void initGrid() {
		
	}
	
	public void addToken(int columnIndex, Token token) {
		
	}
	
	public boolean hasWon(Player player) {
		return false;
	}
}
