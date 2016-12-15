package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class PreviewButtonController implements ActionListener{

	private Model m;
	private Model mCopy;
	

	public PreviewButtonController(Model m) {
		this.m = m;
		this.mCopy = m.copyModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mCopy = m.copyModel();
		// Before we open the PlayField, load the level into the model.
		saveLevel();
		loadLevel();
		PlayField pf = new PlayField(mCopy);
		pf.hasTimer();
		pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pf.getBackToMenuButton().setEnabled(false);
		pf.setVisible(true);
	}

	private void loadLevel() {
		// Get the selected index, convert to string
		int levelNum = (mCopy.getSelectedIndex() + 1);
		String filePath = "levels/temp";
		new OpenLevelButtonController(mCopy, null, null).loadLevel(filePath, m, null);
		m.setSelectedTab(m.getType());
		System.out.println(m.getType() + " CURR TYPE LOADED");
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}
	
	private void saveLevel() {
		// Get the selected index, convert to string
		String filePath = "levels/temp";
		new SaveLevelButtonController(mCopy, null).saveLevel(filePath);
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}

}
