package general;

/**
 * Provides a quick reference to all tile icons, which are accessed by key values of the tile characters.
 * <p>
 * Creation date: (12/15/16 8:12:25 PM)
 * @author Ian Vossoughi
 */
import java.util.HashMap;

import javax.swing.ImageIcon;

import playerBoundary.PlayField;

public class IconMap {
	/** HashMap of the regular, unpressed tile icons */
	HashMap<Character, ImageIcon> mappedIcons;
	/** HashMap of the pressed tile icons */
	HashMap<Character, ImageIcon> pressedIcons;
	
	/**
	 * IconMap constructor comment.
	 */
	public IconMap() {
		this.mappedIcons = generateIconMap();
		this.pressedIcons = generatePressedIconMap();
	}
	
	/**
	 * Populates the unpressed tile HashMap with its correct icons.
	 * @return HashMap of every letter tile icon
	 */
	private HashMap<Character, ImageIcon> generateIconMap() {
		HashMap<Character, ImageIcon> iconMap = new HashMap<Character, ImageIcon>();
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			if(letter == 'Q'){
				iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/" + "QU" + ".png")));	
			}
			else {
				iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/" + letter + ".png")));
			}
		}
		return iconMap;
	}
	
	/**
	 * Populates the pressed tile HashMap with its correct icons.
	 * @return HashMap of every pressed letter tile icon
	 */
	private HashMap<Character, ImageIcon> generatePressedIconMap() {
		HashMap<Character, ImageIcon> iconMap = new HashMap<Character, ImageIcon>();
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			if(letter == 'Q'){
				iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/pressedTiles/"+ "QU" + ".png")));	
			}
			else{
				iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/pressedTiles/"+ letter + ".png")));
			}
		}
		return iconMap;
	}
	
	public ImageIcon getIcon(char letter) {
		return this.mappedIcons.get(letter);
	}
	
	public ImageIcon getPressedIcon(char letter) {
		return this.pressedIcons.get(letter);
	}
}
