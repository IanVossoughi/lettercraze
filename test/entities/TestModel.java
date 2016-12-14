package entities;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	Model m;
	int size;
	
	@Override
	protected void setUp() {
		m = new Model();
		
		m.addWordListModel("test");
		m.addWordListModel("word");
		size = 2;
	}

	public void testWordListModel() {
		assertEquals(size, m.wordListModel.getSize());
		m.removeWordListModel(0);
		assertEquals(1, m.wordListModel.getSize());
	}
}