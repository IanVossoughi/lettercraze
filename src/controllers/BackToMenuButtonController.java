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
		
	
		
		// Update highscores
		if(model.getHighScores()[model.getSelectedIndex()] < model.getScore().getScoreValue()){
			model.setHighScore(model.getSelectedIndex(), model.getScore().getScoreValue());
			model.writeHighScore();
			
		}
		// --> end highscores
		
		m = new MenuField();
		m.setVisible(true);

		playField.stopTimer();
		playField.checkIfWon();
		playField.setVisible(false);
		playField.dispose();


	}

}
