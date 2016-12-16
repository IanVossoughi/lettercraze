package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Coordinate;
import entities.Model;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Player Deselect button, 
 *  specifically deselecting every highlighted tile on the board to start a new word from a new tile.
 * <p>
 * Creation date: (12/15/16 6:45:30 PM)
 * @author Ian Vossoughi
 */
public class DeselectButtonController implements ActionListener {

	/** The player boundary that we are manipulating and using to begin the action.*/
	protected PlayField p;
	
	/** The highest level entity model.*/
	protected Model m;
	
	/**
	 * DeselectLevelButtonController constructor comment.
	 */
	public DeselectButtonController(Model m, PlayField p){
		this.p = p;
		this.m = m;
	}
	
	/**
	 * Coordinate reaction to clicking the PlayField Deselect Button, removing the highlighting selection from all board tiles.
	 * <p>
	 * @param e controllers.DeselectButtonController.actionPerformed(ActionEvent)
	 */
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
