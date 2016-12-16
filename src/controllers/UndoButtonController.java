package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import general.UndoArray;
import playerBoundary.PlayField;

/**
 * Controls all actions related to the Player's Undo button, 
 * specifically reverting the board back by the most recent move.
 * <p>
 * Creation date: (12/15/16 9:51:00 PM)
 * @author Gabrielle O'Dell
 *
 */
public class UndoButtonController implements ActionListener {
	
	/** The highest level entity model*/
	Model model;
	
	/** The LetterCraze player boundary that contains the undo button. */
	PlayField pf;

	/**
	 *UndoButtonController constructor comment.
	 */
	public UndoButtonController(Model m, PlayField playField, UndoArray undoArray) {
		this.model = m;
		this.pf = playField;
	}

	/**
	 * Coordinate reaction to clicking the LetterCraze undo button, 
	 * reverting the board back by one move.
	 * <p>
	 * @param e controllers.UndoButtonCOntroller.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (pf.undoArray.getIndex() > -1) {
			model = model.getLastMove().undoMove();
		}
	}

}
