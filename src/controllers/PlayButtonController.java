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
	int whichLevel;
	//private int unlocked;

	public PlayButtonController(MenuField menuField, Model m) {
		this.menuField = menuField;
		this.m = m;
		this.levelType = menuField.getLevelType();
		this.whichLevel = m.getSelectedIndex();
		//this.unlocked = unlocked;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Before we open the PlayField, load the level into the model.
		this.loadLevel();

		PlayField pf = new PlayField(m);
		pf.setVisible(true);

		menuField.setVisible(false);
		menuField.dispose();	
		levelType = menuField.getLevelTypeLabel().getText();

		System.out.print("\n levelType var is " + levelType + "\n");
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
		m.setSelectedTab(whichLevel);
		System.out.print("\n Selected Tab is =" + whichLevel + "\n");
		pf.hasTimer();
	}

	private void loadLevel() {
		// Get the selected index, convert to string
		int levelNum = (m.getSelectedIndex() + 1);
		String filePath = "levels/" + levelNum;
		new OpenLevelButtonController(m, null, null).loadLevel(filePath, m, null);
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}

}
