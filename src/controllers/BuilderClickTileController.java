package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Model;

public class BuilderClickTileController implements ActionListener {

	protected int x;
	protected int y;
	protected BuildField b;
	protected Model m;
	
	public BuilderClickTileController(Model m, BuildField b, int x, int y){
		this.x = x;
		this.y = y;
		this.b = b;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}
}
