package controllers;

import playerBoundary.Main;
import junit.framework.TestCase;

public class TestContinueButtonController extends TestCase {
	Main main;
	
	@Override
	protected void setUp() {
		main = new Main();
		main.setVisible(true);
	}
	
	public void testContinueBuilderController() {
		assertTrue(main.isVisible());
		ContinueButtonController cbc = new ContinueButtonController(main);
		cbc.actionPerformed(null);
		assertFalse(main.isVisible());	
	}
	
	
}