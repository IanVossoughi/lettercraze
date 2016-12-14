package controllers;


import java.util.Timer;

import javax.swing.JButton;

import entities.Model;
import junit.framework.TestCase;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class TestBackToMenuButtonController extends TestCase {
	PlayField pf;
	Model m;

	@Override
	protected void setUp() {
		m = new Model();
		pf = new PlayField(m);
		pf.setVisible(true);
		
		m.setType(1);
		pf.hasTimer();
	
	}
	
	public void testBackToMenuButton(){
		assertTrue(pf.isVisible());
		BackToMenuButtonController btmb = new BackToMenuButtonController(pf,m);
		
		btmb.actionPerformed(null);
		assertFalse(pf.isVisible());
	}
}
