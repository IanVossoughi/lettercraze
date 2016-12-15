package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;

/**
 *  Controls all actions related to the Builder Tile buttons, toggling their enabled status upon a click
 * <p>
 * Creation date: (12/15/16 6:06:45 PM)
 * @author Ian Vossoughi
 */
public class BuilderClickTileController implements ActionListener {

	/** The row coordinate of the clicked Tile in the Tile array. */
	protected int x;
	
	/** The column coordinate of the clicked Tile in the Tile array. */
	protected int y;
	
	/** The builder boundary that we are manipulating and using to begin the action. */
	protected BuildField b;
	
	/** The highest level entity model.*/	
	protected Model m;
	
	/**
	 * BuilderClickTileController constructor comment.
	 */
	public BuilderClickTileController(Model m, BuildField b, int x, int y){
		this.x = x;
		this.y = y;
		this.b = b;
		this.m = m;
	}

	/**
	 * Coordinate reaction to clicking a tile in the Builder Tile array, toggling the tile's enabled status.
	 * <p>
	 * @param ae controllers.BuilderClickTileController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Tile clickedTile = this.m.getBoard().getTile(x, y);
		clickedTile.toggleEnabled();
		b.refreshBoard();
		
	}
}
