package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import entities.Model;

public class GenerateController implements ActionListener {

	private Model m;
	private BuildField builder;
	
	public GenerateController(Model m, BuildField builder){
		this.m = m;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Generating level with words:" + m.getWordListModel().toString());

	}

}
