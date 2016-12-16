package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import builderBoundary.SaveSelectionWindow;
import entities.Model;
import entities.Word;

/**
 *  Controls all actions related to the Builder Save Level Menu option.
 * <p>
 * Creation date: (12/15/16)
 * @author Andrew Vanner
 */
public class SaveLevelButtonController implements ActionListener {

	/** The highest level entity model.*/
	private Model m;
	/** The builder boundary that we are manipulating and using to begin the action. */
	private JPanel contentPane;
	
	/**
	 * SaveLevelButtonController constructor comment.
	 */
	public SaveLevelButtonController(Model m){
		this.m = m;
		this.contentPane = contentPane;
	}

	/**
	 * Coordinate reaction to clicking the Save Level Menu item
	 * Gives the user a list of level names to save into
	 * <p>
	 * @param e controllers.SaveLevelButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		int levelNum = m.getLevelSaverInt();
		this.saveLevel("levels/" + levelNum);
		//JOptionPane.showMessageDialog(null, "Level Saved.");
	}
	
	/**
	 * Saves a textual representation of the game's board.
	 * If a tile is active, it will store the tile's character.
	 * If a tile is inactive, it will store the sentinel value '!'.
	 */
	public void saveLevel(String filename){
		System.out.println("Saving file: " + filename);
		FileOutputStream out;
		try {
			out = new FileOutputStream(filename);
			
			//Letters of boards
			out.write(m.getBoard().serialize().getBytes());
			out.write('\n');
			
			
			//Stars
			out.write(m.getScore().serialize().getBytes());
			out.write('\n');
			
			for(Object w : m.getWordListModel().toArray()){
				String s = (String)w;
				out.write((s+" ").getBytes());
			}
			out.write('\n');
			
			out.write(m.getTitle().getBytes());
			out.write('\n');
			
			out.write((m.getType() + "").getBytes());
			out.write('\n');
			
			out.write((m.getTime() + "").getBytes());
			out.write('\n');
			out.write((m.getLimit() + "").getBytes());
			out.write('\n');
			
			out.write('\n');
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
