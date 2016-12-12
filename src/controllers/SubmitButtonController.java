package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Model;
import entities.Word;
import playerBoundary.MenuField;
import playerBoundary.PlayField;

public class SubmitButtonController implements ActionListener {
	//take in Word 
	//see if it's valid move
	//doMove
	Model model;
	PlayField play;
	
	public SubmitButtonController(Model m, PlayField p) {
		this.model = m;
		this.play = p;
		
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		SubmitWordMove move = new SubmitWordMove(model, play);
		move.doMove();
		System.out.print(model.getWordListModel().getSize());
		//TODO: reach tile and deselect tiles - refreshBoard
		//model.getBoard().getTile(0, 0);

	}

}
