package connectfour;

public class Column {
	private Tile[] tiles;
	private int indexEmptyTile;
	
	public Column(int size) {
		this.tiles = new Tile[size];
		for(int index = 0; index < size; index++) {
			this.tiles[index] = new Tile();
		}
		this.indexEmptyTile = 0;
	}
	
	public int getIndexEmptyTile() {
		return this.indexEmptyTile;
	}
	
	public Tile getTile(int index) {
		return this.tiles[index];
	}
	
	public Tile[] getTiles() {
		return this.tiles;
	}
	
	public void addToken(Player player) {
		if(!this.isFull()) {
			this.getTile(this.getIndexEmptyTile()).setToken(player);
			this.incrementIndexEmptyTile();
		}
	}
	
	private void incrementIndexEmptyTile() {
		this.indexEmptyTile += 1;
	}
	
	public boolean isFull() {
		if(this.getIndexEmptyTile() + 1 == this.tiles.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Tile tile : this.getTiles()) {
			if(tile.isEmpty()) {
				result.append(' ');
			} else {
				result.append(tile.getToken().getPlayer().getSymbol());
			}
		}
		return result.toString();
	}
}
