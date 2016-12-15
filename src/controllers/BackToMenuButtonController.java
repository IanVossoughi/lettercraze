package controllers;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;
import playerBoundary.ProgressIO;

public class BackToMenuButtonController implements ActionListener {

	private PlayField playField;
	private MenuField m;
	private Model model;
	private int whichLevel;
	private ImageIcon star	= new ImageIcon(MenuField.class.getResource("/general/star.png"));
	private ImageIcon starGray	= new ImageIcon(MenuField.class.getResource("/general/star_gray.png"));

	;


	public BackToMenuButtonController(PlayField playField, Model model) {
		this.playField = playField;	
		this.model = model;
		this.whichLevel = model.getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int scoreNeeded2 = model.getScore().getStarScoreIndex(0);
		int scoreNeeded3 = model.getScore().getStarScoreIndex(1);
		int scoreNeeded1 = model.getScore().getStarScoreIndex(2);

		int score = model.getScore().getScoreValue();
		
		if(score > model.getHighScores()[model.getSelectedIndex()]){
			
		

			if(score >= scoreNeeded1 && score >= scoreNeeded2 && score >= scoreNeeded3){
				model.setStarStatus(model.getSelectedIndex(), 3);
			}
			else if(score >= scoreNeeded1 && score >= scoreNeeded2){
				model.setStarStatus(model.getSelectedIndex(), 2);
			}
			else if (score >= scoreNeeded1){
				model.setStarStatus(model.getSelectedIndex(), 1);

			}
			else{
				model.setStarStatus(model.getSelectedIndex(), 0);

			}
			model.writeStars();
		}
		
		m = new MenuField();
		m.setVisible(true);

		// Update highscores
		if(model.getHighScores()[model.getSelectedIndex()] < model.getScore().getScoreValue()){
			model.writeHighScore();
		}
		// --> end highscores

		model.setHighScore(model.getSelectedIndex(), model.getScore().getScoreValue());
		

//		if (model.getHighScores()[model.getSelectedIndex()] < scoreNeeded1) {
//			int currentProg = ProgressIO.loadUnlockedNum();
//			int playingLevel = model.getSelectedIndex() + 1;
//			//System.out.println("new level unlocked" + currentProg + " " + playingLevel);
//			if((currentProg > playingLevel) && playingLevel > 0){
//				//System.out.println("Level actually unlocked");
//				ProgressIO.saveUnlockedNum(playingLevel);
//			}
//		}

		playField.stopTimer();
		playField.checkIfWon();
		playField.setVisible(false);
		playField.dispose();


	}

}
