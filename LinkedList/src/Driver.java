
public class Driver {

	/* Tester for LinkedList to see if all functions work */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert("1");
		list.insert("2");
		list.insert("3");
		
		System.out.println(list.get(2));
		if(list.delete_at(2)) {
			System.out.println(list.get(2));
		}
		if(list.contains("1")) {
			System.out.println("Contains 1.");
		}
		
		System.out.println("Size of the list is: " + list.getSize());
	}

}
