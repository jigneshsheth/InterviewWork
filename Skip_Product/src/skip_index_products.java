
public class skip_index_products {

	public static void main(String[] args) {
		int[] array = {1, 7, 3, 4};
		array = get_products_of_all_ints_except_at_index(array);
		for(int x : array){
			System.out.print(x + " ");
		}

	}

	public static int[] get_products_of_all_ints_except_at_index(int[]arr) {
		int[] storage = new int[arr.length];
		for(int i = 0; i < storage.length; i++) {
			storage[i] = 1;
		}
		/*
	    # for each integer, we find the product of all the integers
	    # before it, storing the total product so far each time */
		int product = 1;
		int i = 0;
		while(i < arr.length) {
			storage[i] = product;
			product *= arr[i];
			i++;
		}

	    /*for each integer, we find the product of all the integers
	    # after it. since each index in products already has the
	    # product of all the integers before it, now we're storing
	    # the total product of all other integers */
		product = 1;
		i = arr.length - 1;
		while(i >= 0) {
			storage[i] *= product;
			product *= arr[i];
			i--;
		}
		
		return storage;
	}
}
