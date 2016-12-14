package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import playerBoundary.PlayField;

public class UndoButtonController implements ActionListener {
	Model model;
	PlayField pf;

	public UndoButtonController(Model m, PlayField playField) {
		this.model = m;
		this.pf = playField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UndoMove move = new UndoMove(model, pf);
		move.doMove();
	}

}
