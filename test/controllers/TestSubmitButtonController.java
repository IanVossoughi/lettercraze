package controllers;

import playerBoundary.MenuField;
import playerBoundary.PlayField;
import entities.Model;
import junit.framework.TestCase;

public class TestSubmitButtonController extends TestCase {
	PlayField playField;
	Model model;
	
	@Override
	protected void setUp() {
		model = new Model();
		playField = new PlayField(model);
		playField.setVisible(true);
		
		model.setType(2);
	}
	
	public void testSubmitButton() {
		SubmitButtonController abc = new SubmitButtonController(model, playField, null, null, null);
		abc.actionPerformed(null);
		int size = model.getWordListModel().getSize();
		assertEquals(0, size);	
	}
}