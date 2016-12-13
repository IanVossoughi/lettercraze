package controllers;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.ProgressIO;

public class LevelSelectMenuTabPaneController implements ChangeListener{

	private MenuField menu;
	private JTabbedPane tabPane;
	private int unlocked; 
	private JButton play;
	private Model m;
	private JLabel title;
	
	public LevelSelectMenuTabPaneController(MenuField menu, JButton play, JTabbedPane tabPane, int unlocked, Model m, JLabel title){
		this.menu = menu;
		this.tabPane = tabPane;
		this.unlocked = unlocked;
		this.play = play;
		this.m = m;
		this.title = title;
		
	}

	public void stateChanged(ChangeEvent e){
		int tabIndex = tabPane.getSelectedIndex();
		// Update the model with the selected index
		this.m.setSelectedTab(tabIndex);
		OpenLevelButtonController.loadLevel("levels/" + (m.getSelectedIndex()+1), m, null);
		//System.out.println(m.getTitle());
		title.setText(m.getTitle());
		//title.setText("sdfsdfwegef");
		System.out.println(ProgressIO.loadUnlockedNum() + "");
		//menu.setLevelNameLabel("dfsdfds");
		
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
