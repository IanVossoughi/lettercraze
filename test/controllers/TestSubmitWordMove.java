package controllers;

import javax.swing.JLabel;

import entities.Model;
import entities.Word;
import junit.framework.TestCase;
import playerBoundary.PlayField;

public class TestSubmitWordMove extends TestCase {
	Model model1, model2, model3;
	PlayField pf1, pf2, pf3;
	Word word1, word2, word3;
	JLabel star1,star2,star3;
	@Override
	public void setUp(){
		model1 = new Model();
		model2 = new Model();
		model3 = new Model();
		pf1 = new PlayField(model1);
		pf2 = new PlayField(model2);
		pf3 = new PlayField(model3);
		pf2.setVisible(true);
		pf1.setVisible(true);
		pf3.setVisible(true);
		
		star1 = new JLabel("");
		star2 = new JLabel("");
		star3 = new JLabel("");
		
		model1.addThemeWord("computer");
		model1.addThemeWord("mouse");
	}
	
	public void testSubmitWord(){
		
		
		// Testing word that is in theme
		word1 = new Word("computer", 8);
		model1.setType(2);
		model1.setSelectedWord(word1);
		int scoreBefore = model1.getScore().getScoreValue();
		SubmitButtonController sbc = new SubmitButtonController(model1,pf1,star1,star2,star3);
		SubmitWordMove swm = new SubmitWordMove(model1, pf1, sbc);
		assertTrue(swm.isValid());
		swm.doMove();
		int scoreAfter =model1.getScore().getScoreValue();
		//because it is a theme level updates the score by 1 for each word
		assertEquals(1,scoreAfter - scoreBefore);
		swm.undoMove();
		scoreAfter =model1.getScore().getScoreValue();
		assertEquals(0, scoreAfter - scoreBefore);
		
		
		// Testing word that is not in theme
		word2 = new Word("bake", 3);
		model1.setSelectedWord(word2);
		SubmitButtonController sbc2 = new SubmitButtonController(model1,pf2,star1,star2,star3);

		SubmitWordMove swm2 = new SubmitWordMove(model1, pf1, sbc2);
		assertFalse(swm2.isValid());
		
		// Testing puzzle level
		word3 = new Word("test", 5);
		model2.setType(1);
		model2.setSelectedWord(word3);
		scoreBefore = model2.getScore().getScoreValue();

		SubmitButtonController sbc3 = new SubmitButtonController(model2,pf3,star1,star2,star3);

		SubmitWordMove swm3 = new SubmitWordMove(model2, pf2, sbc3);
		assertTrue(swm3.isValid());	
		swm3.doMove();
		swm3.undoMove();
		
		
		//swm3.undoMove();
	}
}
