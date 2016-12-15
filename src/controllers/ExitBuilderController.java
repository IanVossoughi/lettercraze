package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

public class ExitBuilderController implements ActionListener {

	private BuildField buildField;
	private JPanel contentPane;
	private Model m;

	public ExitBuilderController(BuildField buildField) {
		this.buildField = buildField;
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
