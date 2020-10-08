package connectfour;

// TODO: Auto-generated Javadoc
/**
 * The Class Column.
 */
public class Column {
    private final Tile[] tiles;
    private int indexEmptyTile;

    /**
     * Instantiates a new column.
     *
     * @param size the size
     */
    public Column(int size) {
        this.tiles = new Tile[size];
        for (int index = 0; index < size; index++) {
            this.tiles[index] = new Tile();
        }
        this.indexEmptyTile = 0;
    }

    /**
     * Gets the index empty tile.
     *
     * @return the index empty tile
     */
    public int getIndexEmptyTile() {
        return this.indexEmptyTile;
    }

    /**
     * Gets the tile.
     *
     * @param index the index
     * @return the tile
     */
    public Tile getTile(int index) {
        return this.tiles[index];
    }

    /**
     * Gets the tiles.
     *
     * @return the tiles
     */
    public Tile[] getTiles() {
        return this.tiles.clone();
    }

    /**
     * Adds the token.
     *
     * @param player the player
     */
    public void addToken(Player player) {
        if (!this.isFull()) {
            this.getTile(this.getIndexEmptyTile()).setToken(player);
            this.incrementIndexEmptyTile();
        }
    }

    private void incrementIndexEmptyTile() {
        this.indexEmptyTile += 1;
    }

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        if (this.getIndexEmptyTile() == this.tiles.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final Tile tile : this.getTiles()) {
            if (tile.isEmpty()) {
                result.append(' ');
            } else {
                result.append(tile.getToken().getPlayer().getSymbol());
            }
        }
        return result.toString();
    }
}
