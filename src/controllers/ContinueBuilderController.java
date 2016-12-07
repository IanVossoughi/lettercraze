package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.BuildField;
import builderBoundary.BuildMain;

public class ContinueBuilderController implements ActionListener {

	private BuildMain buildMain;

	public ContinueBuilderController(BuildMain buildMain) {
		this.buildMain = buildMain;	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new BuildField().setVisible(true);
		buildMain.setVisible(false);
		buildMain.dispose();
	}

}
