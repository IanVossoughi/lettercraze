package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import builderBoundary.BuildField;
import builderBoundary.SaveSelectionWindow;
import entities.Board;
import entities.Model;
import entities.Score;
import entities.Tile;
import general.LetterFrequencyFast;
import general.UndoArray;

/**
 *  Controls all actions related to the Builder Open Level Menu item, 
 *  specifically selecting one level from the fifteen listed on the Builder 
 *  after either saving or discarding changes on the currently open level.
 * <p>
 * Creation date: (12/15/16 8:12:25 PM)
 * @author Ian Vossoughi
 */
public class OpenLevelButtonController implements ActionListener {
	
	/** The builder boundary that we are manipulating and using to begin the action. */
	protected JPanel contentPane;
	
	/** The highest level entity model.*/
	protected Model m;
	
	/** The builder boundary that we are manipulating and using to begin the action. */
	protected BuildField b;

	/**
	 * OpenLevelButtonController constructor comment.
	 */
	// This class is for the builder's open level dialog
	public OpenLevelButtonController(Model m, JPanel contentPane, BuildField buildField){
		this.contentPane = contentPane;
		this.m = m;
		this.b = buildField;
	}
	

	/**
	 * Coordinate reaction to clicking the Open Level menu item, prompting the user to 
	 * open 1 of 15 level options to edit.
	 * <p>
	 * @param e controllers.OpenLevelButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = m.getLevelSaverInt()  + "";
		loadLevel("levels/" + name, m, b);
		b.refreshBoard();
		
	}
	
	/**
	 * Loads the level file with the given name into the Model.
	 */
	public static void loadLevel(String filename, Model m, BuildField b) {
		while(UndoArray.getInstance().getIndex() > -1) {
			UndoArray.getInstance().removeUndoModel();
		}

		m.setBoard(new Board());
		try {
			FileInputStream in = new FileInputStream(filename);
			for(int x = 0; x < 6; x++){
				for(int y = 0; y < 6; y++){
					char nextChar = (char) in.read();
					Tile newTile = new Tile(Character.toString(nextChar));
					if(nextChar == '!'){
						newTile.setEnabled(false);
					}
					else if (nextChar == '_'){
						newTile.setEnabled(true);
						newTile.setLetter(LetterFrequencyFast.getInstance().getRandomLetter()); 
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
			
			if(b != null) {
				while(!m.getWordListModel().isEmpty()) {
					m.removeWordListModel(0);
				}
			}
		
			
			for(String word : nextField(in).split(" ")){
				//m.addWordListModel(word);
				m.addThemeWord(word);
				if (b != null) {
					m.addWordListModel(word);
				}
			}
			
			String title = nextField(in);
			m.setTitle(title);
			if(b != null)
				b.getlevelNameField().setText(title);
			
			int levelIndex = Integer.parseInt(nextField(in));
			
			if (filename.equals("levels/temp")) {
				m.setSelectedTab(0);
			} else 
				m.setSelectedTab(Integer.parseInt(filename.substring(7))-1);
			
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
			System.out.println("Level not found - " + filename );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the string in the file until a \n appears.
	 */
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
