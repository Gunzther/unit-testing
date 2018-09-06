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
	public void testIndexDoubleElement() {
		String[] emp = {"A", "B", "A"};
		assertEquals(0, StringUtil.indexOf("A", emp));
	}
	
	@Test	
	public void testEmptyArray() {
		String[] real_emp = {};
		assertEquals(-1, StringUtil.indexOf("", real_emp));
	}
	
	@Test	
	public void testIndexDNE() {
		String[] car = {"Porsche", "Toyota", "Mazda"};
		assertEquals(-1, StringUtil.indexOf("BMW", car));
	}
}
