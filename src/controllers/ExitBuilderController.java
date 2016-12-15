package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;
import builderBoundary.BuildMain;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

public class ExitBuilderController implements ActionListener {

	private BuildField buildField;
	private Model m;

	public ExitBuilderController(BuildField buildField) {
		this.buildField = buildField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Yes, please",
		"No, thanks"};
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Do you want to save before exiting?",
				"Yes or No",
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
		SaveSelectionWindow saver = new SaveSelectionWindow(m, "Save", new SaveLevelButtonController(m));
		saver.setVisible(true);
		closingLogic();
	}

	void closingLogic() {
		buildField.setVisible(false);
		buildField.dispose();
		new BuildField().setVisible(true);
	}
}