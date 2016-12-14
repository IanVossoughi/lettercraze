package controllers;

import entities.Model;
import entities.Word;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestSubmitWordMove extends TestCase {
	Model model1, model2, model3;
	PlayField pf1, pf2, pf3;
	Word word1, word2, word3;
	
	@Override
	public void setUp(){
		model1 = new Model();
		model2 = new Model();
		model3 = new Model();
		pf1 = new PlayField(model1);
		pf2 = new PlayField(model2);
		pf3 = new PlayField(model3);
		

		model1.addThemeWord("computer");
		model1.addThemeWord("mouse");
	}
	
	public void testSubmitWord(){
		
		// Testing word that is in theme
		word1 = new Word("computer", 8);
		model1.setType(2);
		model1.setSelectedWord(word1);
		SubmitWordMove swm = new SubmitWordMove(model1, pf1, null);
		assertTrue(swm.isValid());
		//assertFalse(swm.doMove());
		
		// Testing word that is not in theme
		word2 = new Word("bake", 3);
		model1.setSelectedWord(word2);
		SubmitWordMove swm2 = new SubmitWordMove(model1, pf1, null);
		assertFalse(swm2.isValid());
		//assertFalse(swm2.doMove());
		
		// Testing puzzle level
		word3 = new Word("test", 5);
		model2.setType(0);
		model2.setSelectedWord(word3);
		SubmitWordMove swm3 = new SubmitWordMove(model2, pf2, null);
		//assertTrue(swm3.isValid());
		//assertTrue(swm3.doMove());	
	}
}
