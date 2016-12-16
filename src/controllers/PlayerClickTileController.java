package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Coordinate;
import entities.Model;
import entities.Tile;
import entities.Word;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Player clicking a tile.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanenr
 */
public class PlayerClickTileController implements ActionListener {

	/** X position of the tile */
	protected int x;
	/** Y position of the tile */
	protected int y;
	/** The player boundary that we are manipulating and using to begin the action. */
	protected PlayField p;
	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * PlayerClickTileController constructor comment.
	 */
	public PlayerClickTileController(Model m, PlayField p, int x, int y){
		this.x = x;
		this.y = y;
		this.p = p;
		this.m = m;
	}

	/**
	 * Coordinate reaction to clicking a tile
	 * <p>
	 * @param ae controllers.PlayerClickTileController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Tile clickedTile = this.m.getBoard().getTile(x, y);
		 		if (clickedTile.getLetter().equals("Q")) {
		 			clickedTile.setLetter("QU");
		 		}
		 /** Check is tile can be selected.*/
		if (clickedTile.isEnabled()) {
			Coordinate currentTile = m.getBoard().getSelectedTileCoords();
			boolean firstTile = false;
			if (currentTile.x < 0) {
				firstTile = true;
			}
			if(firstTile || ((Math.abs(x - currentTile.x) < 2) && (Math.abs(y - currentTile.y) < 2) && (!clickedTile.isSelected()))) {
				clickedTile.setSelection(true);
				if (clickedTile.isSelected()) {
					if (clickedTile.getLetter() == "Q") {
						m.getSelectedWord().setWordString(m.getSelectedWord().getWordString() + "QU");				
					}
					else {
						m.getSelectedWord().setWordString(m.getSelectedWord().getWordString() + clickedTile.getLetter());
					}
					m.getBoard().setSelectedTileCoords(new Coordinate(x,y));
				}
			}
			p.refreshBoard();
		}
	}
}
