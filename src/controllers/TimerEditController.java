package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

public class TimerEditController implements KeyListener {

	protected JTextField timer;
	protected Model m;
	
	public TimerEditController(JTextField timer, Model m){
		this.timer = timer;
		this.m = m;
	}
	
	//@Override
	/*public void actionPerformed(ActionEvent ae) {
		// Update the model's title field.\
		String title = levelName.getText();
		m.setTitle(title);
		System.out.println("Level name updated: " + title);
	}*/

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Update the model's title field.\
		int time = Integer.parseInt(time.getText());
		m.setTime(time);
		//System.out.println("Level name updated: " + title);
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}