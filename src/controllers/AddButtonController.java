package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class AddButtonController implements ActionListener{

	private BuildField buildField;
	private Model model;
	//private int unlocked;

	public AddButtonController(BuildField buildField, Model model) {
		this.buildField = buildField;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.addWordListModel(buildField.getWordEntryField());
		buildField.setWordEntryField("");
		JButton tempButton = buildField.getRemoveButton();
		tempButton.setEnabled(true);
		buildField.setRemoveButton(tempButton);
	}

}
