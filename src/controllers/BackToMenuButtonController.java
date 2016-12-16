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

/**
 *  Controls all actions related to returning from the player to the game menu: manually exiting the level or running out of time.
 * <p>
 * Creation date: (12/15/16 5:53:26 PM)
 * @author Ian Vossoughi
 */
public class BackToMenuButtonController implements ActionListener {

	/** The game boundary that we are manipulating and using to begin the action. */
	private PlayField playField;
	
	/** The menu boundary that we are manipulating and using to begin the action. */
	private MenuField m;
	
	/** The highest level entity model.*/
	private Model model;
	
	/** The number of the level being played.*/
	private int whichLevel;

	/**
	 * BackToMenuButtonController constructor comment.
	 */
	public BackToMenuButtonController(PlayField playField, Model model) {
		this.playField = playField;	
		this.model = model;
		this.whichLevel = model.getSelectedIndex();
	}

	/**
	 * Coordinate reaction to time running out or pressing the Exit Level button, 
	 * preparing the menu to receive and display the results of the game (unlocking as necessary).
	 * <p>
	 * @param e controllers.BackToMenuButtonController.actionPerformed(ActionEvent)
	 */
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
		
		// Update highscores
		if(model.getHighScores()[model.getSelectedIndex()] < model.getScore().getScoreValue()){
			model.setHighScore(model.getSelectedIndex(), model.getScore().getScoreValue());
			model.writeHighScore();
		}
		// end highscore updates

		m = new MenuField();
		m.setVisible(true);
		
		model.setHighScore(model.getSelectedIndex(), model.getScore().getScoreValue());

		playField.stopTimer();
		playField.checkIfWon();
		playField.setVisible(false);
		playField.dispose();


	}

}
