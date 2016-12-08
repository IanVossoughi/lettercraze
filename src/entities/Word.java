package entities;

public class Word {

	String chars;
	int score;
	
	public Word(String chars, int score) {
		this.chars = chars;
		this.score = score;
	}
	
	public void addScore() {
		//int wordScore = chars.length();
		int wordScore = 1;
		System.out.println(chars.length());
		score = score + wordScore;
		System.out.println(score);
	}
	
	public String getWordString() {
		return this.chars;
	}
	
	public void setWordString(String chars) {
		this.chars = chars;
	}
	public int getScore(){return score;}
}
