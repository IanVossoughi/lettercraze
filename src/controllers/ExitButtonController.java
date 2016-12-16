package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.MenuField;

/**
 *  Controls all actions related to the LetterCraze menu screen Exit button, 
 *  specifically quitting LetterCraze entirely and returning to the desktop.
 * <p>
 * Creation date: (12/15/16 6:55:02 PM)
 * @author Ian Vossoughi
 */
public class ExitButtonController implements ActionListener {

	/** The LetterCraze menu boundary that contains the Exit button. */
	private MenuField menuField;

	/**
	 * ContinueBuilderController constructor comment.
	 */
	public ExitButtonController(MenuField menuField) {
		this.menuField = menuField;
	}

	/**
	 * Coordinate reaction to clicking the LetterCraze menu screen Exit button, ending the application.
	 * <p>
	 * @param e controllers.ContinueButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		menuField.setVisible(false);
		menuField.dispose();
	}

}
