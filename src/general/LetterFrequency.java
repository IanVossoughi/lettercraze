package general;

import java.util.HashMap;
import java.util.Random;

public class LetterFrequency {
	private static LetterFrequency instance = null;
	String frequencyString;
	
	protected LetterFrequency() {
		this.frequencyString = generateFrequencyString();
	}
	
	public static LetterFrequency getInstance() {
		if (instance == null) {
			instance = new LetterFrequency();
		}
		return instance;
	}
	
	private String generateFrequencyString() {
		HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
		charFreq.put('E', 12702);
		charFreq.put('T', 9056);
		charFreq.put('A', 8167);
		charFreq.put('O', 7507);
		charFreq.put('I', 6966);
		charFreq.put('N', 6749);
		charFreq.put('S', 6327);
		charFreq.put('H', 6094);
		charFreq.put('R', 5987);
		charFreq.put('D', 4253);
		charFreq.put('L', 4025);
		charFreq.put('C', 2782);
		charFreq.put('U', 2758);
		charFreq.put('M', 2406);
		charFreq.put('W', 2360);
		charFreq.put('F', 2228);
		charFreq.put('G', 2015);
		charFreq.put('Y', 1974);
		charFreq.put('P', 1929);
		charFreq.put('B', 1492);
		charFreq.put('V', 978);
		charFreq.put('K', 772);
		charFreq.put('J', 153);
		charFreq.put('X', 150);
		charFreq.put('Q', 95);
		charFreq.put('Z', 74);
		
		String freq = new String("");

		for(char aChar = 'A'; aChar <= 'Z'; aChar++) {
			int count = charFreq.get(aChar);
			System.out.println("Number of characters in " + aChar + ": " + count);
			for(int i = 0; i < count; i++) {
				freq = freq + aChar;
			}
		}
		System.out.println("Character string length: " + freq.length());
		return freq;
	}
	
	public char getRandomLetter() {
		int rand = new Random().nextInt(100000);
		return this.frequencyString.charAt(rand);
	}
}
