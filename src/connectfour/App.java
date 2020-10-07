package connectfour;

public class App {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		gm.initGame();
		gm.playGame();
	}
}
