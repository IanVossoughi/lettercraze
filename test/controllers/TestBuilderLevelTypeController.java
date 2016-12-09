package controllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import builderBoundary.BuildField;
import entities.Model;
import junit.framework.TestCase;

public class TestBuilderLevelTypeController extends TestCase {
	BuildField buildField;
	Model model;
	JComboBox<String> levelTypeCombo;
	JTextField timeField;
	JTextField wordEntryField;
	JButton generateButton;
	@Override
	public void setUp(){
		model = new Model();
		buildField = new BuildField();
		levelTypeCombo = buildField.getlevelTypeCombo();
		levelTypeCombo.setEnabled(true);
		timeField = buildField.getTimeField();
		timeField.setEnabled(true);
		wordEntryField = buildField.getWordEntryField();
		wordEntryField.setEnabled(true);
		generateButton = buildField.getGenerateButton();
		generateButton.setEnabled(true);
	}
	public void testChooseLevelType(){
		//puzzle selected
		levelTypeCombo.setSelectedIndex(0);
		BuilderLevelTypeController blc1 = new BuilderLevelTypeController(buildField, model);
		blc1.actionPerformed(null);
		assertFalse(timeField.isEnabled());
		assertFalse(wordEntryField.isEnabled());
		assertFalse(generateButton.isEnabled());

		//lightning selected
		levelTypeCombo.setSelectedIndex(1);
		BuilderLevelTypeController blc2 = new BuilderLevelTypeController(buildField, model);
		blc2.actionPerformed(null);
		assertTrue(timeField.isEnabled());
		assertFalse(wordEntryField.isEnabled());
		assertFalse(generateButton.isEnabled());


		//puzzle selected
		levelTypeCombo.setSelectedIndex(2);
		BuilderLevelTypeController blc3 = new BuilderLevelTypeController(buildField, model);
		blc3.actionPerformed(null);
		assertFalse(timeField.isEnabled());
		assertTrue(wordEntryField.isEnabled());
		assertTrue(generateButton.isEnabled());
	}
}
