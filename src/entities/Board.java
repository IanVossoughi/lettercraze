package entities;

public class Board {
	public Tile[][] tiles;
	Coordinate currentTile;

	public Board() {
		this.tiles = new Tile[6][6];
		this.fillBoard();
		this.currentTile = new Coordinate(-1, -1);
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

	public Coordinate getSelectedTileCoords() {
		return this.currentTile;
	}

	public void setSelectedTileCoords(Coordinate coord) {
		this.currentTile = coord;
	}

	/*
	 * Used for saving the board state. Returns a string representation of the board state.
	 */
	public String serialize(){
		String retStr = "";
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				retStr = retStr + this.getTile(x, y).letter;
			}
		}
		return retStr;
	}
 //TODO: DOESNT WORK AT ALL 
	public boolean moveTilesUp(){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (!this.getTile(x, y).isEnabled()) {
					if(y + 1 > 5){
						return false;
					}
					else{
						Tile tileMovingUp = this.getTile(x, y+1);
						Tile removedTile = this.getTile(x, y);
						
						removedTile = tileMovingUp;
						removedTile.toggleEnabled();
						if(!this.getTile(x+1, y).isEnabled() && !this.getTile(x-1, y).isEnabled() && !this.getTile(x, y+1).isEnabled() && !this.getTile(x, y-1).isEnabled()){
							moveTilesUp();
						}
						return true;	
					}

				}
			}
		}
		return false;
	}
}
