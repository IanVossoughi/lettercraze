package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builderBoundary.StarThresholdWindow;
import entities.Model;
import entities.Score;

/**
 *  Controls all actions related to the Builder setting the star score values.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class StarScoreController implements ActionListener {

	/** First star field.*/
	protected JTextField field1;
	/** Second star field.*/
	protected JTextField field2;
	/** Third star field.*/
	protected JTextField field3;
	/** The highest level entity model.*/
	protected Model m;
	/** The builder boundary that we are manipulating and using to begin the action. */
	protected StarThresholdWindow s;
	
	/**
	 * StarScoreController constructor comment.
	 */
	public StarScoreController(Model m, StarThresholdWindow s) {
		this.m = m;
		this.field1 = s.getStarField1();
		this.field2 = s.getStarField2();
		this.field3 = s.getStarField3();
		this.s = s;
	}

	/**
	 * Coordinate reaction to changing the scores required to earn each star
	 * Happens when "Done" button pressed
	 * <p>
	 * @param e controllers.NewLevelBuilderController.actionPerformed(ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// "Done" button was clicked,
		// Tally the scores into the model and close the window.
		int[] scores = new int[3];
		scores[0] = Integer.parseInt(field1.getText());
		scores[1] = Integer.parseInt(field2.getText());
		scores[2] = Integer.parseInt(field3.getText());
		
		m.setScore(new Score(scores));
		
		s.setVisible(false);
		s.dispose();
		
	}

}
