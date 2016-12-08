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
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					if (model.getBoard().getTile(x, y).isSelected()) {
						model.getBoard().getTile(x, y).setSelection(false);
						model.getBoard().getTile(x, y).toggleEnabled();
					}
				}
			}
			new DeselectButtonController(model, play).actionPerformed(null);
			play.refreshBoard();
			return true;
		}
		return false;
	}
	public boolean isValid(){
		//wordtable.loadWordTable();
		//TODO: Check the Dictionary 
		if(selectedWord.getWordString().length() >2){
			return true;
		}
		else{
			return false;
		}
	}

}
