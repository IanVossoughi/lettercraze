package controllers;

import junit.framework.TestCase;
import builderBoundary.BuildMain;

public class TestContinueBuilderController extends TestCase {

	BuildMain buildMain;
	
	@Override
	protected void setUp() {
		buildMain = new BuildMain();
		buildMain.setVisible(true);
	}
	
	public void testContinueBuilderController() {
		assertTrue(buildMain.isVisible());
		ContinueBuilderController cbc = new ContinueBuilderController(buildMain);
		cbc.actionPerformed(null);
		assertFalse(buildMain.isVisible());	
	}
	
	
}