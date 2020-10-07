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
		if(!this.getColumn(column).getTile(row).isEmpty()) {
			return this.getColumn(column).getTile(row).getToken().getPlayer();
		} else {
			return null;
		}
	}

	public Column[] getColumns() {
		return this.columns;
	}

	public Column getColumn(int columnIndex) {
		return this.columns[columnIndex];
	}
	
	public boolean isFull() {
		for(Column column : this.getColumns()) {
			if(!column.isFull()) {
				return false;
			}
		}
		return true;
	}
}
