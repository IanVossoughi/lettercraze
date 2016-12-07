package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;

public class BuilderClickTileController implements ActionListener {

	protected int x;
	protected int y;
	protected BuildField b;
	protected Model m;
	
	public BuilderClickTileController(Model m, BuildField b, int x, int y){
		this.x = x;
		this.y = y;
		this.b = b;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//System.out.println(x + " " + y);
		Tile clickedTile = this.m.getBoard().getTile(x, y);
		clickedTile.toggleEnabled();
		b.refreshBoard();
		
	}
}
