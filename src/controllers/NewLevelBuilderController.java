package controllers;

import java.awt.event.*;
import javax.swing.*;

import builderBoundary.BuildField;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

public class NewLevelBuilderController implements ActionListener {

	private BuildField buildField;
	private Model m;
	private JPanel contentPane;


	public NewLevelBuilderController(BuildField buildField, Model m) {
		this.buildField = buildField;
		this.m = m;
		this.contentPane = buildField.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Yes, please",
		"No, thanks"};
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Do you wanna save?",
				"Yes or No",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0) {
			userSelectsSave();
			JOptionPane.showMessageDialog(new JFrame(),"Complete");

		} else {				
			closingLogic();
		}
	}

	/** This can be tested. */
	void userSelectsSave() {
		SaveSelectionWindow saver = new SaveSelectionWindow(m);
		saver.setVisible(true);
		new SaveLevelButtonController(m, saver).actionPerformed(null);
		closingLogic();
	}
	
	void closingLogic() {
		buildField.setVisible(false);
		buildField.dispose();
		new BuildField().setVisible(true);
	}

}