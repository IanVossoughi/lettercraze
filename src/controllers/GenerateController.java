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
	 * Take the letters of a single word and draw them into a random sequence across a 6 by 6 grid of "tile" Strings, as long
	 * as there is sufficient room to fit the new word.
	 * @param level The 6-by-6 array of Strings, each of which will contain one character from the words added into them
	 * @param string The word to be split into one-character substrings and distributed in a contiguous sequence across the board
	 * @return An updated version of the level array that contains the letters of the passed words (if there is room to add them)
	 * @throws Exception If the builder's word is too large for the board or their are insufficient empty tiles to fit the new word
	 */
	private String[][] addWord(String[][] level, String string) throws Exception {
		int[] pos = addRandomLetter(level, string);
		for(int i = 1; i<string.length(); i++){ 
			String c = Character.toString(string.charAt(i));
			pos = addLetterAroundPosition(pos, level, c);
		}
		
		return level;
	}
	
	/**
	 * Given a position on the board, attempt to place a letter around it. There are only four places the new letter
	 * can go, and if there is no space available, this method will fail and throw and exception.
	 * @param pos An array of integers containing the x and y position of the selected tile that the
	 * new letter will go.
	 * @param level The current array of tiles representing the board.
	 * @param c The letter that will be added if this method finds a space for it.
	 * @return Returns an integer array containing the position of the tile that the new letter was added to.
	 * This position will make up the start to the next position.
	 * @throws Exception Throws an exception if there are no spaces available around the tile.
	 * Now that I think about it, this takes a very roundabout way of doing this, but ensures that
	 * it completely random. So that's nice.
	 */
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
	/**
	 *  While the previous level adds a random tile around a position, 
	 *  this method generates that random position if we are starting a word.
	 *  It generates the random position over and over until a spot is found
	 *  that doesn't currently have a tile in it.
	 * @param level An array representing the current board
	 * @param l The letter that will be added, starting the new word.
	 * @return Returns an integer of the random position that was selected, 
	 * starting the new word.
	 * @throws An exception is thrown if there is no space available to start the word,
	 * (if after 300 random tries no tile has been found).
	 */
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
