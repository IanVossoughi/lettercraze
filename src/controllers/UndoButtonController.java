package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import general.UndoArray;
import playerBoundary.PlayField;

public class UndoButtonController implements ActionListener {
	Model model;
	PlayField pf;

	public UndoButtonController(Model m, PlayField playField, UndoArray undoArray) {
		this.model = m;
		this.pf =playField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model.getLastMove() != null) {
			model = model.getLastMove().undoMove();
			pf.setModel(model);
			pf = new PlayField(model);
		}
		//UndoMove move = new UndoMove(model, pf);
		//move.doMove();
	}

}
