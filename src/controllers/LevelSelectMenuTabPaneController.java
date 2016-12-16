package controllers;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.ProgressIO;

/**
 *  Controls all actions related to manipulating the LetterCraze Menu's Level Select tab pane, 
 *  updating the menu's level preview squares to have the relevant data from the levels loaded from disk.
 * <p>
 * Creation date: (12/15/16 7:47:20 PM)
 * @author Ian Vossoughi
 */
public class LevelSelectMenuTabPaneController implements ChangeListener{

	/** The LetterCraze menu boundary that contains the TabbedPane of levels. */
	private MenuField menu;
	/** The TabbedPane in question, whose levels will display the latest information when a new tab is clicked.*/
	private JTabbedPane tabPane;
	/** The number of the next level that must been unlocked.*/
	private int unlocked; 
	/** The MenuField's Play button, used to load the level of the currently selected tab into a PlayField.*/
	private JButton play;
	/** The highest level entity model.*/
	private Model m;
	/** The title of a specific level inside the tab preview.*/
	private JLabel title;
	/** The highest recorded score of the level currently viewed in the tab preview.*/
	private JLabel highScoreNumLabel;
	
	/**
	 * LevelSelectMenuTabPaneController constructor comment.
	 */
	public LevelSelectMenuTabPaneController(MenuField menu, JButton play, JTabbedPane tabPane, int unlocked, Model m, JLabel title, JLabel highScoreNumLabel){
		this.menu = menu;
		this.tabPane = tabPane;
		this.unlocked = unlocked;
		this.play = play;
		this.m = m;
		this.title = title;
		this.highScoreNumLabel = highScoreNumLabel;
		
	}

	/**
	 * Coordinate reaction to changing the tab in the TabPane. In this case,
	 * the information about the level in the TabPane will be updated after loading in the
	 * respective level from disk and obtaining information from it
	 * @param e controllers.LevelSelectMenuTabPaneController.stateChanged(ChangeEvent)
	 */
	public void stateChanged(ChangeEvent e){
		int tabIndex = tabPane.getSelectedIndex();
		
		// Update the model with the selected index
		this.m.setSelectedTab(tabIndex);
		m.readHighScore();
		OpenLevelButtonController.loadLevel("levels/" + (m.getSelectedIndex()+1), m, null);
		title.setText(m.getTitle());
		
		if(tabIndex % 3 == 0)
			menu.getLevelTypeLabel().setText("PUZZLE");
		if(tabIndex % 3 == 1)
			menu.getLevelTypeLabel().setText("LIGHTNING");
		if(tabIndex % 3 == 2)
			menu.getLevelTypeLabel().setText("THEME");

		play.setEnabled(tabIndex < unlocked);
		highScoreNumLabel.setText(m.getHighScores()[tabIndex] + "");
	}
	
}
