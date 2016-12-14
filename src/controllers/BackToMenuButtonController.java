package controllers;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class BackToMenuButtonController implements ActionListener {

	private PlayField playField;
	private MenuField m;

	public BackToMenuButtonController(PlayField playField) {
		this.playField = playField;	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m = new MenuField();
		m.setVisible(true);
		playField.stopTimer();
		playField.checkIfWon();
		playField.setVisible(false);
		playField.dispose();
	}

}
