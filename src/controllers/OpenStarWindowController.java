package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.StarThresholdWindow;
import entities.Model;

public class OpenStarWindowController implements ActionListener {

	protected Model m;
	
	public OpenStarWindowController(Model m){
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StarThresholdWindow thresholdWindow = new StarThresholdWindow(m);
		thresholdWindow.setVisible(true);

	}

}
