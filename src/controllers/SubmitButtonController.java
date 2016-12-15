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

public class SubmitButtonController implements ActionListener {
	//take in Word 
	//see if it's valid move
	//doMove
	Model model;
	PlayField play;
	private JLabel[] starLabels = new JLabel[3];
	private int whichLevel;
	
	public SubmitButtonController(Model m, PlayField p, JLabel star1Label, JLabel star2Label, JLabel star3Label) {
		this.model = m;
		this.play = p;
		starLabels[0] = star1Label;
		starLabels[1] = star2Label;
		starLabels[2] = star3Label;
		this.whichLevel = model.getSelectedIndex();
	}

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
