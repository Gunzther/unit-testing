import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}
	
	@Test
	public void simplytestDotProduct() {
		double[] x = {2.1,5.2,1.3,3.2,5.6};
		double[] y = {7.5,4.2,3.3,2.2,1.6};
		double notexpected = x[1]*y[1];
		assertNotEquals( notexpected, ArrayMath.dotProduct(x, y), TOL);
		assertNotEquals( notexpected, ArrayMath.dotProduct(y, x), TOL);
		
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}
	
	@Test
	public void testDotProductWithdiffernceDimension() {
		double[] x = {2.1,5.2,1.3,3.2,5.6};
		double[] y = {7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
	}
	
}