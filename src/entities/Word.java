package entities;

public class Word {

	String chars;
	int score;
	
	public Word(String chars, int score) {
		this.chars = chars;
		this.score = score;
	}
	
	public String getWordString() {
		return this.chars;
	}
	
	public void setWordString(String chars) {
		this.chars = chars;
	}
}
