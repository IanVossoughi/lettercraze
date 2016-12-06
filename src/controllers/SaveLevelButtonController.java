package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Model;

public class SaveLevelButtonController implements ActionListener {

	private Model m;
	private JPanel contentPane;
	
	public SaveLevelButtonController(Model m, JPanel contentPane){
		this.m = m;
		this.contentPane = contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String filename = new FilePicker(contentPane).save();
		this.saveLevel(filename);	
	}
	
	public void saveLevel(String filename){
		System.out.println("Saving file: " + filename);
		
	}
	
}
