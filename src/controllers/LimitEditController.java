package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

/**
 * Controls all actions related to the Builder's Puzzle Level Move Limit text field,
 * setting the overall model's limited number of moves after the user has entered a number into the text field.
 * <p>
 * Creation date: (12/15/16 7:58:52 PM)
 * @author Ian Vossoughi
 *
 */
public class LimitEditController implements KeyListener {

	/** The JTextField for entering the puzzle level's limited number of moves. */
	protected JTextField limit;
	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * LevelSelectMenuTabPaneController constructor comment.
	 */
	public LimitEditController(JTextField limit, Model m){
		this.limit = limit;
		this.m = m;
	}

	/**
	 * Coordinate reaction to the beginning of a Key Event. In this case,
	 * no action is specifically taken when the user begins typing into the field.
	 * @param arg0 controllers.LimitEditController.keyPressed(KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Coordinate reaction to the end of a Key Event. In this case,
	 * the model's move limit is updated as soon as the user finishes pressing a key inside the limit field.
	 * @param arg0 controllers.LimitEditController.keyReleased(KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(("1234567890".indexOf(e.getKeyChar()) != -1)){
			// Update the model's title field.\
			int moveLimit = Integer.parseInt(limit.getText());
			m.setLimit(moveLimit);
		} else {
			limit.setText("");
		}
	}

	/**
	 * Coordinate reaction to the entire Press-and-Release sequence of a Key Event. In this case,
	 * no action is specifically taken since the Released method handles the updating of the model's move limits.
	 * @param ke controllers.LimitEditController.keyTyped(KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent ke) {

	}
}