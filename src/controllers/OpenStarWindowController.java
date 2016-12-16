package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.StarThresholdWindow;
import entities.Model;

/**
 *  Controls all actions related to the Builder Opening the Star Menu, 
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */

public class OpenStarWindowController implements ActionListener {

	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * OpenStarWindowController constructor comment.
	 */
	public OpenStarWindowController(Model m){
		this.m = m;
	}

	/**
	 * Coordinate creating a new menu item for the setting the star scores
	 * <p>
	 * @param e controllers.OpenStarWindowController.actionPerformed(ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		StarThresholdWindow thresholdWindow = new StarThresholdWindow(m);
		thresholdWindow.setVisible(true);

	}

}
