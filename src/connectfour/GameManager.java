package connectfour;

public class GameManager {
	final int DEFAULT_ALIGNED_TOKEN = 4;
	final int DEFAULT_COLUMN_AMOUNT = 7;
	final int DEFAULT_ROW_AMOUNT = 6;
	final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	private int alignedToken;
	private Player[] players;
	private int turnCount;
	private Grid grid;
	
	public GameManager() {
		//TODO
	}
	
	public void initGame() {
		//TODO
	}
	
	public int getAlignedToken() {
		return alignedToken;
	}

	public void setAlignedToken(int alignedToken) {
		this.alignedToken = alignedToken;
	}

	public void setGrid(int width, int height) {
		this.grid = new Grid(width, height);
	}
	
	public void setPlayers() {
		//TODO
	}
	
	private void createPlayer(String username, char symbol) {
		//TODO
	}
	
	public void playGame() {
		//TODO
	}
	
	public int getTurnCount() {
		return this.turnCount;
	}
	
	private void incrementTurnCount() {
		this.turnCount += 1;
	}
	
	public Grid getGrid() {
		return this.grid;
	}
	
	public Player getPlayerByIndex(int index) {
		//TODO
		return null;
	}
	
	public boolean hasWon(Player player) {
		//TODO
		return false;
	}
	
	public void displayGrid() {
		
	}
	
	public void displayVictory() {
		
	}
}
