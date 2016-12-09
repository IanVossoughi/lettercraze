package entities;

public class Word {

	String chars;
	int score;
	
	public Word(String chars, int score) {
		this.chars = chars;
		this.score = score;
	}
	//Andrew. Score is only based on length right now, will update
	public void addScore() {
		int wordScore = chars.length();
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
	
	public void setScore(int value) {
		this.score = value;
	}
	
	public int getScore(){return score;}
}
