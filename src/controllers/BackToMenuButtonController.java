package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerModel.MenuField;
import playerModel.PlayField;

public class BackToMenuButtonController implements ActionListener {

	private PlayField playField;

	public BackToMenuButtonController(PlayField playField) {
		this.playField = playField;	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MenuField().setVisible(true);
		playField.setVisible(false);
		playField.dispose();
	}

}
