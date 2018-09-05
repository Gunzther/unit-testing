import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}
	
	@Test
	public void testElementNotContained(){
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(-1, StringUtil.indexOf("Mango", fruit));
		assertEquals(-1, StringUtil.indexOf("Blueberry", fruit));
	}
}
