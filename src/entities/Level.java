package entities;

import java.util.ArrayList;

public class Level {

	String title;
	String type;
	Board board;
	Score score;
	ArrayList<Word> wordList;
	Word selectedWord;
	
	Level(String title) {
		this.title = title;
	}
}
