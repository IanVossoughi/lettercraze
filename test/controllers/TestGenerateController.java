package controllers;

import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;
import junit.framework.TestCase;
import playerBoundary.Main;

public class TestGenerateController extends TestCase {
	Model m;
	BuildField buildField;
	JButton[][] tileArray;
	Tile tile;

	@Override
	protected void setUp() {
		m = new Model();
		buildField = new BuildField();
		
		tile = m.getBoard().tiles[1][1];
		tile.setEnabled(true);
	}

	public void testGenerateController() {
		GenerateController gc = new GenerateController(m, buildField, tileArray);
		gc.actionPerformed(null);
		assertTrue(tile.isEnabled());
		
		
	}

}