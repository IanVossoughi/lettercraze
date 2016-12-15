package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Board;
import entities.Model;
import entities.Score;
import entities.Tile;
import general.LetterFrequencyFast;
import general.UndoArray;

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
			loadLevel(name, m, b);
			b.refreshBoard();
		}
	}
	
	/*
	 * Loads the level file with the given name into the Model.
	 */
	public static void loadLevel(String filename, Model m, BuildField b) {
		m.setBoard(new Board());
		while(UndoArray.getInstance().getIndex() > -1) {
			UndoArray.getInstance().removeUndoModel();
		}
		try {
			FileInputStream in = new FileInputStream(filename);
			for(int x = 0; x < 6; x++){
				for(int y = 0; y < 6; y++){
					char nextChar = (char) in.read();
					Tile newTile = new Tile(Character.toString(nextChar));
					if(nextChar == '!'){
						newTile.setEnabled(false);
						//newTile.setLetter("q");
					}
					else if (nextChar == '_'){
						newTile.setEnabled(true);
						newTile.setLetter(LetterFrequencyFast.getInstance().getRandomLetter()); //Andrew
					}
					else {
						newTile.setEnabled(true);
					}
					m.getBoard().tiles[x][y] = newTile;
				}
			}
			
			// Next get the title;
			in.read();
			
			String[] d = nextField(in).trim().split(" ");
			int[] loadedScores = {Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])};
			m.setScore(new Score(loadedScores));
			
			//DefaultListModel<String> newModel = new DefaultListModel<String>();
			//m.setWordListModel(newModel);
			if(b != null) {
				while(!m.getWordListModel().isEmpty()) {
					m.removeWordListModel(0);
				}
			}
			for(String word : nextField(in).split(" ")){
				m.addThemeWord(word);
				if(b != null) {
					m.addWordListModel(word);
				}
			}

			
			String title = nextField(in);
			m.setTitle(title);
			if(b != null)
				b.getlevelNameField().setText(title);
			
			
			int levelIndex = Integer.parseInt(nextField(in));
			m.setSelectedTab(levelIndex);
			m.setType(levelIndex);
			if(b != null)
				b.getlevelTypeCombo().setSelectedIndex(levelIndex);
			
			int timeLeft = Integer.parseInt(nextField(in));
			m.setTime(timeLeft);
			if(b != null)
				b.getTimeField().setText(timeLeft + "");
			
			int limit = Integer.parseInt(nextField(in));
			m.setLimit(limit);
			if(b != null)
				b.getWordLimitField().setText(limit + "");
			
			
			in.close();
		} catch (FileNotFoundException e) {
			m.setTitle("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Returns the string in the file up until we see a '\n'
	protected static String nextField(FileInputStream in) throws IOException{
		char c = 0;
		String curr = "";
		while((c = (char) in.read()) != '\n'){
			curr = curr + c;
		}
		return curr;
	}

}
