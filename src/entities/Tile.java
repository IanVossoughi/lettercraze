package entities;

public class Tile {
	boolean enabled;
	boolean selected;
	char letter; // Even though Q is Qu, just set this to Q - it can show Qu in the display
	//int points; Shouldn't we evaluate points somewhere else?
	
	Tile(char letter) {
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
			this.letter = 'q';
		}
		return this;
	}
	
	public boolean isEnabled(){
		return this.enabled;
	}
}
