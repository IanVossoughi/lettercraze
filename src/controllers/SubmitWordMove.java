package controllers;

import javax.swing.DefaultListModel;

import entities.Board;
import entities.Model;
import entities.Tile;
import entities.Word;
import general.WordTable;
import playerBoundary.PlayField;

public class SubmitWordMove {
	private Word selectedWord;
	private DefaultListModel<String> wordList;
	private Model model;
	private PlayField play;
	private WordTable wordTable = new WordTable();
	
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
						model.getBoard().getTile(x, y).setReplacement(true);
					}
				}
			}
			System.out.println("Word is" + selectedWord.getWordString()); //Andrew, checking
			selectedWord.addScore(); //Andrew, gets score
			tilesGoAway();
			model.getBoard().moveTilesUp(); // TODO: doesn't work, if you want play without things getting messed up, comment out. 
			model.setScoreValue(model.getScore().getScoreValue() + selectedWord.getScore());
//			int score = selectedWord.getScore();
			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			new DeselectButtonController(model, play).actionPerformed(null);
			play.refreshBoard();
			System.out.println("Word is" + selectedWord.getWordString());
			selectedWord.setScore(0); //Andrew, resets word
			selectedWord.setWordString(""); //Andrew
			return true;
		}
		new DeselectButtonController(model, play).actionPerformed(null);
		play.refreshBoard();
		return false;
	}
	public boolean isValid(){
		
		if(selectedWord.getWordString().length() >2 && wordTable.isWord(selectedWord.getWordString())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void floatUpTiles(){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				while(model.getBoard().getTile(x,y).isEnabled() && model.getBoard().getTile(x, y).getReplacement()) {
					int i = x + 1;
					while(model.getBoard().getTile(i, y).isEnabled()) {
						model.getBoard().getTile(i, y).setLetter(model.getBoard().getTile(i, y+1).getLetter());
						
						i++;
					}
				}
			}
		}
	}
	public void tilesGoAway(){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (model.getBoard().getTile(x, y).isSelected()) {
					model.getBoard().getTile(x, y).setSelection(false);
					model.getBoard().getTile(x, y).toggleEnabled();
				}
			}
		}
	}
}
