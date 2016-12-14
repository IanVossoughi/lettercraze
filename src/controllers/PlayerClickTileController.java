package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Coordinate;
import entities.Model;
import entities.Tile;
import entities.Word;
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

		if (clickedTile.isEnabled()) {
			Coordinate currentTile = m.getBoard().getSelectedTileCoords();
			boolean firstTile = false;
			if (currentTile.x < 0) {
				firstTile = true;
			}
			if(firstTile || ((Math.abs(x - currentTile.x) < 2) && (Math.abs(y - currentTile.y) < 2) && (!clickedTile.isSelected()))) {
				clickedTile.setSelection(true);
				if (clickedTile.isSelected()) {
					if (clickedTile.getLetter() == 'Q') {
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
