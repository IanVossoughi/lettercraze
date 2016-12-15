package controllers;

import entities.Model;
import entities.Tile;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestPlayerClickTileController extends TestCase {
	int x;
	int y;
	PlayField pf;
	Model m;
	Tile tile;

	@Override
	protected void setUp() {
		m = new Model();
		pf = new PlayField(m);
		x = 1;
		y = 1;
		tile = m.getBoard().getTile(x, y);
		tile.setLetter("Q");
	}

	public void testPlayerClickTile() {
		PlayerClickTileController pct = new PlayerClickTileController(m, pf, x, y);
		pct.actionPerformed(null);
		
		assertEquals("QU", m.getBoard().getTile(x, y).getLetter());
		
	}
}
