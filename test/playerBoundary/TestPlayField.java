package playerBoundary;

import entities.Model;
import junit.framework.TestCase;

public class TestPlayField extends TestCase {
	PlayField pf;
	Model m;
	
	@Override
	protected void setUp() {
		m = new Model();
		pf = new PlayField(m);
		
		pf.setVisible(true);
		pf.setModel(m);
	}

	public void testPlayField(){
		assertTrue(pf.isVisible());
		pf.gameOver();
		assertFalse(pf.isVisible());
		
		pf.refreshBoardUndo(m);
	}
}