package controllers;

import builderBoundary.StarThresholdWindow;
import entities.Model;
import junit.framework.TestCase;

public class TestStarScoreController extends TestCase {

	Model model;
	StarThresholdWindow sw ;
	
	@Override
	protected void setUp() {
		model = new Model();		
		sw = new StarThresholdWindow(model);
		sw.setVisible(true);
		
	}
	
	public void testDataEntry() {
		StarScoreController ssc = new StarScoreController(model, sw);	
		
		sw.getStarField3().setText("10");
		sw.getStarField1().setText("20");
		sw.getStarField2().setText("100");
		
		// do the controller
		ssc.actionPerformed(null);
		
		// assert
		assertFalse (sw.isVisible());
		
		assertEquals (10, model.getScore().starScores[2]);		
		assertEquals (20, model.getScore().starScores[0]);		
		assertEquals (100, model.getScore().starScores[1]);		

	}
}
