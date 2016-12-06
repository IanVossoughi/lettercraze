package controllers;

import java.awt.event.*;
import javax.swing.*;

import builderBoundary.BuildField;
import entities.Model;

public class NewLevelBuilderController implements ActionListener {

	private BuildField buildField;
	private Model m;
	private JPanel contentPane;

	public NewLevelBuilderController(BuildField buildField, Model m, JPanel contentPane) {
		this.buildField = buildField;
		this.m = m;
		this.contentPane = contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Yes, please",
		"No, thanks"};
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Do you wanna save?",
				"save or nah",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0){
			JMenuItem mntmSaveLevel = new JMenuItem("Save Level");
			mntmSaveLevel.addActionListener(new SaveLevelButtonController(m, contentPane));
			JOptionPane.showMessageDialog(new JFrame(),"SAVED!");

		}				
		buildField.setVisible(false);
		buildField.dispose();
		new BuildField().setVisible(true);

	}

}