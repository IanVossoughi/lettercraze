package controllers;

import entities.Model;
import junit.framework.TestCase;

public class TestPreviewButtonController extends TestCase {
	Model m1, m2;

	@Override
	protected void setUp() {
		m1 = new Model();
		m2 = new Model();
	}

	public void testPreviewButton() {
		PreviewButtonController pbc = new PreviewButtonController(m1);
		pbc.actionPerformed(null);
	}
}
