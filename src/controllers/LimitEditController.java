package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

public class LimitEditController implements KeyListener {

	protected JTextField limit;
	protected Model m;
	
	public LimitEditController(JTextField limit, Model m){
		this.limit = limit;
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
			int moveLimit = Integer.parseInt(limit.getText());
			m.setLimit(moveLimit);
			//System.out.println(timeLeft);
		} else {
			limit.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}