package general;

import java.util.HashMap;
import java.util.Random;

/**
 * Generates a HashMap of every letter and its relative frequency in the English language,
 * along with methods to quickly gain access to a random letter according to these frequencies.
 * LetterFrequencyFast is a singleton class to provide global access to the HashMap and avoid wasting space
 * with multiple tables.
 * <p>
 * Creation date: (12/15/16 10:34:12 PM)
 * @author Ian Vossoughi
 */
public class LetterFrequencyFast {
	/** The singleton instance of this class, to avoid storing multiple instances of the HashMap. */
	private static LetterFrequencyFast instance = null;

	/** The HashMap storing each character and its frequency. */
	private HashMap<Character, Integer> charFreq;

	/** 
	 * Obtains the single existence of LetterFrequencyFast, or creates one through the protected constructor
	 * if one does not already exist. 
	 * */
	public static LetterFrequencyFast getInstance() {
		if (instance == null) {
			instance = new LetterFrequencyFast();
		}
		return instance;
	}

	/**
	 * The protected constructor of LetterFrequencyFast (can only be invoked once).
	 */
	protected LetterFrequencyFast() {
		charFreq = new HashMap<Character, Integer>();
		generateCumulativeValues();
		
	}
	
	/**
	 * Add each letter and its relative cumulative frequency to the HashMap, then generate a new random character.
	 */
	private void generateCumulativeValues(){
		charFreq = new HashMap<Character, Integer>();
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

		HashMap<Character, Integer> newCharFreq = new HashMap<Character, Integer>();
		int total = 0;
		for (char key : charFreq.keySet()) {
			total += charFreq.get(key);
			newCharFreq.put(key, total);
		}
		
		charFreq = newCharFreq;
		getRandomLetter();
	}

	/**
	 * Generates a random character based on its relative frequency, then returns it as a string.
	 * @return A string representation of the randomly-selected letter
	 */
	public String getRandomLetter() {
		int rand = new Random().nextInt(100000);
		for(char key : charFreq.keySet()){
			if(rand <= charFreq.get(key)){
				return Character.toString(key); 
			}
		}
		return (String) null;
	}

}
