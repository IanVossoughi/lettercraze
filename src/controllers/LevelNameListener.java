package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

public class LevelNameListener implements KeyListener {

	protected JTextField levelName;
	protected Model m;
	
	public LevelNameListener(JTextField levelName, Model m){
		this.levelName = levelName;
		this.m = m;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Update the model's title field.\
		String title = levelName.getText();
		m.setTitle(title);	
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}
