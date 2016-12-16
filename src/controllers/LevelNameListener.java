package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import entities.Model;

/**
 * Specialized listener for controlling all actions related to the Builder's Level Name text field,
 * setting the overall model's title to this name once the user has finished entering it
 * <p>
 * Creation date: (12/15/16 7:39:55 PM)
 * @author Ian Vossoughi
 *
 */
public class LevelNameListener implements KeyListener {

	/** The JTextField for entering the level's name. */
	protected JTextField levelName;
	
	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * LevelNameListener constructor comment.
	 */
	public LevelNameListener(JTextField levelName, Model m){
		this.levelName = levelName;
		this.m = m;
	}

	/**
	 * Coordinate reaction to the beginning of a Key Event. In this case,
	 * no action is specifically taken when the user begins typing into the field.
	 * @param arg0 controllers.LevelNameListener.keyPressed(KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	/**
	 * Coordinate reaction to the end of a Key Event. In this case,
	 * the model's title is updated as soon as the user finishes pressing a key inside the title field.
	 * @param arg0 controllers.LevelNameListener.keyReleased(KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// Update the model's title field.\
		String title = levelName.getText();
		m.setTitle(title);
		
	}
	
	/**
	 * Coordinate reaction to the entire Press-and-Release sequence of a Key Event. In this case,
	 * no action is specifically taken since the Released method handles the updating of the model's title.
	 * @param ke controllers.LevelNameListener.keyTyped(KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	

}
