package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.Main;
import playerBoundary.MenuField;
import playerBoundary.ProgressIO;

/**
 *  Controls all actions related to the Game Continue Button, 
 *  specifically moving from the splash screen into the menu screen.
 * <p>
 * Creation date: (12/15/16 6:29:12 PM)
 * @author Ian Vossoughi
 */
public class ContinueButtonController implements ActionListener{

	/** The LetterCraze main that contains the splash screen and initiates the PlayField boundary. */
	private Main main;

	/**
	 * ContinueBuilderController constructor comment.
	 */
	public ContinueButtonController(Main main) {
		this.main = main;	}

	/**
	 * Coordinate reaction to clicking the LetterCraze splash screen Continue button, creating and entering the menu screen.
	 * <p>
	 * @param e controllers.ContinueButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ProgressIO.saveUnlockedNum(1);
		new Model().writeHighScore();
		new Model().writeStars();
		
		new MenuField().setVisible(true);
		main.setVisible(false);
		main.dispose();
	}
	
}
