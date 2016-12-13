package controllers;

import builderBoundary.BuildField;
import entities.Model;
import junit.framework.TestCase;

public class TestRemoveButtonController extends TestCase {

	BuildField buildField;
	Model model;

	@Override
	protected void setUp() {
		buildField = new BuildField();
		model = new Model();
		buildField.setVisible(true);
	}

	public void testRemoveButton() {
		RemoveButtonController abc = new RemoveButtonController(buildField, model);
		abc.actionPerformed(null);
		String eF = buildField.getWordEntry();
		assertEquals("",eF);	
	}
}