package controllers;

import entities.Model;
import junit.framework.TestCase;
import playerBoundary.MenuField;

public class TestPlayButtonController extends TestCase {
	MenuField menuField;
	Model model;
	
	@Override
	protected void setUp() {
		model = new Model();
		menuField = new MenuField();
		menuField.setVisible(true);
	}
	
	public void testSubmitButton() {
		PlayButtonController abc = new PlayButtonController(menuField, model);
		abc.actionPerformed(null);
		String levelType = menuField.getLevelTypeLabel().getText();
		assertEquals("PUZZLE", levelType);
	}
}