package entities;

import java.util.Random;
import general.LetterFrequencyFast;

/**
 *  A tile of a level.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class Tile {
	/** If tile is in play or not. */
	boolean enabled;
	/** Checks if tile has been selected */
	boolean selected;
	/** Checks if tile needs to be replaced. */
	boolean toBeReplaced;
	/** Letter in the tile. */
	String letter; // Even though Q is Qu, just set this to Q - it can show Qu in the display
	/** Points of tile. */
	int points; 

	/**
	 * Tile constructor comment.
	 */
	public Tile(String letter) {
		this.enabled = false;
		this.selected = false;
		this.toBeReplaced = false;
		this.letter = letter;
		if(letter.equals("_")){
			if((this.letter = LetterFrequencyFast.getInstance().getRandomLetter()) == "Q"){
				//this.letter = "QU";

			}
			else
				this.letter = LetterFrequencyFast.getInstance().getRandomLetter();
		} 
	}

	/** Checks if tile is enabled or not. */
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

	/** Gives tile a random letter. */
	public String randomLetterFrequency() {
		return LetterFrequencyFast.getInstance().getRandomLetter();
	}
	/** Selects or deselects tile. */
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
		this.enabled = b;
	}
}