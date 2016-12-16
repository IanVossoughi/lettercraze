package controllers;

import javax.swing.*;

import entities.*;
import general.WordTable;
import playerBoundary.*;

/**
 *  Controls all actions related to the PLayer submitting words.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class SubmitWordMove {
	/** Word being submitted.*/
	private Word selectedWord;
	/**WordList to where word is going.*/
	private DefaultListModel<String> wordList;
	/** The highest level entity model.*/
	private Model model;
	/** The player boundary that we are manipulating and using to begin the action. */
	private PlayField play;
	/** Dictionary word table to check submitted word against. */
	private WordTable wordTable = new WordTable();
	/** Needed if word submission unlocks a level in the menu */
	private MenuField menu;

	/** Button needs to be valid before word can submit */
	private SubmitButtonController submitButtonController;
	/** Star that is earned from move. */
	private Icon goldStarIcon = new ImageIcon(PlayField.class.getResource("/general/star.png"));
	/** Star that is not earned from move */
	private Icon blackStarIcon = new ImageIcon(PlayField.class.getResource("/general/star_gray.png"));

	/**
	 * NewLevelBuilderController constructor comment.
	 */
	public SubmitWordMove(Model model, PlayField play, SubmitButtonController submitButtonController) {
		this.selectedWord = model.getSelectedWord();
		this.wordList = model.getWordListModel();
		this.model = model;
		this.play = play;
		this.submitButtonController = submitButtonController;
	}

	/** If move is valid, update the model and playField t reflect that */
	public boolean doMove(){
		if(isValid()){
			play.undoArray.addUndoModel(model);
			model.setLimit(model.getLimit() - 1);
			model.addWordListModel(selectedWord.getWordString());
			selectedWord.addScore(); 
			tilesGoAway();
			model.getBoard().floatUpTiles(model.getType());
			updateScore();

			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			new DeselectButtonController(model, play).actionPerformed(null);
			selectedWord.setScore(0);
			selectedWord.setWordString(""); 

			if(model.hasWon()){
				
				// Update the progress
				int currentProg = ProgressIO.loadUnlockedNum();
				int playingLevel = model.getSelectedIndex() + 1;
				if(currentProg == playingLevel){
					ProgressIO.saveUnlockedNum(currentProg + 1);
				}
			}

			updateStars();

			model.setLastMove(this);
			return true;
		}
		new DeselectButtonController(model, play).actionPerformed(null);
		play.refreshBoard();

		return false;
	}

	/** Check if star if its score has been reached. */
	private void updateStars() {
		
		JLabel[] starLabels1 = this.submitButtonController.getStarLabels();
		JLabel[] starLabels = new JLabel[3];
		starLabels[0] = starLabels1[1];
		starLabels[1] = starLabels1[2];
		
		
		starLabels[2] = starLabels1[0];

		for(int i = 0; i < 3; i++){
			int scoreNeeded = model.getScore().getStarScoreIndex(i);
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

	/** Updates the score */
	private void updateScore() {
		if(model.getType() == 0){ //Do complex word score math only for puzzle, rest have just +1 by word for score
			model.setScoreValue(model.getScore().getScoreValue() + selectedWord.getScore());
		}
		else {
			model.setScoreValue(model.getScore().getScoreValue() + 1);
		}

	}
	
	/** Checks if word is a valid word for the level type */
	public boolean isValid(){
		if (model.getType() == 2) {
			boolean isTheme = false;
			for (int i = 0; i < model.getThemeWords().size(); i++){
				if(model.getThemeWords().get(i).equalsIgnoreCase(selectedWord.getWordString())) {
					isTheme = true;
					break;
				}
			}
			return isTheme;
		}
		if ((model.getType() == 0) && (model.getLimit() < 1)) {
			return false;
		}
		else if(selectedWord.getWordString().length() >2 && wordTable.isWord(selectedWord.getWordString())){
			return true;
		}
		else{
			return false; }
	}

	/** If undoing move, reverts changes from SubmitWordMove. */
	public Model undoMove() {
		if (play.undoArray.getLatestModel() == null) {return model;}
		else {
			model.setBoard(play.undoArray.getLatestModel().getBoard());
			model.setSelectedWord(play.undoArray.getLatestModel().getSelectedWord());
			model.setLastMove(play.undoArray.getLatestModel().getLastMove());
			model.setScore(play.undoArray.getLatestModel().getScore());
			model.setLimit(play.undoArray.getLatestModel().getLimit());
			model.setWordListModel(play.undoArray.getLatestModel().getWordListModel());
			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			model.getBoard().setSelectedTileCoords(play.undoArray.getLatestModel().getBoard().getSelectedTileCoords());
			model.getBoard().setSelectedTileCoords(play.undoArray.getLatestModel().getBoard().getSelectedTileCoords());
			play.undoArray.removeUndoModel();
			this.updateStars();
			play.refreshBoard();
			return model;
		}
	}

	/** Updates tiles. */
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
