package entities;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	int x;
	int y;
	Model m;
	Tile tile;
	
	@Override
	protected void setUp() {
		x = 1;
		y = 1;
		
		m = new Model();
		tile = m.getBoard().getTile(x, y);
		tile.setSelection(true);
	}
	
	public void testToggleSelection() {
		assertTrue(tile.isSelected());
		tile.toggleSelected();
		assertFalse(tile.isSelected());
		
		tile.toggleSelected();
		assertTrue(tile.isSelected());
	}
}
