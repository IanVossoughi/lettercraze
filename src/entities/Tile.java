package entities;

import java.util.Random;
import general.LetterFrequency;
import general.LetterFrequencyFast;

public class Tile {
	boolean enabled;
	boolean selected;
	boolean toBeReplaced;
	String letter; // Even though Q is Qu, just set this to Q - it can show Qu in the display
	int points; 

	public Tile(String letter) {
		this.enabled = false;
		this.selected = false;
		this.toBeReplaced = false;
		//this.letter = LetterFrequencyFast.getInstance().getRandomLetter();\
		this.letter = letter;
		if(this.letter == "_"){
			this.letter = LetterFrequencyFast.getInstance().getRandomLetter();
				if(this.letter.equals("Q")) {
					this.letter = "QU";
				}

			System.out.print(this.letter);
		}
		if(this.letter.equals("Q")) {
			this.letter = "QU";
		}
		//this.points = points;
	}

	public Tile toggleEnabled(){
		if(enabled){
			enabled = false;
			this.letter = "!"; // Sentinel value;
		} else {
			enabled = true;
			this.letter = randomLetterFrequency();
		}
		return this;
	}
	/*
	public String randomLetter() {
		//TODO: Get Random letters according to scoring frequency
		String letter =  (new Random().nextInt(26) + 65);
		return letter;
	}*/

	public String randomLetterFrequency() {
		return LetterFrequencyFast.getInstance().getRandomLetter();
	}

	public Tile toggleSelected(){
		if(selected){
			selected = false;
		} else {
			selected = true;
		}
		return this;
	}

	public boolean isEnabled(){
		return this.enabled;
	}

	public String getLetter(){
		return this.letter;
	}

	public void setLetter(String c) {
		this.letter = c;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public boolean getReplacement() {
		return this.toBeReplaced;
	}

	public void setReplacement(boolean replacement) {
		this.toBeReplaced = replacement;
	}

	public void setSelection(boolean selection) {
		this.selected = selection;
	}

	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		this.enabled = b;
	}
}
