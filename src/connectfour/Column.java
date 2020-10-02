package connectfour;

public class Column {
	private Tile[] tiles;
	private int indexEmptyTile;
	
	public Column(int size) {
		//TODO
	}
	
	public int getIndexEmptyTile() {
		return this.indexEmptyTile;
	}
	
	public Tile getTile(int index) {
		return this.tiles[index];
	}
	
	public void addToken(Player player) {
		//TODO
	}
	
	private void incrementIndexEmptyTile() {
		this.indexEmptyTile += 1;
	}
	
	public boolean isFull() {
		//TODO
		return false;
	}
}
