package controllers;

import java.awt.event.*;
import javax.swing.*;

import builderBoundary.BuildField;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

/**
 *  Controls all actions related to the Builder New Level Menu item, 
 *  specifically starting on a new level from the Builder after either saving or discarding changes on the currently open level.
 * <p>
 * Creation date: (12/15/16 8:12:25 PM)
 * @author Ian Vossoughi
 */
public class NewLevelBuilderController implements ActionListener {

	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;
	
	/** The highest level entity model.*/
	private Model m;

	/**
	 * LevelSelectMenuTabPaneController constructor comment.
	 */
	public NewLevelBuilderController(BuildField buildField, Model m) {
		this.buildField = buildField;
		this.m = m;
	}

	
	/**
	 * Coordinate reaction to clicking the New Level menu item, prompting the user to save before resetting the builder to its
	 * initial state.
	 * <p>
	 * @param e controllers.NewLevelBuilderController.actionPerformed(ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Yes, please",
		"No, thanks"};
		int n = JOptionPane.showOptionDialog(new JFrame(),
				"Do you wanna save?",
				"Save?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[0]);
		if(n == 0) {
			userSelectsSave();
		} else {				
			closingLogic();
		}
	}

	/**
	 * Save the open level after the user has selected to save it
	 */
	void userSelectsSave() {
		SaveSelectionWindow saver = new SaveSelectionWindow(m, "Save", new SaveLevelButtonController(m));
		saver.setVisible(true);
		JOptionPane.showMessageDialog(new JFrame(),"Complete");
		
	}
	
	/**
	 * Closes the open level in the Builder and opens up a Builder window with blank information
	 */
	void closingLogic() {
		buildField.setVisible(false);
		buildField.dispose();
		new BuildField().setVisible(true);
	}

}