package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import builderBoundary.BuildMain;

/**
 *  Controls all actions related to the Builder Continue Button, 
 *  specifically moving from the splash screen into the Builder proper.
 * <p>
 * Creation date: (12/15/16 6:25:12 PM)
 * @author Ian Vossoughi
 */
public class ContinueBuilderController implements ActionListener {

	/** The Builder main that contains the splash screen and initiates the BuildField boundary. */
	private BuildMain buildMain;

	/**
	 * ContinueBuilderController constructor comment.
	 */
	public ContinueBuilderController(BuildMain buildMain) {
		this.buildMain = buildMain;	}
	
	/**
	 * Coordinate reaction to clicking the Builder splash screen Continue button, creating and entering the Builder field.
	 * <p>
	 * @param e controllers.ContinueBuilderController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new BuildField().setVisible(true);
		buildMain.setVisible(false);
		buildMain.dispose();
	}

}
