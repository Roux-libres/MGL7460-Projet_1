package connectfour;

// TODO: Auto-generated Javadoc
/**
 * The Class Tile.
 */
public class Tile {
    private Token token;

    /**
     * Instantiates a new tile.
     */
    public Tile() {}

    /**
     * Gets the token.
     *
     * @return the token
     */
    public Token getToken() {
        return this.token;
    }

    /**
     * Sets the token.
     *
     * @param player the new token
     */
    public void setToken(Player player) {
        this.token = new Token(player);
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        if (this.getToken() != null) {
            return false;
        } else {
            return true;
        }
    }
}
