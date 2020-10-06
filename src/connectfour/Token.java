package connectfour;

public class Token {
	private Player player;
	
	public Token(Player player) {
		this.setPlayer(player);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
