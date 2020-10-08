package connectfour;

// TODO: Auto-generated Javadoc
/**
 * The Class Token.
 */
public class Token {
    private Player player;

    /**
     * Instantiates a new token.
     *
     * @param player the player
     */
    public Token(Player player) {
        this.setPlayer(player);
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the player.
     *
     * @param player the new player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
