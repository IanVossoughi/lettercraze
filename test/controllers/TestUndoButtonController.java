package controllers;

import entities.Model;
import general.UndoArray;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestUndoButtonController extends TestCase {
	PlayField playField;
	Model m;
	UndoArray undoArray;
	int index;

	@Override
	protected void setUp() {
		m = new Model();
		m.setType(1);
		index = m.getSelectedIndex();
		playField = new PlayField(m);
		playField.setVisible(true);
	}

	public void testUndoButton() {
		UndoButtonController ubc = new UndoButtonController(m, playField, undoArray);
		ubc.actionPerformed(null);
		UndoArray ua = undoArray.getInstance();
		
		assertEquals(-1, ua.getIndex());
		assertTrue(ua.addUndoModel(m));
		assertEquals(0, ua.getIndex());
		assertTrue(ua.removeUndoModel());
		assertEquals(-1, ua.getIndex());
	}
}