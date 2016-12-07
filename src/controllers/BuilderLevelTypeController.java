package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import builderBoundary.BuildField;
import entities.Model;

public class BuilderLevelTypeController implements ActionListener {

	private BuildField buildField;
	private Model m;
	private JComboBox<String> lt;

	public BuilderLevelTypeController(BuildField buildField, Model m, JComboBox<String> lt) {
		this.buildField = buildField;
		this.m = m;
		this.lt = lt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = lt.getSelectedIndex();
		if ((index == 0) || (index == 2)){
			JTextField tempField = buildField.getTimeField();
			tempField.setEnabled(false);
			buildField.setTimeField(tempField);
		}
		else {
			JTextField tempField = buildField.getTimeField();
			tempField.setEnabled(true);
			buildField.setTimeField(tempField);
		}
		
		if(index != 2) {
			//JTextField tempWordField = buildField.getWordEntryField();
		}
		
		// Update the model
		// 0 - puzzle, 1 - lightning, 2 -theme
		m.setType(index);
		System.out.println(index);
	}
}

