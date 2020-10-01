package connectfour;

public class Column {
	private Tile[] column;
	private int columnSize;
	private int indexEmptyTile;
	
	public Column(int size) {
		//TODO
	}
	
	public int getSize() {
		return this.columnSize;
	}
	
	public int getIndexEmptyTile() {
		return this.indexEmptyTile;
	}
	
	public Tile getTile(int index) {
		return this.column[index];
	}
	
	public void addToken(Token token) {
		this.column[this.getIndexEmptyTile()].setToken(token);
	}
	
	public boolean isFull() {
		//TODO
		return false;
	}
}
