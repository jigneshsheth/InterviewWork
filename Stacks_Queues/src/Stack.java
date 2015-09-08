/**
 * Stack Implementation using linked list.
 * @author paul
 *
 */
public class Stack {
	
	private Node top; // Pointer to top of stack
	
	public Stack() {
		top = null; // Create the stack. Top is empty.
	}
	
	/* Check to see if stack is empty */
	public boolean isEmpty() {
		return top == null;
	}
	
	/* Clean the stack out */
	public void clean() {
		top = null;
	}
	
	/* Push to the top of the stack */
	public void push(String item) {
		top = new Node(item, top);
	}
	
	/* Pop off the top of the stack */
	public Object pop() {
		if(isEmpty()) {
			return null;
		}
		
		String item = top.item;
		top = top.next;
		return item;
	}
	
	public String toString()
	{
		return top.item;
	}
}
