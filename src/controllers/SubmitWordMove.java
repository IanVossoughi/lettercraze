package controllers;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private Icon blackStarIcon = new ImageIcon(PlayField.class.getResource("/general/star_gray.png"));

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
			model.setLimit(model.getLimit() - 1);
			//wordList.addElement(selectedWord.getWordString());
			model.addWordListModel(selectedWord.getWordString());
			selectedWord.addScore(); 
			tilesGoAway();
			model.getBoard().floatUpTiles();
			updateScore();

			//int score = selectedWord.getScore();
			play.getScoreLabel().setText(Integer.toString(model.getScore().getScoreValue()));
			new DeselectButtonController(model, play).actionPerformed(null);
			//play.refreshBoard();
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

	private void updateStars() {
		// Check if star if its score has been reached
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

	private void updateScore() {
		if(model.getType() == 0){ //Do complex word score math only for puzzle, rest have just +1 by word for score
			model.setScoreValue(model.getScore().getScoreValue() + selectedWord.getScore());
		}
		else {
			model.setScoreValue(model.getScore().getScoreValue() + 1);
		}

	}
	public boolean isValid(){
		if (model.getType() == 2) {
			boolean isTheme = false;
			for (int i = 0; i < model.getThemeWords().size(); i++){
				if(model.getThemeWords().get(i).equalsIgnoreCase(selectedWord.getWordString())) {
					System.out.println("Checking " + model.getThemeWords().get(i) + " against " + selectedWord.getWordString());
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
