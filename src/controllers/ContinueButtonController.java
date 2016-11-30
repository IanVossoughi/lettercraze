package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.Main;
import playerBoundary.MenuField;

public class ContinueButtonController implements ActionListener{

	private Main main;

	public ContinueButtonController(Main main) {
		this.main = main;	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MenuField().setVisible(true);
		main.setVisible(false);
		main.dispose();
	}

}
