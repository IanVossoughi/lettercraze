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
	//private

	public BuilderLevelTypeController(BuildField buildField, Model m, JComboBox<String> lt) {
		this.buildField = buildField;
		this.m = m;
		this.lt = lt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		int index = lt.getSelectedIndex();
		if (index == 0){
			JPanel bottomBarPanel = new JPanel();
			JTextField tempField = new JTextField();
			tempField.setEnabled(false);
			//buildField.bottomBarPanel.add(tempField);
			tempField.setColumns(5);
			buildField.setTimeField(tempField);
		}
			
	}
		
=======
	}
>>>>>>> branch 'master' of https://github.com/IanVossoughi/lettercraze
}

