package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import builderBoundary.BuildField;
import entities.Model;
import entities.Tile;
import playerBoundary.PlayField;

public class GenerateController implements ActionListener {

	private Random rng;
	private Model m;
	private BuildField builder;
	private JButton[][] tileArray;
	
	public GenerateController(Model m, BuildField builder, JButton[][] tileArray){
		this.m = m;
		this.builder = builder;
		this.tileArray = tileArray;
		this.rng = new Random();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Generating level with words:" + m.getWordListModel().toString());
		char[][] level = generate(m.getWordListModel());
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				//System.out.print(level[x][y]);
				
				if(level[x][y] == '!'){
					Tile tile = m.getBoard().tiles[x][y];
					tile.setLetter('!');
					tile.setEnabled(false);
				} else if(level[x][y] != '_'){
					Tile tile = m.getBoard().tiles[x][y];
					tile.setLetter(level[x][y]);
					tile.setEnabled(true);
					
					// Also update the button
					//tileArray[x][y].setEnabled(true);
					//tileArray[x][y].setIcon(new ImageIcon(PlayField.class.getResource("/images/" + level[x][y] + ".png")));
				} else {
					m.getBoard().tiles[x][y].setLetter('_');
					m.getBoard().tiles[x][y].setEnabled(true);
					//tileArray[x][y].setEnabled(false);
				}
			}
			//System.out.println("");
		}
		builder.refreshBoard();
		
		// Now update the model
		
		
	}

	private char[][] generate(DefaultListModel<String> wordListModel) {
		char[][] level = new char[6][6];
		
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				if(m.getBoard().tiles[x][y].isEnabled()){
					level[x][y] = '_';
				} else {
					level[x][y] = '!';
				}
				System.out.print(level[x][y]);
			}
			System.out.println();
		}
		
		
		try {
			char[][] levelAdded = level;
			for(Object word : wordListModel.toArray()){
				String word1 = (String) word;
				word1 = word1.toUpperCase();
				levelAdded = addWord(levelAdded, word1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return level;
	}

	private char[][] addWord(char[][] level, String string) throws Exception {
		
		int[] pos = addRandomLetter(level, string.toCharArray()[0]);
		for(int i = 1; i<string.length(); i++){
			char c = string.charAt(i);
			pos = addLetterAroundPosition(pos, level, c);
		}
		
		return level;
	}
	
	private int[] addLetterAroundPosition(int[] pos, char[][] level, char c) throws Exception{
		for(int i = 0; i<200; i++){
			// Start at a random tile
			int x = rng.nextInt(3)-1;
			int y = rng.nextInt(3)-1;
		
			int newx = pos[0]-x;
			int newy = pos[1]-y;
			
			if(newx < 0 || newx > 5 || newy < 0 || newy > 5){
				continue;
			}
		
			if(level[newx][newy] == '_'){
				// If blank, just put in the char
				level[newx][newy] = c;
				int[] ret = {newx,newy};
				return ret;
			} 
		}
		throw new Exception("Letter could not be placed around other tile");
	}

	// Returns an array with the position of the new tile added.
	private int[] addRandomLetter(char[][] level, char l) throws Exception{
		
		for(int i = 0; i<300; i++){
			// Start at a random tile
			int x = rng.nextInt(6);
			int y = rng.nextInt(6);
		
			if(level[x][y] == '_'){
				// If blank, just put in the char
				level[x][y] = l;
				int[] ret = {x,y};
				return ret;
			} 
		}
		throw new Exception("Letter could not be placed");
		
	}

}
