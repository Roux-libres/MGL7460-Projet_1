package connectfour;

public class GameManager {
	private int defaultPlayersAmount = 2;
	private int defaultWinCondition = 4;
	private int defaultGamesAmount = 1;
	private int playerAmount;
	private int winCondition;
	private int gamesAmount;
	private int remainingGamesAmount;
	private Player[] players;
	private int actualPlayerIndex;
	private Player actualPlayer;
	private Grid grid;
	
	public GameManager() {
		//TODO
	}
	
	public int getPlayerAmount() {
		return this.playerAmount;
	}

	public void setPlayerAmount(int playerAmount) {
		this.playerAmount = playerAmount;
	}

	public int getWinCondition() {
		return this.winCondition;
	}

	public void setWinCondition(int winCondition) {
		this.winCondition = winCondition;
	}

	public int getGamesAmount() {
		return this.gamesAmount;
	}

	public void setGamesAmount(int gamesAmount) {
		this.gamesAmount = gamesAmount;
	}

	public Grid getGrid() {
		return this.grid;
	}

	public void setGrid(int columnAmount, int rowAmount) {
		this.grid = new Grid(columnAmount, rowAmount);
	}

	public int getRemainingGamesAmount() {
		return this.remainingGamesAmount;
	}

	public int getActualPlayerIndex() {
		return this.actualPlayerIndex;
	}

	public void setActualPlayer(int playerIndex) {
		this.actualPlayer = this.getPlayer(playerIndex);
	}

	public int getGameNumber() {
		return this.gamesAmount - this.remainingGamesAmount + 1;
	}
	
	public String getActualPlayerName() {
		return this.getPlayer(this.getActualPlayerIndex()).getName();
	}
	
	public char getActualPlayerSymbol() {
		return this.getPlayer(this.getActualPlayerIndex()).getSymbol();
	}
	
	public Player getPlayer(int index) {
		return this.players[index];
	}
}
