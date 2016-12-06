package entities;

import java.util.ArrayList;

public class Model {

	String title;
	String type;
	public Board board;
	Score score;
	ArrayList<Word> wordList;
	Word selectedWord;
	
	public Model() {
		this.board = new Board();
	}
}
