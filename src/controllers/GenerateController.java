package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;
import playerBoundary.PlayField;

/**
 *  Controls all actions related to the Builder Generate button, 
 *  specifically transforming the words of the Word List into randomly-distributed shapes in the Tile Array
 *  and filling the rest of the board with randomized Tiles.
 * <p>
 * Creation date: (12/15/16 7:03:21 PM)
 * @author Ian Vossoughi
 */
public class GenerateController implements ActionListener {

	/** Random number generator for determining where to place the next tile of a word.*/
	private Random rng;
	
	/** The highest level entity model.*/
	private Model m;
	
	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField builder;
	
	/** tileArray is unused and archaic, originally used to manipulate the Builder Tiles directly. */
	private JButton[][] tileArray;
	
	/**
	 * GenerateController constructor comment.
	 */
	public GenerateController(Model m, BuildField builder, JButton[][] tileArray){
		this.m = m;
		this.builder = builder;
		this.tileArray = tileArray;
		this.rng = new Random();
	}
	
	/**
	 * Coordinate reaction to pressing the Generate button, manipulating the Builder Tile 
	 * board to transform the Word List words into tile sequences that randomly stretch around the board.
	 * <p>
	 * @param e controllers.BuilderLevelTypeController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String[][] level = generate(m.getWordListModel());
	
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(level[x][y] == "!"){
					Tile tile = m.getBoard().tiles[x][y];
					tile.setLetter("!");
					tile.setEnabled(false);
				} else if(level[x][y] != "_"){
					Tile tile = m.getBoard().tiles[x][y];
					tile.setLetter(level[x][y]);
					tile.setEnabled(true);
					
				} else {
					m.getBoard().tiles[x][y].setLetter("_");
					m.getBoard().tiles[x][y].setEnabled(true);
				}
			}
		}
		builder.refreshBoard();
	}

	/**
	 * Add the letters from each word of the word list, one at a time, to the 2D Level string array through random
	 * distribution. Notify the builder if their words have too many letters to fit in the board.
	 * @param wordListModel The DefaultListModel containing all of the Theme words added to the Builder WordList.
	 * @return A 6-by-6 array of Strings that represent what letter each tile of the board should have after generating
	 * a formation that incorporates the theme words.
	 */
	private String[][] generate(DefaultListModel<String> wordListModel) {
		String[][] level = new String[6][6];
		
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(m.getBoard().tiles[x][y].isEnabled()){
					level[x][y] = "_";
				} else {
					level[x][y] = "!";
				}
			}
		}
		
		
		try {
			String[][] levelAdded = level;
			for(Object word : wordListModel.toArray()){
				String word1 = (String) word;
				word1 = word1.toUpperCase();
				if (word1.contains("QU")) {
					word1 = word1.replaceAll("QU", "Q");
				}
				levelAdded = addWord(levelAdded, word1);
			}
		} catch (Exception e) {
			System.out.println("Letter could not be placed around other tile");
			JOptionPane.showMessageDialog(builder, "Not all of your words could be added to the board. \nPlease shorten your word list and/or its words to make room.");
		}
		for (int x = 0; x < 6; x++) { 
			for (int y = 0; y < 6; y++) {
				if (level[x][y] == "_") {
					
				}
			}
		}
		
		return level;
	}

	/**
	 * 
	 * @param level
	 * @param string
	 * @return
	 * @throws Exception
	 */
	private String[][] addWord(String[][] level, String string) throws Exception {
		int[] pos = addRandomLetter(level, string);
		for(int i = 1; i<string.length(); i++){ 
			String c = Character.toString(string.charAt(i));
			pos = addLetterAroundPosition(pos, level, c);
		}
		
		return level;
	}
	
	private int[] addLetterAroundPosition(int[] pos, String[][] level, String c) throws Exception{
		for(int i = 0; i<200; i++){
			// Start at a random tile
			int x = rng.nextInt(3)-1;
			int y = rng.nextInt(3)-1;
		
			int newx = pos[0]-x;
			int newy = pos[1]-y;
			
			if(newx < 0 || newx > 5 || newy < 0 || newy > 5){
				continue;
			}
		
			if(level[newx][newy] == "_"){
				// If blank, just put in the char
				level[newx][newy] = c;
				int[] ret = {newx,newy};
				return ret;
			} 
		}
		throw new Exception("Letter could not be placed around other tile");
	}

	// Returns an array with the position of the new tile added.
	private int[] addRandomLetter(String[][] level, String l) throws Exception{
		
		l = l.substring(0, 1); // FIX TO AVOID CRASHING
		for(int i = 0; i<300; i++){
			// Start at a random tile
			int x = rng.nextInt(6);
			int y = rng.nextInt(6);
		
			if(level[x][y] == "_"){
				// If blank, just put in the char
				level[x][y] = l;
				int[] ret = {x,y};
				return ret;
			} 
		}
		throw new Exception("Letter could not be placed");
		
	}

}
