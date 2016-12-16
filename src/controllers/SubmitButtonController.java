package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import entities.Model;
import entities.Word;
import playerBoundary.MenuField;
import playerBoundary.PlayField;
import playerBoundary.ProgressIO;

/**
 *  Controls all actions related to the Player Submit Button 
 *  Used to submit words made in game
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class SubmitButtonController implements ActionListener {
	//take in Word 
	//see if it's valid move
	//doMove
	
	/** The highest level entity model.*/
	Model model;
	/** The player boundary that we are manipulating and using to begin the action. */
	PlayField play;
	/** The star labels that may be updated*/
	private JLabel[] starLabels = new JLabel[3];
	/** Checks level in game */
	private int whichLevel;
	
	/**
	 * SubmitButtonController constructor comment.
	 */
	public SubmitButtonController(Model m, PlayField p, JLabel star1Label, JLabel star2Label, JLabel star3Label) {
		this.model = m;
		this.play = p;
		starLabels[0] = star1Label;
		starLabels[1] = star2Label;
		starLabels[2] = star3Label;
		this.whichLevel = model.getSelectedIndex();
	}

	/**
	 * Coordinate reaction to clicking the Submit Button
	 * Includes check for validity
	 * <p>
	 * @param e controllers.NewLevelBuilderController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SubmitWordMove move = new SubmitWordMove(model, play, this);
		move.doMove();
		if ((model.getLimit() <= 0) && (model.getType() == 0)) {
			JOptionPane.showMessageDialog(new JFrame(), "That was your final move. Ever!");
			play.gameOver();
		}
	}

	public JLabel[] getStarLabels() {
		return this.starLabels;
	}

}
