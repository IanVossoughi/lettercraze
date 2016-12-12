package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class PlayButtonController implements ActionListener{

	private MenuField menuField;
	private Model m;
	String levelType;
	//private int unlocked;

	public PlayButtonController(MenuField menuField, Model m) {
		this.menuField = menuField;
		this.m = m;
		//this.unlocked = unlocked;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PlayField pf = new PlayField(m);
		pf.setVisible(true);

		menuField.setVisible(false);
		menuField.dispose();	
		levelType = menuField.getLevelTypeLabel().getText();

		System.out.print("levelType var is " + levelType);
		if(levelType == "PUZZLE"){
			m.setType(0);
			System.out.print("levelType is set to 0");	
		}
		else if(levelType == "LIGHTNING"){
			m.setType(1);
			System.out.print("levelType is set to 1");	
		}
		else{
			m.setType(2);
			System.out.print("levelType is set to 2");	
		}
		pf.hasTimer();
	}

}
