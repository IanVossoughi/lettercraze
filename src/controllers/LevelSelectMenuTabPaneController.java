package controllers;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import playerBoundary.MenuField;

public class LevelSelectMenuTabPaneController implements ChangeListener{

	private MenuField menu;
	private JTabbedPane tabPane;
	private int unlocked; 
	private JButton play;
	
	public LevelSelectMenuTabPaneController(MenuField menu, JButton play, JTabbedPane tabPane, int unlocked){
		this.menu = menu;
		this.tabPane = tabPane;
		this.unlocked = unlocked;
		this.play = play;
		
	}

	public void stateChanged(ChangeEvent e){
		int tabIndex = tabPane.getSelectedIndex();
		//System.out.println(tabIndex + " " + unlocked);
		play.setEnabled(tabIndex < unlocked);
	}
	
}
