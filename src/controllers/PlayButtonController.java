package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Player Play button
 *  to begin playing a game
 * <p>
 * Creation date: (12/15/16 8:12:25 PM)
 * @author Andrew Vanner
 */
public class PlayButtonController implements ActionListener{
	
	/** The player boundary that we are manipulating and using to begin the action. */
	private MenuField menuField;
	/** The highest level entity model.*/
	private Model m;
	/**The type of level to display.*/
	String levelType;
	/** The level number.*/
	int whichLevel;

	/**
	 * PlayButtonController constructor comment.
	 */
	public PlayButtonController(MenuField menuField, Model m) {
		this.menuField = menuField;
		this.m = m;
		this.levelType = menuField.getLevelType();
		this.whichLevel = m.getSelectedIndex();
	}

	/**
	 * Coordinate reaction to clicking the Play Button menu item.
	 * <p>
	 * @param e controllers.PlayButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Before we open the PlayField, load the level into the model.
		this.loadLevel();

		PlayField pf = new PlayField(m);
		pf.setVisible(true);

		menuField.setVisible(false);
		menuField.dispose();	
		levelType = menuField.getLevelTypeLabel().getText();


		pf.hasTimer();
	}

	/**
	 * Loads the correct level determined by the selected tab
	 */
	private void loadLevel() {
		// Get the selected index, convert to string
		int tabIndex = menuField.getTabbedPane().getSelectedIndex();
		
		// Update the model with the selected index
		this.m.setSelectedTab(tabIndex);
		int levelNum = (m.getSelectedIndex() + 1);
		String filePath = "levels/" + levelNum;
		new OpenLevelButtonController(m, null, null).loadLevel(filePath, m, null);
		// The last two parameters are null because we are not in the builder.
		// Shouldn't be a problem because the loadLevel method doesn't actually use them.
	}

}
