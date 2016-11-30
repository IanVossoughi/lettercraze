package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import storyboard.BuildField;

public class ExitBuilderController implements ActionListener {

	private BuildField buildField;

	public ExitBuilderController(BuildField buildField) {
		this.buildField = buildField;
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
			JOptionPane.showMessageDialog(new JFrame(),"SAVED!");
			/* TODO INSERT ACTUALLY SAVING LEVEL CODE */
		}				
		buildField.setVisible(false);
		buildField.dispose();

	}

}
