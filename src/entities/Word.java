package entities;

/**
 *  The word created from tiles in the level.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class Word {

	/** The letters of the word. */
	String chars;
	/** The score the word provides. */
	int score;
	
	/**
	 * Word constructor comment.
	 */
	public Word(String chars, int score) {
		this.chars = chars;
		this.score = score;
	}
	
	/** Adds word score. Changes depending on level type. */
	public void addScore() {
		int wordScore = 0;
		int letterScore = 0;
		for (int i = 0; i < chars.length(); i++) {
			char letter = chars.charAt(i);
			if ((letter == 'E') || (letter == 'T')){
				letterScore = 1;
			}
			else if ((letter == 'A') || (letter == 'O') || (letter == 'I') || (letter == 'N')
					|| (letter == 'S') || (letter == 'H') || (letter == 'R')){
				letterScore = 2;
			}
			else if ((letter == 'D') || (letter == 'L') || (letter == 'C') || (letter == 'U')
					|| (letter == 'M') || (letter == 'W')){
				letterScore = 3;
			}
			else if ((letter == 'F') || (letter == 'G') || (letter == 'Y') || (letter == 'P')
					|| (letter == 'B')){
				letterScore = 4;
			}
			else if ((letter == 'V') || (letter == 'K')){
				letterScore = 5;
			}
			else if ((letter == 'J') || (letter == 'X')){
				letterScore = 7;
			}
			else if ((letter == 'Q') || (letter == 'Z')){
				letterScore = 8;
			}
			
			wordScore = wordScore + letterScore; //Adds score up for every letter for the word
		}
		
		wordScore = wordScore * (chars.length() - 2); //Score is letters times (length - 2)
		score = score + wordScore;
	}
	
	public String getWordString() {
		return this.chars;
	}
	
	public void setWordString(String chars) {
		this.chars = chars;
	}
	
	public void setScore(int value) {
		this.score = value;
	}
	
	public int getScore(){return score;}
}
