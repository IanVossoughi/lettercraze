package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;


public class AddButtonController implements ActionListener{

	private BuildField buildField;
	private Model model;

	public AddButtonController(BuildField buildField, Model model) {
		this.buildField = buildField;
		this.model = model;
	}

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