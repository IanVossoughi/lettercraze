package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class PlayButtonController implements ActionListener{

	private MenuField menuField;
	private Model m;
	//private int unlocked;

	public PlayButtonController(MenuField menuField, Model m) {
		this.menuField = menuField;
		this.m = m;
		//this.unlocked = unlocked;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new PlayField(m).setVisible(true);
		menuField.setVisible(false);
		menuField.dispose();	
		String levelType = menuField.getLevelTypeLabel().getText();
		if(levelType == "PUZZLE")
			m.setType(0);
		if(levelType == "LIGHTNING")
			m.setType(1);
		if(levelType == "THEME")
			m.setType(2);
	}

}
