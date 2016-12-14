package entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	int x;
	int y;
	Model m;
	Tile tile;
	Tile tile2;
	Board b;
	Coordinate coords;
	
	@Override
	protected void setUp() {
		x = 1;
		y = 1;
		
		m = new Model();
		b = new Board();
		tile = m.getBoard().getTile(x, y);
		tile.setSelection(true);
	}
	
	public void testTile() {
		
		// Testing toggleSelected()
		assertTrue(tile.isSelected());
		tile.toggleSelected();
		assertFalse(tile.isSelected());
		
		tile.toggleSelected();
		assertTrue(tile.isSelected());
		
		// Testing tile location on board
		b.setTile(2, 2, tile2);
		assertEquals(tile2, b.getTile(2, 2));
		
		// Testing tile coordinates
		coords = new Coordinate(3, 3);
		b.setSelectedTileCoords(coords);
		assertEquals(coords, b.getSelectedTileCoords());
		
		// Testing enabling and replacing
		tile.setEnabled(true);
		tile.setReplacement(true);
		assertTrue(tile.getReplacement());
		assertTrue(tile.isEnabled());
		
		tile.setEnabled(false);
		tile.setReplacement(false);
		assertFalse(tile.getReplacement());
		assertFalse(tile.isEnabled());	
		
	}
}
