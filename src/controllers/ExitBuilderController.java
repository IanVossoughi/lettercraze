package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;
import builderBoundary.BuildMain;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

/**
 *  Controls all actions related to the Builder Exit Menu item, 
 *  specifically exiting from the Builder to quit the entire application.
 * <p>
 * Creation date: (12/15/16 6:25:12 PM)
 * @author Ian Vossoughi
 */
public class ExitBuilderController implements ActionListener {

	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;
	
	/** The highest level entity model.*/
	private Model m;

	/**
	 * ExitBuilderController constructor comment.
	 */
	public ExitBuilderController(BuildField buildField) {
		this.buildField = buildField;
	}

	/**
	 * Coordinate reaction to clicking the Builder Exit menu item, quitting the Builder and BuilderMain.
	 * <p>
	 * @param e controllers.ExitBuilderController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		buildField.setVisible(false);
		buildField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildField.dispose();
	}
}