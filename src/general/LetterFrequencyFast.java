package general;

import java.util.HashMap;
import java.util.Random;

public class LetterFrequencyFast {
	private static LetterFrequencyFast instance = null;

	private HashMap<Character, Integer> charFreq;

	public static LetterFrequencyFast getInstance() {
		if (instance == null) {
			instance = new LetterFrequencyFast();
		}
		return instance;
	}

	protected LetterFrequencyFast() {
		charFreq = new HashMap<Character, Integer>();
		generateCumulativeValues();
		
	}
	
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
		charFreq.put('Q', 95);//was 95
		charFreq.put('Z', 74);

		HashMap<Character, Integer> newCharFreq = new HashMap<Character, Integer>();
		int total = 0;
		for (char key : charFreq.keySet()) {
			total += charFreq.get(key);
			//System.out.println(key + " : " + total);
			newCharFreq.put(key, total);
		}
		
		charFreq = newCharFreq;
		getRandomLetter();
	}

	public String getRandomLetter() {
		int rand = new Random().nextInt(100000);
		for(char key : charFreq.keySet()){
			if(rand <= charFreq.get(key)){
				//System.out.println(key + " : " + rand + " < " + charFreq.get(key));
				return Character.toString(key); 
			}
		}
		return (String) null;
	}

}
