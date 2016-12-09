package controllers;

import entities.Model;
import playerBoundary.PlayField;

public class UndoMove {
	Model model;
	PlayField playField;
	
	public UndoMove(Model model, PlayField pf) {
	this.model = model;
	this.playField = pf;
	}
	
	public boolean doMove(){
		return true;
	}
	
	public boolean isValid(){
		return false; //if the last move was reset or no moves have been played yet
	}
}
