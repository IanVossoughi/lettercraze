package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;

/**
 *  Controls all actions related to the Builder Remove Button.
 *  This removes a word from the word list
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class RemoveButtonController implements ActionListener{

	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;
	/** The highest level entity model.*/
	private Model model;

	/**
	 * RemoveButtonController constructor comment.
	 */
	public RemoveButtonController(BuildField buildField, Model model) {
		this.buildField = buildField;
		this.model = model;
	}

	/**
	 * Coordinate reaction to clicking the Remove Button
	 * <p>
	 * @param e controllers.RemoveButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int index = this.buildField.getWordList().getSelectedIndex();
		if (index >= 0) {
			int newIndex = model.removeWordListModel(index);
			if (newIndex == -1) { //Nobody's left, disable firing.
				JButton tempButton = buildField.getRemoveButton();
				tempButton.setEnabled(false);
		        buildField.setRemoveButton(tempButton);

		    } else { //Select an index.
		        buildField.setWordListSelected(newIndex);
		    }
		}
	}

}
