package controllers;

import builderBoundary.BuildField;
import builderBoundary.StarThresholdWindow;
import entities.Model;
import junit.framework.TestCase;

public class TestAddButtonController extends TestCase {
	BuildField buildField;
	Model model;
	
	@Override
	protected void setUp() {
		buildField = new BuildField();
		model =new Model();
		buildField.setVisible(true);
	}
	
	public void testAddButton() {
		AddButtonController abc = new AddButtonController(buildField, model);
		abc.actionPerformed(null);
		String eF = buildField.getWordEntry();
		assertEquals("", eF);	
	}
	
	
}
