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

public class DeleteLevelButtonController implements ActionListener {

	private Model m;
	private BuildField b;
	//private SaveSelectionWindow saveSelectionWindow;
	
	public DeleteLevelButtonController(Model m, BuildField b){
		this.m = m;
		this.b = b;
		//this.saveSelectionWindow = saveSelectionWindow;
	}

	// NOTE: Don't test this...
	@Override
	public void actionPerformed(ActionEvent ae) {
		int levelNum = m.getLevelSaverInt();
		this.deleteLevel("levels/" + levelNum);
	}

	public void deleteLevel(String filename){
		System.out.println("Deleting file: " + filename);
		File file = new File(filename);
		file.delete();
		b.setVisible(false);
		b.dispose();
		new BuildField().setVisible(true);
	}
	
}
