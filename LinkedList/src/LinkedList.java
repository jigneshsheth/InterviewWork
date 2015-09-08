
public class LinkedList {
	
	private int list_count;
	private Node head;
	
	/* Constructor for a new linked list. Has pointer to head */
	public LinkedList() {
		head = new Node(null);
		list_count = 0;
	}
	
	/* Inserts a new object to our list */
	public void insert(Object data) {
		Node to_add = new Node(data);
		Node curr_p = head;
		while(curr_p.getNext() != null) {
			curr_p = curr_p.getNext();
		}
		curr_p.setNext(to_add);
		list_count++;
	}
	
	/* Inserts a new object at data location index */
	public void insert_at(Object data, int index) {
		Node to_add = new Node(data);
		Node curr_p = head;
		int i = 0;
		while(i < index && curr_p.getNext() != null) {
			curr_p = curr_p.getNext();
			i++;
		}
		to_add.setNext(curr_p.getNext());
		curr_p.setNext(to_add);
		list_count++;
	}
	
	/* Returns true if data is in list, false otherwise */
	public boolean contains(Object data) {
		Node curr_p = head;
		while(curr_p.getNext() != null) {
			if(curr_p.getObject() == data) {
				return true;
			}
			curr_p = curr_p.getNext();
		}
		return false;
	}
	
	/* Gets the object at index index in list */
	public Object get(int index) {
		if(index <= 0) {
			return null;
		}
		
		Node curr_p = head.getNext();
		int i = 0;
		while(curr_p.getNext() != null && i < index)
		{
			curr_p = curr_p.getNext();
			i++;
		}
		return curr_p.getObject();
	}

	/* Deletes data at index index in list */
	public boolean delete_at(int index) {
		
		if(index < 1 || index > getSize()){
			return false;
		}
		Node curr_p = head;
		for(int i = 0; i < index; i++) {
			if(curr_p.getNext() == null) {
				return false;
			}
			curr_p = curr_p.getNext();
		}
		curr_p.setNext(curr_p.getNext().getNext());
		list_count--;
		return true;
	}
	
	/* Returns the size of the list */
	public int getSize(){
		return list_count;
	}
	
	/* To String method for the list */
	public String toString() {
		Node curr_p = head.getNext();
		String output = "";
		while(curr_p.getNext() != null) {
			output += "[" + curr_p.getObject().toString() + "]";
		}
		return output;
	}
}
