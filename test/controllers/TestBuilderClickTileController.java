package controllers;

import junit.framework.TestCase;
import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;

public class TestBuilderClickTileController extends TestCase {
	int x;
	int y;
	BuildField b;
	Model m;
	Tile tile;
	
	@Override
	protected void setUp() {
		b = new BuildField();
		m = new Model();
		x = 1;
		y = 1;
		
		tile = m.getBoard().getTile(x, y);
	}
	
	public void testBuilderClickTile() {
		BuilderClickTileController ect = new BuilderClickTileController(m, b, x, y);
		ect.actionPerformed(null);
		assertFalse(tile.isEnabled());
	}
}
	
	
