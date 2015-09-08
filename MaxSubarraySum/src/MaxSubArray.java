
public class MaxSubArray {
	
	/* Given an array A, we want to find the sum of
	 * the maximum subarray within that array.
	 * For example, if the array A = [1, 2, -5, 6, 2]
	 * then our max sum would be 8.
	 * Approach: Ignore the sum of the previous
	 * n - 1 elements if the nth element is greater
	 * than the sum.
	 */
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int sum = A[0];
		for(int i = 1; i < A.length; i++) {
			// Math.max function returns the greater
			// of the two compared values.
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = {7,9,-150,-100,25};
		int max = maxSubArray(A);
		System.out.println(max);
	}

}
