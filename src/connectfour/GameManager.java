package connectfour;

import java.util.Scanner;

public class GameManager {
	final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	final int DEFAULT_COLUMN_AMOUNT = 7;
	final int DEFAULT_ROW_AMOUNT = 6;
	final int DEFAULT_ALIGNED_TOKEN = 4;
	final Scanner reader;
	private Grid grid;
	private Player[] players;
	private int turnCount;
	private int lastColumnChoosed;
	
	public GameManager() {
		this.reader = new Scanner(System.in);
		this.setGrid(new Grid(this.DEFAULT_COLUMN_AMOUNT, this.DEFAULT_ROW_AMOUNT));
		this.players = new Player[2];
	}
	
	public void initGame() {
		this.setPlayers();
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	public void setPlayers() {
		for(int index = 0; index < 2; index ++) {
			System.out.println("Choose a name for player " + Integer.toString(index + 1) + " :");
			String player_name = this.reader.nextLine();
			System.out.println("Choose a symbol for player " + Integer.toString(index + 1) + " :");
			char player_symbol = this.reader.nextLine().charAt(0);
			this.createPlayer(player_name, player_symbol);
		}
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
		Player actualPlayer = this.getPlayerByIndex(0);
		this.displayGrid();
		while(!this.hasWon(actualPlayer) && !this.getGrid().isFull()) {
			actualPlayer = this.getPlayerByIndex(this.getTurnCount() % 2);
			System.out.println("It's the turn of " + actualPlayer.getName() + "\nChoose a column number : ");
			this.setLastColumnChoosed(this.reader.nextInt() - 1);
			this.getGrid().addToken(this.getLastColumnChoosed(), actualPlayer);
			this.displayGrid();
			this.incrementTurnCount();
		}
		if(this.getGrid().isFull()) {
			System.out.println("Grid is full");
		} else {
			this.displayVictory();
		}
	}
	
	public int getLastColumnChoosed() {
		return lastColumnChoosed;
	}

	public void setLastColumnChoosed(int lastColumnChoosed) {
		this.lastColumnChoosed = lastColumnChoosed;
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
		int row = ((this.getGrid().getColumn(this.getLastColumnChoosed()).getIndexEmptyTile() == 0) ? 0 : this.getGrid().getColumn(this.getLastColumnChoosed()).getIndexEmptyTile() - 1);
		
		int alignedTokenCounter = 1;
		for(int[] direction : this.DIRECTIONS) {
			if(!this.isOutOfBound(this.getLastColumnChoosed(), row, direction[0] * 3, direction[1] * 3)) {
				for(int index = 1; index < 4; index++) {
					if(this.getGrid().getPlayerFromTile(this.getLastColumnChoosed() + direction[0] * index, row + direction[1] * index) == player) {
						alignedTokenCounter++;
					} else {
						alignedTokenCounter = 1;
						break;
					}
				}
				
				if(alignedTokenCounter == this.DEFAULT_ALIGNED_TOKEN) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isOutOfBound(int x, int y, int vx, int vy) {
		if(x + vx < 0 || x + vx > this.DEFAULT_COLUMN_AMOUNT - 1 || y + vy < 0 || y + vy > this.DEFAULT_ROW_AMOUNT - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayGrid() {
		char[][] table = new char[this.DEFAULT_ROW_AMOUNT * 2 + 1][this.DEFAULT_COLUMN_AMOUNT * 2 + 2];
		
		for(int indexColumn = 0; indexColumn < this.DEFAULT_COLUMN_AMOUNT * 2 + 1; indexColumn++) {
			if(indexColumn % 2 == 0) {
				for(int indexRow = this.DEFAULT_ROW_AMOUNT * 2; indexRow > 0; indexRow--) {
					table[indexRow][indexColumn] = '|';
				}
			} else {
				for(int indexRow = this.DEFAULT_ROW_AMOUNT * 2; indexRow > 0; indexRow--) {
					if(indexRow % 2 == 0) {
						table[indexRow][indexColumn] = '—';
					} else {
						table[indexRow][indexColumn] = this.getGrid().getColumn(indexColumn / 2).toString().charAt(indexRow / 2);
					}
				}
			}
			for(int index = 1; index < this.DEFAULT_COLUMN_AMOUNT + 1; index++) {
				table[0][index * 2 - 1] = Integer.toString(index).charAt(0);
			}
		}
		
		for(int index = 0; index < table.length / 2; index++) {
		    char[] temp = table[index];
		    table[index] = table[table.length - index - 1];
		    table[table.length - index - 1] = temp;
		}
		
		for(char[] line : table) {
			System.out.println(new String(line));
		}
	}
	
	public void displayVictory() {
		System.out.println("\nAND THE WINNER IS " + this.getPlayerByIndex((this.getTurnCount() - 1) % 2).getName().toUpperCase());
		System.out.println("Number of turns : " + Integer.toString(this.getTurnCount()));
	}
}
