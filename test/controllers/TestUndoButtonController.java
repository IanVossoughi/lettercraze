package controllers;

import entities.Model;
import general.UndoArray;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestUndoButtonController extends TestCase {
	PlayField playField;
	Model model;
	UndoArray undoArray;

	@Override
	protected void setUp() {
		model = new Model();
		playField = new PlayField(model);
		playField.setVisible(true);
	}

	public void testUndoButton() {
		UndoButtonController ubc = new UndoButtonController(model, playField, undoArray);
		/*
		ubc.actionPerformed(null);
		int size = model.getWordListModel().getSize();
		assertEquals(0, size);
		*/	
	}
}