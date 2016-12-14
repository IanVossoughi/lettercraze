package controllers;


import javax.swing.JButton;

import entities.Model;
import junit.framework.TestCase;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class TestBackToMenuButtonController extends TestCase {
	PlayField pf;

	@Override
	protected void setUp() {
		Model m = new Model();
		pf = new PlayField(m);
		pf.setVisible(true);

	}
	
	@Override
	protected void tearDown() {
		pf.dispose();
	}
	
	
	public void testBTMBC(){
		assertTrue(pf.isVisible());
		BackToMenuButtonController btmb = new BackToMenuButtonController(pf);
		btmb.actionPerformed(null);
		assertFalse(pf.isVisible());
	}
}
