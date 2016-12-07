package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import builderBoundary.BuildField;
import entities.Model;

public class BuilderLevelTypeController implements ActionListener {

	private BuildField buildField;
	private Model m;

	public BuilderLevelTypeController(BuildField buildField, Model m) {
		this.buildField = buildField;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}	
}

