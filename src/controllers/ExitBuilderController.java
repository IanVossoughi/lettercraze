package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;
import builderBoundary.BuildMain;
import builderBoundary.SaveSelectionWindow;
import entities.Model;

public class ExitBuilderController implements ActionListener {

	private BuildField buildField;
	private Model m;

	public ExitBuilderController(BuildField buildField) {
		this.buildField = buildField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buildField.setVisible(false);
		buildField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildField.dispose();
	}
}