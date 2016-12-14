package general;

import java.util.HashMap;

import javax.swing.ImageIcon;

import playerBoundary.PlayField;

public class IconMap {
	HashMap<Character, ImageIcon> mappedIcons;
	HashMap<Character, ImageIcon> pressedIcons;
	
	public IconMap() {
		this.mappedIcons = generateIconMap();
		this.pressedIcons = generatePressedIconMap();
	}
	
	private HashMap<Character, ImageIcon> generateIconMap() {
		HashMap<Character, ImageIcon> iconMap = new HashMap<Character, ImageIcon>();
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/" + letter + ".png")));
		}
		return iconMap;
	}
	
	private HashMap<Character, ImageIcon> generatePressedIconMap() {
		HashMap<Character, ImageIcon> iconMap = new HashMap<Character, ImageIcon>();
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			iconMap.put(letter, new ImageIcon(PlayField.class.getResource("/images/pressedTiles/" + letter + ".png")));
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
