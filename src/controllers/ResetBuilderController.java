package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;

public class ResetBuilderController implements ActionListener {

	private BuildField buildField;

	public ResetBuilderController(BuildField buildField) {
		this.buildField = buildField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Reset Level",
		"Cancel"};
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Are you sure you want to reset?",
				"Yes or No",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0){
			/* TODO INSERT ACTUAL RESET CODE */
			buildField.setVisible(false);
			buildField.dispose();
			new BuildField().setVisible(true);
			JOptionPane.showMessageDialog(new JFrame(),"Level reset.");
		}

	}

}