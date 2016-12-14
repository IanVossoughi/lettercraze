package entities;

import junit.framework.TestCase;

public class TestWord extends TestCase {
	Model m;
	String chars;
	int score;
	
	@Override
	protected void setUp() {
		m = new Model();
	}
	
	public void testWord() {
		Word test1 = new Word(chars, score);
		
		// Testing set and get methods
		test1.setWordString("TEST");
		assertEquals("TEST", test1.getWordString());
		test1.setScore(5);
		assertEquals(5, test1.getScore());
		
		// Testing addScore()
		Word test2 = new Word("NUM", score);
		test2.addScore();
		assertEquals(8, test2.getScore());
		
		// Testing adding multiple word scores
		test2.setWordString("TEE");
		test2.addScore();
		assertEquals(11, test2.getScore());
		
		// Testing all letterScores work correctly
		Word test3 = new Word("EADFVJQ", score);
		test3.addScore();
		assertEquals(155, test3.getScore());
	}
}
