package controllers;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	
	// These three are for star icons
	private SubmitButtonController submitButtonController;
	private Icon goldStarIcon = new ImageIcon(PlayField.class.getResource("/general/star.png"));
	private Icon blackStarIcon = new ImageIcon(PlayField.class.getResource("/general/padlock_locked.png"));
	
	public SubmitWordMove(Model model, PlayField play, SubmitButtonController submitButtonController) {
		this.selectedWord = model.getSelectedWord();
		this.wordList = model.getWordListModel();
		this.model = model;
		this.play = play;
		this.submitButtonController = submitButtonController;
	}
	public boolean doMove(){
		if(isValid()){
			play.undoArray.addUndoModel(model);
			//wordList.addElement(selectedWord.getWordString());
			model.addWordListModel(selectedWord.getWordString());
			System.out.println("Word is" + selectedWord.getWordString()); //Andrew, checking
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
			
			//System.out.println("Score: " + model.getScore().getScoreValue());
			//System.out.println("Score needed: " + model.getScore().getStarScoreIndex(2));
			if(model.hasWon()){
				// Update the progress
				
				int currentProg = ProgressIO.loadUnlockedNum();
				int playingLevel = model.getSelectedIndex() + 1;
				//System.out.println("new level unlocked" + currentProg + " " + playingLevel);
				if(currentProg == playingLevel){
					//System.out.println("Level actually unlocked");
					ProgressIO.saveUnlockedNum(currentProg + 1);
				}
			}
			model.setLastMove(this);
			return true;
		}
		new DeselectButtonController(model, play).actionPerformed(null);
		play.refreshBoard();
		
		updateStars();
		
		return false;
	}
	
	private void updateStars() {
		// Check if star if its score has been reached
		JLabel[] starLabels = this.submitButtonController.getStarLabels();
		for(int i = 0; i < 3; i++){
			int scoreNeeded = model.getScore().getStarScoreIndex(0);
			int score = model.getScore().getScoreValue();
			if(score >= scoreNeeded){
				// Yellow star icon
				starLabels[i].setIcon(goldStarIcon);
			} else {
				// Black star icon
				starLabels[i].setIcon(blackStarIcon);
			}
		}
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
			model.setBoard(play.undoArray.getLatestModel().getBoard());
			model.setSelectedWord(play.undoArray.getLatestModel().getSelectedWord());
			model.setLastMove(play.undoArray.getLatestModel().getLastMove());
			model.setScore(play.undoArray.getLatestModel().getScore());
			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			model.getBoard().setSelectedTileCoords(play.undoArray.getLatestModel().getBoard().getSelectedTileCoords());
			play.undoArray.removeUndoModel();
			play.refreshBoard();
			return model;
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
