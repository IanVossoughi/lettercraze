package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Board;
import entities.Model;
import entities.Tile;

public class OpenLevelButtonController implements ActionListener {
	
	protected JPanel contentPane;
	protected Model m;
	protected BuildField b;
	
	// This class is for the builder's open level dialog
	public OpenLevelButtonController(Model m, JPanel contentPane, BuildField buildField){
		this.contentPane = contentPane;
		this.m = m;
		this.b = buildField;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = new FilePicker(contentPane).open().getAbsolutePath();
		System.out.println("Opening level " + name);
		loadLevel(name);
		b.refreshBoard();
	}
	
	/*
	 * Loads the level file with the given name into the Model.
	 */
	private void loadLevel(String filename) {
		//Board newBoard = new Board();
		//Model m = new Model();
		m.board = new Board();
		try {
			FileInputStream in = new FileInputStream(filename);
			for(int x = 0; x < 6; x++){
				for(int y = 0; y < 6; y++){
					char nextChar = (char) in.read();
					Tile newTile = new Tile(nextChar);
					if(nextChar == '!'){
						
					} else {
						newTile.toggleEnabled();
					}
					System.out.print(nextChar);
					//newBoard.tiles[x][y] = newTile;
					m.board.tiles[x][y] = newTile;
				}
				System.out.print("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//m.board = newBoard;
	}

}
