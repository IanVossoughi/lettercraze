package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;

import builderBoundary.BuildField;
import entities.Model;

public class GenerateController implements ActionListener {

	private Random rng;
	private Model m;
	private BuildField builder;
	
	public GenerateController(Model m, BuildField builder){
		this.m = m;
		this.builder = builder;
		this.rng = new Random();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Generating level with words:" + m.getWordListModel().toString());
		char[][] level = generate(m.getWordListModel());
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				System.out.print(level[x][y]);
			}
			System.out.println("");
		}
	}

	private char[][] generate(DefaultListModel<String> wordListModel) {
		char[][] level = new char[6][6];
		for(int x = 0; x < 6; x++){
			for(int y = 0; y < 6; y++){
				level[x][y] = '_';
			}
		}
		
		
		try {
			char[][] levelAdded = addWord(level, wordListModel.get(0));
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
		for(int i = 0; i<50; i++){
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
		
		for(int i = 0; i<50; i++){
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
