package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import builderBoundary.StarThresholdWindow;
import entities.Model;
import entities.Score;

public class StarScoreController implements ActionListener {

	protected JTextField field1;
	protected JTextField field2;
	protected JTextField field3;
	protected Model m;
	protected StarThresholdWindow s;
	
	
	public StarScoreController(Model m, StarThresholdWindow s) {
		this.m = m;
		this.field1 = s.getStarField1();
		this.field2 = s.getStarField2();
		this.field3 = s.getStarField3();
		this.s = s;
	}

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
