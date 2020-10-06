package connectfour;

public class GameManager {
	final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	private int alignedToken;
	private Player[] players;
	private int turnCount;
	private Grid grid;
	
	public GameManager() {
		this.players = new Player[2];
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
	
	public void createPlayer(String username, char symbol) {
		if(!(this.getPlayerByIndex(0) instanceof Player)) {
			this.players[0] = new Player(username, symbol);
		} else if(!(this.getPlayerByIndex(1) instanceof Player)) {
			this.players[1] = new Player(username, symbol);
		} else {
			System.out.println("Two players already exists");
		}
	}
	
	public void playGame() {
		//TODO
	}
	
	public int getTurnCount() {
		return this.turnCount;
	}
	
	public void incrementTurnCount() {
		this.turnCount += 1;
	}
	
	public Grid getGrid() {
		return this.grid;
	}
	
	public Player getPlayerByIndex(int index) {
		return this.players[index];
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
