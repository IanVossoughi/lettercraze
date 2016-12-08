package controllers;


import javax.swing.DefaultListModel;
import entities.Model;
import entities.Word;
import playerBoundary.PlayField;
import general.WordTable;

public class SubmitWordMove {
	private Word selectedWord;
	private DefaultListModel<String> wordList;
	private Model model;
	private PlayField play;
	private WordTable wordtable = new WordTable();
	
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
		if(selectedWord.getWordString().length() >2){
			if(WordTable.isWord(selectedWord.getWordString())){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}

}
