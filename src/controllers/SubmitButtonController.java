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
		Word selectedWord = model.getSelectedWord();
		//new SubmitWordMove(model);

	}

}
