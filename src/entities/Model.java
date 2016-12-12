package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

public class Model {

	String title;
	int type; // 0 - puzzle, 1 - lightning, 2 - theme
	Board board;
	Score score;
	DefaultListModel<String> wordListModel;
	Word selectedWord;
	int time;
	/*TODO: Batu - Highscore stuff - make an array, save 15 highscores, read in and out from file */
	int[] highScore = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	public Model() {
		this.board = new Board();
		this.wordListModel = new DefaultListModel<String>();
		this.title = "";
		int[] defScore = {0, 0, 0};
		this.score = new Score(defScore);
		this.selectedWord = new Word("", 0);
		this.time = 120;
		System.out.print("TYPE Is" + this.type);

	}
	//DOESNT't work, will fix it later
	public void writeHighScore(){

		try(FileOutputStream f = new FileOutputStream("highscores.txt");
				ObjectOutput s = new ObjectOutputStream(f)) {
			s.writeObject(this.getHighScores());
			
		}

	 catch (IOException e){
		e.printStackTrace();
	}
}
public int readHighScore(int index){
	FileInputStream in;
	int num = -1; // Error if this returns
	try {
		in = new FileInputStream("highscores.txt");
		num = in.read();
		in.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.print("HighScores = " + num  +"\n");

	return num;
}

public int[] getHighScores(){
	return this.highScore;
}

public int setHighScore(){
	//do the filePicker stuff
	return -1;
}
public boolean hasWon(){
	return getScore().score == getScore().getStarScoreIndex(0);
}
public Board getBoard(){
	return this.board;
}

public int getType(){
	return this.type;
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

public String getTitle(){
	return this.title;
}

public int removeWordListModel(int index) {
	wordListModel.remove(index);
	int size = wordListModel.getSize();

	if (size == 0) {
		return -1;

	} else {
		if (index == wordListModel.getSize()) {
			index--;
		}
	}
	return index;
}

public Score getScore(){
	return this.score;
}

public void setScore(Score score) {
	this.score = score;
}

public void setScoreValue(int score) {
	this.score.setScoreValue(score);
}

public Word getSelectedWord() {
	return this.selectedWord;
}

public void setSelectedWord(Word selectedWord) {
	this.selectedWord = selectedWord;
}

public void setType(int index) {
	this.type = index;
}

public void setTime(int time) {
	// TODO Auto-generated method stub
	this.time = time;
}

public int getTime() {
	return this.time;
}
}
