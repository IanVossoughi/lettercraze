package entities;

public class Board {
	public Tile[][] tiles;
	Coordinate currentTile;

	public Board() {
		this.tiles = new Tile[6][6];
		this.fillBoard();
		this.currentTile = new Coordinate(-1, -1);
	}
	
	public void printBoard(){
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				System.out.print(tiles[x][y].getLetter());
			}
			System.out.println();
		}
	}

	public void setTiles(Tile[][] tiles){
		this.tiles = tiles;
	}

	public void fillBoard(){
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				this.tiles[x][y] = new Tile("_").toggleEnabled();
				this.tiles[x][y].setLetter(tiles[x][y].randomLetterFrequency());
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
 
	
	public void floatUpTiles(int type){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				int i = x + 1;
				while(this.getTile(x,y).isEnabled() && this.getTile(x, y).getReplacement()) {
					if (i >= 6) {
						if (type == 2) {
							this.getTile(x, y).setEnabled(false);
						}
						else {
							this.getTile(x, y).setLetter(this.getTile(x,y).randomLetterFrequency());
						}
						this.getTile(x, y).setReplacement(false);
						break;
					}
					if (this.getTile(i, y).isEnabled() && !this.getTile(i, y).getReplacement()) {
						this.getTile(x,y).setLetter(this.getTile(i, y).getLetter());
						this.getTile(x, y).setReplacement(false);
						this.getTile(i, y).setReplacement(true);
						break;
					}
					i++;
				}
			}
		}
	}

	public void setTile(int x, int y, Tile newTile) {
		this.tiles[x][y] = newTile;
		
	}
}
