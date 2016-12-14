package controllers;

import entities.Model;
import general.UndoArray;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestUndoButtonController extends TestCase {
	PlayField playField;
	Model m;
	UndoArray undoArray;

	@Override
	protected void setUp() {
		m = new Model();
		playField = new PlayField(m);
		playField.setVisible(true);
	}

	public void testUndoButton() {
		UndoButtonController ubc = new UndoButtonController(m, playField, undoArray);
		/*
		ubc.actionPerformed(null);
		int size = m.getWordListModel().getSize();
		assertEquals(0, size);
			
		assertEquals("", undoArray.getLatestModel());
		assertEquals(0, undoArray.getIndex());
		assertTrue(undoArray.removeUndoModel());
		*/
	}
}