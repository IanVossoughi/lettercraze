package playerBoundary;

import junit.framework.TestCase;

public class TestOne extends TestCase {
	Main something;
	
	@Override
	protected void setUp() {
		something = new Main();
	}
	@Override
	protected void tearDown() {
		something.dispose();
	}
	public void testInit(){
		assertEquals(1,1);
	}
}
