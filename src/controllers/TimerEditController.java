package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

/**
 *  Controls all actions related to the Timer
 * <p>
 * Creation date: (12/15/16 10:06:25 PM)
 * @author Gabrielle O'Dell
 */

public class TimerEditController implements KeyListener {

	/** The timer that we are manipulating. */
	protected JTextField timer;
	
	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * TimerEditController constructor comment.
	 */
	public TimerEditController(JTextField timer, Model m){
		this.timer = timer;
		this.m = m;
	}

	/**
	 * Coordinate reaction to the beginning of a Key Event. In this case,
	 * no action is specifically taken when the user begins typing into the field.
	 * @param arg0 controllers.TimerEditController.keyPressed(KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	/**
	 * Coordinate reaction to the end of a Key Event. In this case,
	 * the model's timer is updated as soon as the user finishes pressing a key inside the timer field.
	 * @param arg0 controllers.TimerEditController.keyReleased(KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(("1234567890".indexOf(e.getKeyChar()) != -1)){
			// Update the model's timer field.\
			int timeLeft = Integer.parseInt(timer.getText());
			m.setTime(timeLeft);
		} else {
			timer.setText("");
		}
	}

	/**
	 * Coordinate reaction to the entire Press-and-Release sequence of a Key Event. In this case,
	 * no action is specifically taken since the Released method handles the updating of the model's timer.
	 * @param ke controllers.TImerEditController.keyTyped(KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}