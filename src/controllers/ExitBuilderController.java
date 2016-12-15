package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Model;

public class ExitBuilderController implements ActionListener {

	private BuildField buildField;
	private JPanel contentPane;
	private Model m;

	public ExitBuilderController(BuildField buildField) {
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
				"Save or Cancel",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0){
			userSelectsSave();
			JOptionPane.showMessageDialog(new JFrame(),"Complete");

		} else {
			closingLogic();
		}
	}

	/** This can be tested. */
	void userSelectsSave() {
		new SaveLevelButtonController(m, contentPane).actionPerformed(null);
		closingLogic();
	}
	
	void closingLogic() {
		buildField.setVisible(false);
		buildField.dispose();
		new BuildField().setVisible(true);
	}
}
