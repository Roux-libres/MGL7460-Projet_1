package connectfour;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {
    private char symbol;
    private String name;

    /**
     * Instantiates a new player.
     *
     * @param Name the name
     * @param symbol the symbol
     */
    public Player(String name, char symbol) {
        this.setName(name);
        this.setSymbol(symbol);
    }

    /**
     * Gets the symbol.
     *
     * @return the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the symbol.
     *
     * @param symbol the new symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
