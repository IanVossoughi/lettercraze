package controllers;

import entities.Model;
import entities.Word;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestSubmitWordMove extends TestCase {
	Model model;
	PlayField playField;
	Word sW, sW2;
	
	@Override
	public void setUp(){
		model = new Model();
		playField = new PlayField(model);
		
	}
	public void testSubmitWord(){
		sW = new Word("computer", 8);
		model.setSelectedWord(sW);
		SubmitWordMove swm = new SubmitWordMove(model, playField, null);
		assertTrue(swm.isValid());
		assertTrue(swm.doMove());
		
		sW2 = new Word("asdasd", 6);
		model.setSelectedWord(sW2);
		SubmitWordMove swm2 = new SubmitWordMove(model, playField, null);
		assertFalse(swm.isValid());
		assertFalse(swm.doMove());
	}
}
