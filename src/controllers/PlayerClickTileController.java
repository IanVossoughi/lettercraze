package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;
import playerBoundary.PlayField;

public class PlayerClickTileController implements ActionListener {

	protected int x;
	protected int y;
	protected PlayField p;
	protected Model m;
	
	public PlayerClickTileController(Model m, PlayField p, int x, int y){
		this.x = x;
		this.y = y;
		this.p = p;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//System.out.println(x + " " + y);
		Tile clickedTile = this.m.getBoard().getTile(x, y);
		clickedTile.toggleSelected();
		p.refreshBoard();
		
	}
}
