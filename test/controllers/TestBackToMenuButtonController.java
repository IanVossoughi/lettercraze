package controllers;


import javax.swing.JButton;

import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestBackToMenuButtonController extends TestCase {
	PlayField pf;
	@Override
	protected void setUp() {
		pf = new PlayField();
		pf.setVisible(true);

	}
	@Override
	protected void tearDown() {
		pf.dispose();
	}
	
	
	public void testBTMC(){
		//setUp();
		assertTrue(pf.isVisible());
		BackToMenuButtonController btmb = new BackToMenuButtonController(pf);
		//JButton eButton = new JButton("Exit Level");
		//eButton.addActionListener(btmb);
		
		// simulates the click on the button
		btmb.actionPerformed(null);

		//eButton.doClick();
		assertFalse(pf.isVisible());
	}
}
