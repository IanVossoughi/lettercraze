package entities;

import java.util.Random;
import general.LetterFrequency;

public class Tile {
	boolean enabled;
	boolean selected;
	boolean toBeReplaced;
	char letter; // Even though Q is Qu, just set this to Q - it can show Qu in the display
	//int points; Shouldn't we evaluate points somewhere else?
	
	public Tile(char letter) {
		this.enabled = false;
		this.selected = false;
		this.toBeReplaced = false;
		this.letter = LetterFrequency.getInstance().getRandomLetter();
		//this.points = points;
	}
	
	public Tile toggleEnabled(){
		if(enabled){
			enabled = false;
			this.letter = '!'; // Sentinel value;
		} else {
			enabled = true;
			this.letter = randomLetterFrequency();
		}
		return this;
	}
	
	public char randomLetter() {
		//TODO: Get Random letters according to scoring frequency
		char letter = (char) (new Random().nextInt(26) + 65);
		return letter;
	}
	
	public char randomLetterFrequency() {
		return LetterFrequency.getInstance().getRandomLetter();
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
	
	public char getLetter(){
		return this.letter;
	}
	
	public void setLetter(char c) {
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
