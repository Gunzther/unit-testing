/**
 * Some linear algebra methods, for testing.
 * 
 * @author Korawit Rupanya
 *
 */
public class ArrayMath {

	/**
	 * Compute dot product of two vectors.If the vectors don't have the same length,Then 
	 * compute base on the shorter vectors.
	 * 
	 * @param x first vector to multiply
	 * @param y second vector to multiply
	 * @return dot-product of x and y
	 */
	public static double dotProduct(double[] x, double[] y) {
		int size1 = x.length;
		int size2 = y.length;
		double product = 0.0;
		if (size1 <= size2) {
			for (int k = 0; k < size1; k++) {
				product += x[k] * y[k];
			}
		} else if (size1 > size2) {
			for (int k = 0; k < size2; k++) {
				product += x[k] * y[k];
			}
		} 
		return product;
	}
}