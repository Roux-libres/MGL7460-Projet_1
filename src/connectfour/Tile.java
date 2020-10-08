package connectfour;

public class Tile {
	private Token token;

	public Tile() {}
	
	public Token getToken() {
		return this.token;
	}

	public void setToken(Player player) {
		this.token = new Token(player);
	}
	
	public boolean isEmpty() {
		if(this.getToken() != null) {
			return false;
		} else {
			return true;
		}
	}
}
