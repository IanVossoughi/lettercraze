/*

package controllers;
 

import entities.Model;
import junit.framework.TestCase;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import builderBoundary.BuildField;

public class TestResetBuilderController extends TestCase {

	BuildField bf;
	
	@Override
	protected void setUp() {
		bf = new BuildField();
		bf.setVisible(true);

	}
	@Override
	protected void tearDown() {
		bf.dispose();
	}


	public void testResetBuilderController(){
		
		assertTrue(bf.isVisible());
		ResetBuilderController reset = new ResetBuilderController(bf);
		
		
		
		reset.actionPerformed(null);
		assertFalse(bf.isVisible());
		
		bf.setVisible(true);
		ResetBuilderController cancel = new ResetBuilderController(bf);
		cancel.actionPerformed(null);
		assertTrue(bf.isVisible());
	}
}
*/
