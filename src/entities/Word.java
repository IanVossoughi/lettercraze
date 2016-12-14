package entities;

public class Word {

	String chars;
	int score;
	
	public Word(String chars, int score) {
		this.chars = chars;
		this.score = score;
	}
	
	public void addScore() {
		int wordScore = 0;
		int letterScore = 0;
		for (int i = 0; i < chars.length(); i++) {
			char letter = chars.charAt(i);
			System.out.println(letter);
			if ((letter == 'E') || (letter == 'T')){
				letterScore = 1;
				System.out.println(letterScore);
			}
			else if ((letter == 'A') || (letter == 'O') || (letter == 'I') || (letter == 'N')
					|| (letter == 'S') || (letter == 'H') || (letter == 'R')){
				letterScore = 2;
				System.out.println(letterScore);
			}
			else if ((letter == 'D') || (letter == 'L') || (letter == 'C') || (letter == 'U')
					|| (letter == 'M') || (letter == 'W')){
				letterScore = 3;
				System.out.println(letterScore);
			}
			else if ((letter == 'F') || (letter == 'G') || (letter == 'Y') || (letter == 'P')
					|| (letter == 'B')){
				letterScore = 4;
				System.out.println(letterScore);
			}
			else if ((letter == 'V') || (letter == 'K')){
				letterScore = 5;
				System.out.println(letterScore);
			}
			else if ((letter == 'J') || (letter == 'X')){
				letterScore = 7;
				System.out.println(letterScore);
			}
			else if ((letter == 'Q') || (letter == 'Z')){
				letterScore = 9;
				System.out.println(letterScore);
			}
			wordScore = wordScore + letterScore; //Adds score up for every letter for the word
			System.out.println(wordScore);
		}
		System.out.println(chars.length());
		wordScore = wordScore * (chars.length() - 2); //Score is letters times (length - 2)
		score = score + wordScore;
		System.out.println(score);
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
