package controllers;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FilePicker {

	protected JPanel panel;
	
	public FilePicker(JPanel panel){
		this.panel = panel;
	}
	
	public File open(){
		JFileChooser chooser = new JFileChooser();
		if(chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile();
		}
		return null;
	}
	
	public File save(){
		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile();
		}
		return null;
	}
}