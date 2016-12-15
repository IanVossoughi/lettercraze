package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Coordinate;
import entities.Model;
import playerBoundary.PlayField;

public class DeselectButtonController implements ActionListener {

	protected PlayField p;
	protected Model m;
	
	public DeselectButtonController(Model m, PlayField p){
		this.p = p;
		this.m = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m.getBoard().setSelectedTileCoords(new Coordinate(-1,-1));
		m.getSelectedWord().setWordString("");
		for(int x = 0; x < 6; x++) {
			for (int y = 0; y < 6; y++) {
				m.getBoard().getTile(x, y).setSelection(false);
			}
		}
		p.refreshBoard();

	}

}
