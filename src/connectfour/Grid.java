package connectfour;

// TODO: Auto-generated Javadoc
public class Grid {
    private Column[] columns;

    /**
     * Instantiates a new grid.
     *
     * @param columnAmount the column amount
     * @param rowAmount the row amount
     */
    public Grid(int columnAmount, int rowAmount) {
        this.columns = new Column[columnAmount];
        for (int index = 0; index < columnAmount; index++) {
            this.columns[index] = new Column(rowAmount);
        }
    }

    /**
     * Adds the token.
     *
     * @param columnIndex the column index
     * @param player the player
     */
    public void addToken(int columnIndex, Player player) {
        this.getColumns()[columnIndex].addToken(player);
    }

    /**
     * Gets the player from tile.
     *
     * @param column the column
     * @param row the row
     * @return the player from tile
     */
    public Player getPlayerFromTile(int column, int row) {
        if (!this.getColumn(column).getTile(row).isEmpty()) {
            return this.getColumn(column).getTile(row).getToken().getPlayer();
        } else {
            return null;
        }
    }

    /**
     * Gets the columns.
     *
     * @return the columns
     */
    public Column[] getColumns() {
        return this.columns;
    }

    /**
     * Gets the column.
     *
     * @param columnIndex the column index
     * @return the column
     */
    public Column getColumn(int columnIndex) {
        return this.columns[columnIndex];
    }

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        for (Column column : this.getColumns()) {
            if (!column.isFull()) {
                return false;
            }
        }
        return true;
    }
}
