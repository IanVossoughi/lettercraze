package controllers;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Model;
import playerBoundary.MenuField;

public class LevelSelectMenuTabPaneController implements ChangeListener{

	private MenuField menu;
	private JTabbedPane tabPane;
	private int unlocked; 
	private JButton play;
	private Model m;
	
	public LevelSelectMenuTabPaneController(MenuField menu, JButton play, JTabbedPane tabPane, int unlocked, Model m){
		this.menu = menu;
		this.tabPane = tabPane;
		this.unlocked = unlocked;
		this.play = play;
		this.m = m;
		
	}

	public void stateChanged(ChangeEvent e){
		int tabIndex = tabPane.getSelectedIndex();
		// Update the model with the selected index
		this.m.setSelectedTab(tabIndex);
		
		
		if(tabIndex % 3 == 0)
			menu.getLevelTypeLabel().setText("PUZZLE");
		if(tabIndex % 3 ==1)
			menu.getLevelTypeLabel().setText("LIGHTNING");
		if(tabIndex % 3 == 2)
			menu.getLevelTypeLabel().setText("THEME");

		play.setEnabled(tabIndex < unlocked);
		System.out.print(menu.getLevelTypeLabel().getText() + "\n");
	}
	
}
