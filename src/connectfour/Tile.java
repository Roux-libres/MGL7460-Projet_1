package connectfour;

public class Tile {
	private Token token;

	public Tile() {
		//TODO
	}
	
	public Token getToken() {
		return token;
	}

	public void setToken(Player player) {
		this.token = new Token(player);
	}
	
	public boolean isEmpty() {
		if(this.getToken() instanceof Token) {
			return false;
		} else {
			return true;
		}
	}
}
