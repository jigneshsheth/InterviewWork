import java.util.HashSet;
import java.util.Set;


public class ArrayQuestions {

	public static void main(String args[]) {
		int [] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
		findPairsOfSums(arr, 4);
		
	}
	
	/* In an array 1-100 numbers are stored, one number is missing how do you find it? */
	public static int findMissingNumber(int[] arr, int count) {
		// Find the sum of N numbers
		// Find the sum of the array
		// Take the diff, that is the missing number
		
		// Sum of N number is n(n+1)/2
		int sum_of_n = count*((count + 1)/2);
		// Take a running sum of the array
		int arr_sum = 0;
		for(int i = 0; i < arr.length; i++) {
			arr_sum += arr[i];
		}
		
		return (sum_of_n - arr_sum);
	}

	/* In an array 1-100 exactly one number is duplicate how do you find it? */
	public static boolean findDuplicateValue(int[] arr) {
		// Put everything in a set. A set does not have duplicate values
		// Compare the lengths
		// If they are not the same then there is a duplicate in the array
		HashSet<Integer> set = new HashSet<Integer>();
		for(int index : arr) {
			if(!set.add(index)) {
				return true;
			}
		}
		return false;
		
	}

	/* How do you find second highest number in an integer array? */
	public static int findSecondHighest(int[] arr) {
		if(arr.length == 0) { return arr[0]; }
		/**
		 * Keep track of the max and the max index
		 * Store them and then iterate over the array
		 * as long as index isn't maxindex we store the
		 * second max. Return that value.
		 */
		int maxIndex = 0;
		int max = 0;
		int secondMax = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > secondMax && j != maxIndex) {
				secondMax = arr[j];
			}
		}
		return secondMax;
	}
	/**
	 * Same as program above but only iterates the array once.
	 * We keep track of both max values each time through the list
	 * and update both if they are both larger or only one if one
	 * is larger. By the end, we have the top two largest values.
	 * @param numbers
	 */
	public static void topTwo(int[] numbers) { 
		int max1 = Integer.MIN_VALUE; 
		int max2 = Integer.MIN_VALUE; 
		for (int number : numbers) { 
			if (number > max1) { 
				max2 = max1; 
				max1 = number; 
			} 
			else if (number > max2) { 
				max2 = number; 
				} 
			}
	}
	
	/* How to find all pairs in array of integers whose sum is equal to given number? */
	public static void findPairsOfSums(int[] numbers, int n) {
		if(numbers.length < 2){ return; } 
		Set set = new HashSet(numbers.length); 
		for(int value : numbers) { 
			int target = n - value; 
			// if target number is not in set then add 
			if(!set.contains(target)){ 
				set.add(value); 
			}
			else { 
				System.out.printf("(%d, %d) %n", value, target); 
			} 
		}

	}


}
