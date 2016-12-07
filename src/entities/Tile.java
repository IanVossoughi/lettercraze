package entities;

import java.util.Random;

public class Tile {
	boolean enabled;
	boolean selected;
	char letter; // Even though Q is Qu, just set this to Q - it can show Qu in the display
	//int points; Shouldn't we evaluate points somewhere else?
	
	public Tile(char letter) {
		this.enabled = false;
		this.selected = false;
		this.letter = letter;
		//this.points = points;
	}
	
	public Tile toggleEnabled(){
		if(enabled){
			enabled = false;
			this.letter = '!'; // Sentinel value;
		} else {
			enabled = true;
			this.letter = randomLetter();
		}
		return this;
	}
	
	private char randomLetter() {
		//TODO: Get Random letters according to scoring frequency
		char letter = (char) (new Random().nextInt(26) + 65);
		return letter;
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
}
