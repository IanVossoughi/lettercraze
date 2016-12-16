package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;

/**
 *  Controls all actions related to the Builder Reset Button
 *  Resets all building elements to the initial state
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class ResetBuilderController implements ActionListener {
	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;

	/**
	 * ResetBuilderController constructor comment.
	 */
	public ResetBuilderController(BuildField buildField) {
		this.buildField = buildField;
	}
	
	/**
	 * Coordinate reaction to clicking the Reset Button
	 * Prompts user before resetting
	 * <p>
	 * @param e controllers.ResetBuilderController.actionPerformed(ActionEvent)
	 */
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
			buildField.setVisible(false);
			buildField.dispose();
			new BuildField().setVisible(true);
			JOptionPane.showMessageDialog(new JFrame(),"Level reset.");
		}

	}

}