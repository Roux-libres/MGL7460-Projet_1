package connectfour;

public class Grid {
	private Column[] columns;

	public Grid(int columnAmount, int rowAmount) {
		this.columns = new Column[columnAmount];
		for(int index = 0; index < columnAmount; index++) {
			this.columns[index] = new Column(rowAmount);
		}
	}

	public void addToken(int columnIndex, Player player) {
		this.getColumns()[columnIndex].addToken(player);
	}

	public Player getPlayerFromTile(int column, int row) {
		return this.getColumns()[column].getTile(row).getToken().getPlayer();
	}

	public Column[] getColumns() {
		return this.columns;
	}

}
