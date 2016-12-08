package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import entities.Word;

public class SubmitButtonController implements ActionListener {
	//take in Word 
	//see if it's valid move
	//doMove
	Model model;
	public SubmitButtonController(Model m) {
		this.model = m;
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		SubmitWordMove move = new SubmitWordMove(model);
		move.doMove();
		System.out.print(model.getWordListModel().getSize());
		//TODO: reach tile and deselect tiles - refreshBoard
		//model.getBoard().getTile(0, 0);

	}

}
