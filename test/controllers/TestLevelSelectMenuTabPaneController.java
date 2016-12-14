package controllers;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;

import entities.Model;
import junit.framework.TestCase;
import playerBoundary.MenuField;

public class TestLevelSelectMenuTabPaneController extends TestCase {
	MenuField menu;
	JTabbedPane tabPane;
	int unlocked; 
	JButton play;
	Model m;
	JLabel title;
	JLabel highScoreNumLabel;
	ChangeEvent e;
	int index;
	
	@Override
	protected void setUp() {
		menu = new MenuField();
		tabPane = new JTabbedPane();
		play = new JButton();
		m = new Model();
		title = new JLabel();
		highScoreNumLabel = new JLabel();
		
		for (int i = 1; i < 16; i++){
			tabPane.addTab(Integer.toString(i), null, null, null);
		}
	}
	
	public void testLevelSelectMenuTabPaneController() {
		
		// Testing locked puzzle level 
		index = 3;
		unlocked = 0;
		tabPane.setSelectedIndex(index);
		LevelSelectMenuTabPaneController test1 = new LevelSelectMenuTabPaneController(menu, play, tabPane, unlocked, m, title, highScoreNumLabel);
		test1.stateChanged(null);
		assertFalse(play.isEnabled());
		
		// Testing unlocked lightning level
		index = 10;
		unlocked = 15;
		tabPane.setSelectedIndex(index);
		LevelSelectMenuTabPaneController test2 = new LevelSelectMenuTabPaneController(menu, play, tabPane, unlocked, m, title, highScoreNumLabel);
		test2.stateChanged(null);
		assertTrue(play.isEnabled());
		
		// Testing unlocked theme level
		index = 5;
		unlocked = 15;
		tabPane.setSelectedIndex(index);
		LevelSelectMenuTabPaneController test3 = new LevelSelectMenuTabPaneController(menu, play, tabPane, unlocked, m, title, highScoreNumLabel);
		test3.stateChanged(null);
		assertTrue(play.isEnabled());
	}
}
	
	