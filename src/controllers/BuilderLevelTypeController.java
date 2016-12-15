package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import builderBoundary.BuildField;
import entities.Model;

/**
 *  Controls all actions related to manipulating the Builder type Combo Box, 
 *  changing the available type-specific widgets to the relevant ones.
 * <p>
 * Creation date: (12/15/16 6:18:30 PM)
 * @author Ian Vossoughi
 */
public class BuilderLevelTypeController implements ActionListener {

	/** The builder boundary that we are manipulating and using to begin the action. */
	private BuildField buildField;
	
	/** The highest level entity model.*/
	private Model m;
	
	/** The Combo Box that initiated the event. */
	private JComboBox<String> lt;

	/**
	 * BuilderLevelTypeController constructor comment.
	 */
	public BuilderLevelTypeController(BuildField buildField, Model m) {
		this.buildField = buildField;
		this.m = m;
		this.lt = buildField.getLevelTypeCombo();
	}

	/**
	 * Coordinate reaction to changing the currently selected item of the Level Type Combo Box, 
	 * manipulating the Builder widgets to display relevant and hide irrelevant ones.
	 * <p>
	 * @param e controllers.BuilderLevelTypeController.actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Handles timefield
		int index = lt.getSelectedIndex();
		m.setType(index);
		if ((index == 0) || (index == 2)){
			JTextField tempField = buildField.getTimeField();
			tempField.setEnabled(false);
			buildField.setTimeField(tempField);
		}
		else {
			JTextField tempField = buildField.getTimeField();
			tempField.setEnabled(true);
			buildField.setTimeField(tempField);
		}
		
		//Handles wordlist
		if (index == 0) {
			buildField.getTimeField().setVisible(false);
			buildField.getTimeLabel().setVisible(false);
			buildField.getWordLimitField().setVisible(true);
			buildField.getWordLimitLabel().setVisible(true);
		}
		else if (index == 1) {
			buildField.getTimeField().setVisible(true);
			buildField.getTimeLabel().setVisible(true);
			buildField.getWordLimitField().setVisible(false);
			buildField.getWordLimitLabel().setVisible(false);				
		}
		else {
			buildField.getTimeField().setVisible(false);
			buildField.getTimeLabel().setVisible(false);
			buildField.getWordLimitField().setVisible(false);
			buildField.getWordLimitLabel().setVisible(false);	
		}
		if(index != 2) {
			JTextField tempWordField = buildField.getWordEntryField();
			tempWordField.setEnabled(false);
			buildField.setWordEntryField(tempWordField);
			int size = m.getWordListModel().getSize();
			
			//Clears list
			for (int i = 0; i < size; i++) {
				m.removeWordListModel(0); 
			}
			
			JButton tempButton = buildField.getRemoveButton();
			tempButton.setEnabled(false);
	        buildField.setRemoveButton(tempButton);
	        
	        //Take out generate for non-Theme levels
	        JButton tempGen = buildField.getGenerateButton();
	        tempGen.setEnabled(false);
	        buildField.setGenerateButton(tempGen);
	        
		}
		else {
			JTextField tempWordField = buildField.getWordEntryField();
			tempWordField.setEnabled(true);
			buildField.setWordEntryField(tempWordField);
			
			//Enable generate button for theme level
	        JButton tempGen = buildField.getGenerateButton();
	        tempGen.setEnabled(true);
	        buildField.setGenerateButton(tempGen);
		}
		
		// Update the model
		// 0 - puzzle, 1 - lightning, 2 -theme
		m.setType(index);
		buildField.refreshBoard();

	}
}

