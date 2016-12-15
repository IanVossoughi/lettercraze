package controllers;

import entities.Model;
import entities.Tile;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestPlayerClickTileController extends TestCase {
	int x, x1;
	int y, y1;
	PlayField pf;
	Model m;
	Tile tile, tile2;

	@Override
	protected void setUp() {
		m = new Model();
		pf = new PlayField(m);
		
		x = 1;
		y = 1;
		tile = m.getBoard().getTile(x, y);
		tile.setLetter("Q");
		
		x1 = 2;
		y1 = 2;
		tile = m.getBoard().getTile(x1, y1);
		tile.setLetter("U");
	}

	public void testPlayerClickTile() {
		
		// Testing Q becomes QU
		PlayerClickTileController pct = new PlayerClickTileController(m, pf, x, y);
		pct.actionPerformed(null);
		assertEquals("QU", m.getBoard().getTile(x, y).getLetter());
		
		// Testing other letter
		PlayerClickTileController pct1 = new PlayerClickTileController(m, pf, x1, y1);
		pct1.actionPerformed(null);
		assertEquals("U", m.getBoard().getTile(x1, y1).getLetter());
	}
}
