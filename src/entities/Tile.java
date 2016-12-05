package entities;

public class Tile {
	boolean enabled;
	boolean selected;
	String letter;
	int points;
	
	Tile(String letter, int points) {
		this.enabled = false;
		this.selected = false;
		this.letter = letter;
		this.points = points;
	}
}
