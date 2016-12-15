package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.MenuField;

public class ExitButtonController implements ActionListener {

	private MenuField menuField;

	public ExitButtonController(MenuField menuField) {
		this.menuField = menuField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		menuField.setVisible(false);
		menuField.dispose();
	}

}
