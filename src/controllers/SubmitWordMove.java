package controllers;

import javax.swing.DefaultListModel;

import entities.Board;
import entities.Model;
import entities.Tile;
import entities.Word;
import general.WordTable;
import playerBoundary.MenuField;
import playerBoundary.PlayField;
import playerBoundary.ProgressIO;

public class SubmitWordMove {
	private Word selectedWord;
	private DefaultListModel<String> wordList;
	private Model model;
	private PlayField play;
	private WordTable wordTable = new WordTable();
	private MenuField menu;
	
	public SubmitWordMove(Model model, PlayField play) {
		this.selectedWord = model.getSelectedWord();
		this.wordList = model.getWordListModel();
		this.model = model;
		this.play = play;
	}
	public boolean doMove(){
		if(isValid()){
			play.undoArray.addUndoModel(model);
			//wordList.addElement(selectedWord.getWordString());
			model.addWordListModel(selectedWord.getWordString());
			System.out.println("\n Word is" + selectedWord.getWordString()); //Andrew, checking
			selectedWord.addScore(); //Andrew, gets score
			tilesGoAway();
			model.getBoard().floatUpTiles();
			updateScore();
			
//			int score = selectedWord.getScore();
			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			new DeselectButtonController(model, play).actionPerformed(null);
			//play.refreshBoard();
			selectedWord.setScore(0); //Andrew, resets word
			selectedWord.setWordString(""); //Andrew
			/*if(model.hasWon()){
				// Update the progress
				
				int currentProg = ProgressIO.loadUnlockedNum();
				int playingLevel = model.getSelectedIndex() + 1;
				//System.out.println("new level unlocked" + currentProg + " " + playingLevel);
				if(currentProg == playingLevel){
					
					ProgressIO.saveUnlockedNum(currentProg + 1);
				}
			}*/
			model.setLastMove(this);
			return true;
		}
		new DeselectButtonController(model, play).actionPerformed(null);
		play.refreshBoard();
		return false;
	}
	private void updateScore() {
		if(model.getType() == 0){ //Do complex word score math only for puzzle, rest have just +1 by word for score
			System.out.println("\n Type is " + model.getType());
			model.setScoreValue(model.getScore().getScoreValue() + selectedWord.getScore());
		}
		else {
			model.setScoreValue(model.getScore().getScoreValue() + 1);
		}
		
	}
	public boolean isValid(){
		
		if(selectedWord.getWordString().length() >2 && wordTable.isWord(selectedWord.getWordString())){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Model undoMove() {
		if (play.undoArray.getLatestModel() == null) {return model;}
		else {
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < 6; y++) {
					model.getBoard().setTile(x,y,play.undoArray.getLatestModel().getBoard().getTile(x, y));
				}
			}
			model.setSelectedWord(play.undoArray.getLatestModel().getSelectedWord());
			model.setLastMove(play.undoArray.getLatestModel().getLastMove());
			Model oldModel = play.undoArray.getLatestModel();
			play.undoArray.removeUndoModel();
			play.refreshBoard();
			return oldModel;
		}
	}

	public void tilesGoAway(){
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				if (model.getBoard().getTile(x, y).isSelected()) {
					model.getBoard().getTile(x, y).setSelection(false);
					model.getBoard().getTile(x,y).setReplacement(true);
				}
			}
		}
	}
}
