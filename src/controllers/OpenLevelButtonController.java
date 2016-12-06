package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class OpenLevelButtonController implements ActionListener {
	
	protected JPanel contentPane;
	
	// This class is for the builder's open level dialog
	public OpenLevelButtonController(JPanel contentPane){
		this.contentPane = contentPane;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = new FilePicker(contentPane).open();
		System.out.println("Opening level " + name);
	}

}
