package controllers;

import builderBoundary.BuildField;
import entities.Model;
import junit.framework.TestCase;

public class TestPreviewButtonController extends TestCase {
	Model m1, m2;
	BuildField b;

	@Override
	protected void setUp() {
		m1 = new Model();
		m2 = new Model();
		b = new BuildField();
	}

	public void testPreviewButton() {
		PreviewButtonController pbc = new PreviewButtonController(m1,b);
		pbc.actionPerformed(null);
	}
}
