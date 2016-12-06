package entities;

import java.util.ArrayList;

public class Model {

	String title;
	String type;
	Board board;
	Score score;
	ArrayList<Word> wordList;
	Word selectedWord;
	
	public Model() {
		this.board = new Board();
	}
	
	public Board getBoard(){
		return this.board;
	}

	public void setBoard(Board board2) {
		// TODO Auto-generated method stub
		this.board = board2;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Score getScore(){
		return this.score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}
