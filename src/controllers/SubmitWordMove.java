package controllers;

import javax.swing.DefaultListModel;

import entities.Model;
import entities.Word;
import playerBoundary.PlayField;

public class SubmitWordMove {
	private Word selectedWord;
	private DefaultListModel<String> wordList;
	private Model model;
	private PlayField play;
	
	public SubmitWordMove(Model model, PlayField play) {
		this.selectedWord = model.getSelectedWord();
		this.wordList = model.getWordListModel();
		this.model = model;
		this.play = play;
	}
	public boolean doMove(){
		if(isValid()){
			wordList.addElement(selectedWord.getWordString());
			play.refreshBoard();
			return true;
		}
		return false;
	}
	public boolean isValid(){
		//TODO: Check the Dictionary 
		if(wordList.contains(selectedWord.getWordString())){
			return false;
		}
		else{
			return true;
		}
	}

}
