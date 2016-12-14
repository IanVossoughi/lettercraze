package controllers;

import entities.Model;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestUndoMove extends TestCase {
	Model model;
	PlayField playField;
	
	@Override
	protected void setUp() {
		model = new Model();
		playField = new PlayField(model);
	}

	public void testUndoMove() {
	UndoMove undo = new UndoMove(model, playField);
	assertTrue(undo.doMove());
	assertFalse(undo.isValid());
	}
}
