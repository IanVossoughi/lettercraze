package controllers;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FilePicker {

	protected JPanel panel;
	
	public FilePicker(JPanel panel){
		this.panel = panel;
	}
	
	public String open(){
		JFileChooser chooser = new JFileChooser();
		if(chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile().getName();
		}
		return null;
	}
	
	public String save(){
		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile().getName();
		}
		return null;
	}
}
