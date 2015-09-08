/* Node class to create Node Object
 * for the Linked List class. Contains
 * constructor for the object and all
 * access methods. Has pointer to next as 
 * well. Singly Linked List.
 */
public class Node {

	private Object data;
	private Node next;
	
	public Node(Object data) {
		this.data = data;
		next = null;
	}
	
	public Node(Object data, Node node) {
		this.data = data;
		this.next = node;
	}
	
	public Object getObject() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node n) {
		this.next = n;
	}
	
	public void setData(Object d) {
		this.data = d;
	}
}
