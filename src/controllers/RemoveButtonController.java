package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class RemoveButtonController implements ActionListener{

	private BuildField buildField;
	private Model model;

	public RemoveButtonController(BuildField buildField, Model model) {
		this.buildField = buildField;
		this.model = model;
	}

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
