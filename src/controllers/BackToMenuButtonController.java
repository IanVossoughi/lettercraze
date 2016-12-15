package controllers;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class BackToMenuButtonController implements ActionListener {

	private PlayField playField;
	private MenuField m;
	private Model model;
	private int whichLevel;

	public BackToMenuButtonController(PlayField playField, Model model) {
		this.playField = playField;	
		this.model = model;
		this.whichLevel = model.getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		m = new MenuField();
		m.setVisible(true);
		
		// Update highscores
		if(model.getHighScores()[model.getSelectedIndex()] < model.getScore().getScoreValue()){
			model.writeHighScore();
		}
		// --> end highscores
		
		//update the "index"th of the array highscore
		System.out.print("\n Selected index =" + whichLevel);
		System.out.print("\n get score value =" + model.getScore().getScoreValue() + "SECOND");

		model.setHighScore(model.getSelectedIndex(), model.getScore().getScoreValue());
		System.out.print(model.getHighScores());
		playField.stopTimer();
		playField.checkIfWon();
		playField.setVisible(false);
		playField.dispose();


	}

}
