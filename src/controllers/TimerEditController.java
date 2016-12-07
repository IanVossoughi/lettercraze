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
	public void keyReleased(KeyEvent e) {
		if(("1234567890".indexOf(e.getKeyChar()) != -1)){
			// Update the model's title field.\
			int timeLeft = Integer.parseInt(timer.getText());
			m.setTime(timeLeft);
			//System.out.println(timeLeft);
		} else {
			timer.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}