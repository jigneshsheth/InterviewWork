
public class Sorter {
	
	/**
	 * Selection sort of students from our records.
	 * Algorithm: During each pass, the unsorted element with 
	 * the smallest value is moved to its proper position in the array.
	 * The number of times the sort passes through the array is one less
	 * than the number of items in the array.
	 * O(n^2) as it loops over twice. There is no way to end the sort early,
	 * even if the list is already sorted.
	 * Sort Records based off of Last Name
	 * 
	 * Example: {5, 1, 12, -5, 16, 2, 12, 14}
	 * iteration 0: 5, 1, 12, -5, 16, 2, 12, 14
	 * iteration 1: -5, 1, 12, 5, 16, 2, 12, 14
	 * iteration 2: -5, 1, 12, 5, 16, 2, 12, 14
	 * iteration 3: -5, 1, 2, 5, 16, 12, 12, 14
	 * iteration 4: -5, 1, 2, 5, 12, 16, 12, 14
	 * iteration 5: -5, 1, 2, 5, 12, 12, 16, 14
	 * iteration 6: -5, 1, 2, 5, 12, 12, 14, 16
	 * 
	 * Analysis: On every step number of unsorted elements decreases by one. Therefore
	 * selection sort makes n steps of outer loop before stopping. Every step of outer loop
	 * requires finding the min in the unsorted portion. n + (n-1) + (n-2) + ... + 1 O(n^2)
	 * 
	 * USE: If writer operation is significantly more expensive than read, the selection sort
	 * algorithm is quite efficient as it requires n-1 number of swaps at most.
	 * @param students
	 */
	public static void selectionSort(Record[] students) {
		int i, j, minIndex;
		Record tmp;
		int n = students.length;
		for(i = 0; i < n-1; i++) { // Loop from first element to the end-1
			minIndex = i;			// Keep track of the min guy
			for(j = i + 1; j < n; j++) { // Loop from every elem after i to end
				if(students[j].getLastName().compareTo(students[minIndex].getLastName()) < 0) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				tmp = students[i];
				students[i] = students[minIndex];
				students[minIndex] = tmp;
			}
		}
		for(Record r : students) {
			System.out.println(r.toString());
		}
	}
	
	/**
	 * Insertion sort of students from our records.
	 * Algorithm of insertion sort:
	 * Array is imaginarily divided into two parts- sorted and unsorted.
	 * At the start, the sorted part contains the first element of the array 
	 * and the unsorted one contains the rest.
	 * At every step, algorithm takes first element in the unsorted part and inserts
	 * it to the right place of the sorted one. When unsorted becomes empty, algorithm stops 
	 * 
	 * Example: {7, -5, 2, 16, 4}
	 * 
	 * Iteration 0: 7, -5, 2, 16, 4
	 * Iteration 1: -5, 7, 2, 16, 4
	 * Iteration 2: -5, 2, 7, 16, 4
	 * Iteration 3: -5, 2, 7, 16, 4
	 * Iteration 4: -5, 2, 4, 7, 16
	 * 
	 * Complexity: O(n^2) in the average case. If we apply insertion sort to a 
	 * sorted array it will take O(n) time. Number of writes is O(n^2) on average, but
	 * number of comparisons may vary depending on the insertion algorithm. It is 
	 * O(n^2) when while shifting or swapping methods are used and O(nlogn) for binary insertion sort.
	 * 
	 * @param students
	 */
	public static void insertionSort(Record[] students) {
		for(int index = 1; index < students.length; index++) {
			Record key = students[index];
			int position = index;
			// Shift larger values to the right
			while(position > 0  && key.getLastName().compareTo(students[position-1].getLastName()) < 0) {
				students[position] = students[position-1];
				position--;
			}
			students[position] = key;
		}
		for(Record r : students) {
			System.out.println(r.toString());
		}
	}

}
