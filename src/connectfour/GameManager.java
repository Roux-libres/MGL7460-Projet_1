package connectfour;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameManager {
	final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	static int DEFAULT_COLUMN_AMOUNT = 7;
	static int DEFAULT_ROW_AMOUNT = 6;
	static int DEFAULT_ALIGNED_TOKEN = 4;
	final Scanner reader;
	private Grid grid;
	private Player[] players;
	private int turnCount;
	private int lastColumnChoosed;
	
	public GameManager() {
		this.reader = new Scanner(System.in);
		this.setGrid(new Grid(GameManager.DEFAULT_COLUMN_AMOUNT, GameManager.DEFAULT_ROW_AMOUNT));
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
			String player_name = this.ManageTextEntry();
			System.out.println("Choose a symbol for player " + Integer.toString(index + 1) + " :");
			char player_symbol = this.ManageTextEntry().charAt(0);
			System.out.println("The player -" + player_name + "- has the symbol \"" + player_symbol + "\" \n");
			this.createPlayer(player_name, player_symbol);
		}
	}
	
	private String ManageTextEntry() {
		String text = this.reader.nextLine();
		while (!Pattern.matches("[a-zA-Z0-9]*", text) || text.length() == 0) {
    	   System.out.println("Missing or incorrect text. Try Again.");
    	   text = this.reader.nextLine();
	    }
		return text;
	}
	
	public void createPlayer(String username, char symbol) {
		if(this.getPlayerByIndex(0) == null) {
			this.players[0] = new Player(username, symbol);
		} else if(this.getPlayerByIndex(1) == null) {
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
			this.setLastColumnChoosed(this.ManageColumnChoosed() - 1);
			while (this.getGrid().getColumn(this.getLastColumnChoosed()).isFull()) {
				System.out.println("This column is full. Please choose another.");
				this.setLastColumnChoosed(this.ManageColumnChoosed() - 1);
			}
			this.getGrid().addToken(this.getLastColumnChoosed(), actualPlayer);
			this.displayGrid();
			this.incrementTurnCount();
			;
		}
		if(this.getGrid().isFull()) {
			System.out.println("Grid is full");
		} else {
			this.displayVictory();
		}
	}
	
	private int ManageColumnChoosed() {
		int columnChoosed = -1;
		while (columnChoosed < 0) {
    	   try {
    		   columnChoosed=this.reader.nextInt();
    		   if (columnChoosed > GameManager.DEFAULT_ROW_AMOUNT + 1 || columnChoosed < 1) {
    			   System.out.println("This column number doesn't exist. Try again:");
    			   columnChoosed = -1;
    		   }
    	   } catch (java.util.InputMismatchException e) {
    		   System.out.println("Please enter a correct column number.");
    	   }
    	   
    	   this.reader.nextLine();
		}
		return columnChoosed;
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
				
				if(alignedTokenCounter == GameManager.DEFAULT_ALIGNED_TOKEN) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isOutOfBound(int x, int y, int vx, int vy) {
		if(x + vx < 0 || x + vx > GameManager.DEFAULT_COLUMN_AMOUNT - 1 || y + vy < 0 || y + vy > GameManager.DEFAULT_ROW_AMOUNT - 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void displayGrid() {
		char[][] table = new char[GameManager.DEFAULT_ROW_AMOUNT * 2 + 1][GameManager.DEFAULT_COLUMN_AMOUNT * 2 + 2];
		
		for(int indexColumn = 0; indexColumn < GameManager.DEFAULT_COLUMN_AMOUNT * 2 + 1; indexColumn++) {
			if(indexColumn % 2 == 0) {
				for(int indexRow = GameManager.DEFAULT_ROW_AMOUNT * 2; indexRow > 0; indexRow--) {
					table[indexRow][indexColumn] = '|';
				}
			} else {
				for(int indexRow = GameManager.DEFAULT_ROW_AMOUNT * 2; indexRow > 0; indexRow--) {
					if(indexRow % 2 == 0) {
						table[indexRow][indexColumn] = '—';
					} else {
						table[indexRow][indexColumn] = this.getGrid().getColumn(indexColumn / 2).toString().charAt(indexRow / 2);
					}
				}
			}
			for(int index = 1; index < GameManager.DEFAULT_COLUMN_AMOUNT + 1; index++) {
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
