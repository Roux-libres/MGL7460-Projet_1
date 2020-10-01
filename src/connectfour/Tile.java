package connectfour;

public class Tile {
	private Token token;

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	
	public boolean isEmpty() {
		if(this.getToken() instanceof Token) {
			return false;
		} else {
			return true;
		}
	}
	
	public String toString() {
		if(!this.isEmpty()) {
			return "" + this.getToken().getSymbol();
		} else {
			return "";
		}
	}
}
