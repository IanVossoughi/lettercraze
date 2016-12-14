package controllers;

import javax.swing.JButton;

import builderBoundary.BuildField;
import builderBoundary.StarThresholdWindow;
import entities.Model;
import junit.framework.TestCase;

public class TestAddButtonController extends TestCase {
	BuildField buildField;
	Model model;
	JButton tempButton;
	
	@Override
	protected void setUp() {
		buildField = new BuildField();
		model = new Model();
		buildField.setVisible(true);
		tempButton = buildField.getRemoveButton();
		
		tempButton.setEnabled(false);
	}
	
	public void testAddButton() {
		
		//Testing empty list
		AddButtonController abc = new AddButtonController(buildField, model);
		abc.actionPerformed(null);
		String eF = buildField.getWordEntry();
		assertEquals("", eF);	
		assertFalse(tempButton.isEnabled());
		
		// Testing list of one word
		buildField.setWordEntry("TEST");
		AddButtonController word = new AddButtonController(buildField, model);
		word.actionPerformed(null);
		assertTrue(tempButton.isEnabled());
	}
}
