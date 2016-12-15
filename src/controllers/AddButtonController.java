package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;

/**
 *  Controls all actions related to the Add Button widget, specifically adding a word to the Builder Word List.
 * <p>
 * Creation date: (12/15/16 5:49:12 PM)
 * @author Ian Vossoughi
 */
public class AddButtonController implements ActionListener{

	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;
	
	/** The highest level entity model.*/
	private Model model;

	/**
	 * AddButtonController constructor comment.
	 */
	public AddButtonController(BuildField buildField, Model model) {
		this.buildField = buildField;
		this.model = model;
	}

	/**
	 * Coordinate reaction to pressing the Add button. Try to add the word in the Builder's respective text field to the model's word list.
	 * <p>
	 * @param e controllers.AddButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Checks that a word is there
		if (!buildField.getWordEntry().isEmpty()) {
			model.addWordListModel(buildField.getWordEntry());
			buildField.setWordEntry("");
			JButton tempButton = buildField.getRemoveButton();
			tempButton.setEnabled(true);
			buildField.setRemoveButton(tempButton);
		}
	}
}