package connectfour;

public class Player {
	private char symbol;
	private String name;
	
	public Player(String Name, char symbol) {
		this.setName(Name);
		this.setSymbol(symbol);
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
