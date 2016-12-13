package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Board;
import entities.Model;
import entities.Score;
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
		File openFile = new FilePicker(contentPane).open();
		if (openFile != null) {
			String name = openFile.getAbsolutePath();
			System.out.println("Opening level " + name);
			loadLevel(name);
			b.refreshBoard();
		}
	}
	
	/*
	 * Loads the level file with the given name into the Model.
	 */
	public void loadLevel(String filename) {
		//Board newBoard = new Board();
		//Model m = new Model();
		m.setBoard(new Board());
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
					//System.out.print(nextChar);
					//newBoard.tiles[x][y] = newTile;
					m.getBoard().tiles[x][y] = newTile;
				}
				//System.out.print("\n");
			}
			
			// Next get the title;
			in.read();
			
			//System.out.println(nextField(in)); // Star points
			String[] d = nextField(in).trim().split(" ");
			//for(String k : d) System.out.println(k + "|");
			int[] loadedScores = {Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])};
			m.setScore(new Score(loadedScores));
			
			//System.out.println(nextField(in)); // Word list 
			for(String word : nextField(in).split(" ")){
				m.addWordListModel(word);
			}
			
			//System.out.println(nextField(in)); // Title
			String title = nextField(in);
			//System.out.println(title);
			m.setTitle(title);
			if(b != null)
				b.getlevelNameField().setText(title);
			
			
			//System.out.println(nextField(in)); // level type
			int levelIndex = Integer.parseInt(nextField(in));
			if(b != null)
				b.getlevelTypeCombo().setSelectedIndex(levelIndex);
			
			//System.out.println(nextField(in)); // Timer amount
			int timeLeft = Integer.parseInt(nextField(in));
			m.setTime(timeLeft);
			if(b != null)
				b.getTimeField().setText(timeLeft + "");
			
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//m.board = newBoard;
	}
	
	// Returns the string in the file up until we see a '\n'
	protected String nextField(FileInputStream in) throws IOException{
		char c = 0;
		String curr = "";
		while((c = (char) in.read()) != '\n'){
			curr = curr + c;
		}
		return curr;
	}

}
