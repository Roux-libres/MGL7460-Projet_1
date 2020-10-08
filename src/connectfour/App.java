package connectfour;

/**
 * The Class App.
 */
public class App {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.initGame();
        gm.playGame();
    }
}
