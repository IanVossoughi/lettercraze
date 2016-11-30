package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class PlayButtonController implements ActionListener{

	private MenuField menuField;

	public PlayButtonController(MenuField menuField) {
		this.menuField = menuField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new PlayField().setVisible(true);
		menuField.setVisible(false);
		menuField.dispose();		
	}

}
