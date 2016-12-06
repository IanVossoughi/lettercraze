package entities;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Model {

	String title;
	String type;
	Board board;
	Score score;
	DefaultListModel<String> wordListModel;
	Word selectedWord;
	
	public Model() {
		this.board = new Board();
		this.wordListModel = new DefaultListModel<String>();
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
	
	public DefaultListModel<String> getWordListModel() {
		return wordListModel;
	}
	
	public void addWordListModel(String word) {
		wordListModel.addElement(word);
	}
	
	public Score getScore(){
		return this.score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}
