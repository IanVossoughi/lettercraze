package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Model;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Reset Button on the PlayField.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */

public class ResetButtonController implements ActionListener {

	/** The player boundary and that we are manipulating and using to begin the action. */
	private PlayField playField;
	
	/** Highest level entity model*/
	private Model m;

	/**
	 * ResetButtonController constructor comment.
	 */
	public ResetButtonController(PlayField playField, Model m) {
		this.playField = playField;
		this.m = m;
	}
	
	/**
	 * Coordinate reaction to pressing the Reset button. Try to reset the entire game (Expect the timer in Lightning level).
	 * <p>
	 * @param e controllers.ResetButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Reset Level",
		"Cancel"};
		/**
		 * User is prompted if they really want to reset
		 */
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Are you sure you want to reset? All progress will be lost.",
				"Yes or No",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0){
			int size = playField.undoArray.getUndoSize();
			for (int i = 0; i < size; i++){
				new UndoButtonController(m, playField, playField.undoArray).actionPerformed(null);
				if (i + 1 == size){
					break;
				}
			}
			new DeselectButtonController(m, playField).actionPerformed(null);
			JOptionPane.showMessageDialog(new JFrame(),"Level reset.");
		}
	}
}
