package controllers;

import junit.framework.TestCase;
import playerBoundary.MenuField;

public class TestExitButtonController extends TestCase {
	MenuField menuField;
	
	@Override
	protected void setUp() {
		menuField = new MenuField();
		menuField.setVisible(true);
	}
	
	public void testExitBuilderController() {
		assertTrue(menuField.isVisible());
		ExitButtonController ebc = new ExitButtonController(menuField);
		ebc.actionPerformed(null);
		assertFalse(menuField.isVisible());	
	}
}
	
	