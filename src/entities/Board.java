package entities;

public class Board {
	public Tile[][] tiles;
	
	Board() {
		this.tiles = new Tile[6][6];
		this.fillBoard();
	}
	
	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
	}
	
	public void fillBoard(){
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				this.tiles[x][y] = new Tile('q').toggleEnabled();
			}
		}
	}
	
	public Tile getTile(int x, int y){
		return tiles[x][y];
	}
}
