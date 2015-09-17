import java.util.ArrayList;


public class Driver {
	
	public static void main(String[] args) {
		Stack s = new Stack();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hi");
		list.add("This is a test print.");
		list.add("Trying to see if it works.");
		
		for(String word : list) {
			s.push(word);
			System.out.println(s.toString());
		}
		/* Pops off from front of list */
		String popped = (String)s.pop();
		System.out.println(popped);
	}

}
