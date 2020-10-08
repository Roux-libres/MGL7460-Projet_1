package connectfour;

// TODO: Auto-generated Javadoc
/**
 * The Class Tile.
 */
public class Tile {
    private Token token;

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
        return this.getToken() == null;
    }
}
