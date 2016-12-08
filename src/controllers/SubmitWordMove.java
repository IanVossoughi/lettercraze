package controllers;

import javax.swing.DefaultListModel;

import entities.Model;
import entities.Word;

public class SubmitWordMove {
	private Word selectedWord;
	private DefaultListModel<String> wordList;
	
	public SubmitWordMove(Model model) {
		this.selectedWord = model.getSelectedWord();
		this.wordList = model.getWordListModel();
	}
	public boolean doMove(){
		if(isValid()){
			wordList.addElement(selectedWord.getWordString());
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
