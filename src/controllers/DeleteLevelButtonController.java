package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import builderBoundary.SaveSelectionWindow;
import entities.Model;
import entities.Word;

/**
 *  Controls all actions related to the Builder Delete Menu Button, 
 *  specifically pressing the Delete button on the Delete Level window 
 *  after selecting a level from the drop-down menu to remove the level from disk.
 * <p>
 * Creation date: (12/15/16 6:25:12 PM)
 * @author Ian Vossoughi
 */
public class DeleteLevelButtonController implements ActionListener {

	/** The highest level entity model.*/
	private Model m;
	
	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField b;
	//private SaveSelectionWindow saveSelectionWindow;
	
	/**
	 * DeleteLevelButtonController constructor comment.
	 */
	public DeleteLevelButtonController(Model m, BuildField b){
		this.m = m;
		this.b = b;
	}

	/**
	 * Coordinate reaction to clicking the Delete level window's Delete button, removing the respective level from disk.
	 * <p>
	 * @param ae controllers.DeleteLevelButtonController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		int levelNum = m.getLevelSaverInt();
		this.deleteLevel("levels/" + levelNum);
	}

	/**
	 * Find the level matching the passed filename and remove it from memory
	 * @param filename The name of the level ("levels/" followed by a single number) to be deleted
	 */
	public void deleteLevel(String filename){
		System.out.println("Deleting file: " + filename);
		File file = new File(filename);
		file.delete();
		b.setVisible(false);
		b.dispose();
		new BuildField().setVisible(true);
	}
	
}
