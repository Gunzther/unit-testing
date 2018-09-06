import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals( x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals( 123.015, Statistics.average(y), TOL);
	}
	
	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for(int k=0; k<=n/2; k++) {
			x[k] -= 0.5*k;
			x[n-k-1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalVarianceCase() {
		double[] x = {};
		Statistics.variance(x);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalCovarianceCase() {
		double[] x = {1,2,3,4};
		double[] y = {1,2};
		double[] z = {};
		Statistics.covariance(x, y);
		Statistics.covariance(x, z);
	}
	
	@Test
	public void testVeryLargeArray() {
		double[] x = new double[100000];
		double[] y = new double[100000];
		java.util.Arrays.fill(x, 15);
		java.util.Arrays.fill(y, 12);
		assertEquals(0, Statistics.variance(x), TOL);
		assertEquals(0, Statistics.covariance(x, y), TOL);
	}
	
	@Test
	public void testVeryDifferentValue() {
		double[] x = {1,5000,20,3};
		double[] y = {30000,8,20,9};
		assertEquals(4672566.5, Statistics.variance(x), TOL);
		System.out.println(Statistics.covariance(x, y));
		assertEquals(-9414011.25, Statistics.covariance(x, y), TOL);
	}
	
	@Test
	public void testVariance() {
		double[] x = {1,2,3,4};
		double[] y = {1,1,1};
		assertEquals(1.25, Statistics.variance(x), TOL);
		assertEquals(0, Statistics.variance(y), TOL);
	}
	
	
	@Test
	public void testCovariance() {
		double[] x = {1,2,3,4};
		double[] y = {1,1,2,2};
		double[] z = {1,1,2,2};
		assertEquals(0.5, Statistics.covariance(x, y), TOL);
		assertEquals(0.25, Statistics.covariance(y, z), TOL);
	}
}
