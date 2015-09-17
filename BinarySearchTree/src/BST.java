
public class BST {
	
	private BSTNode root;
	
	public BST() {
		root = null;
	}
	
	/* Function to check if tree is empty */
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	
	/* Function to count the number of node */
	public int countNodes() {
		return countNodes(root);
	}
	
	/* Function to count number of nodes recursively */
	private int countNodes(BSTNode node) {
		if(node == null) {
			return 0;
		} else
		{
			int count = 1;
			count += countNodes(node.getLeftSubtree());
			count += countNodes(node.getRightSubtree());
			return count;
		}
	}
  	
	/* Function to insert data in tree */
	public void insert(int data) {
		root = insert(root, data);
	}
	
	/* Recursively input data in tree */
	public BSTNode insert(BSTNode node, int data) {
		/* Base Case: find the null node and create
		 * a new node with given data 
		 */
		if(node == null) {
			node = new BSTNode(data);
		} else
		{
			/* If the data we want to insert is larger
			 * than the root data, recurse on to left side.
			 * Else we recurse on to right side.
			 */
			if(data <= node.getVal()) {
				node.setLeftSubtree(insert(node.getLeftSubtree(), data));
			}
			else {
				node.setRightSubtree(insert(node.getRightSubtree(), data));
			}
		}
		return node;
	}

	/* Function to search for a val in tree */
	public boolean search(int val) {
		return search(root, val);
	}
	
	/* Function that searches for an element recursively */
	public boolean search(BSTNode node, int val) {
		boolean found = false;
		while((node != null) && !found) {
			/* The root value is the value in the root.
			 * We check and see if val is bigger or smaller.
			 * We then set our root to left or right subtree
			 * depending on that. If its neither then it must
			 * be the root and we return true as its found.
			 * We recurse on the given subtree until found.
			 */
			int rootVal = node.getVal();
			if(val < rootVal) {
				node = node.getLeftSubtree();
			} else if(val > rootVal) {
				node = node.getRightSubtree();
			} else {
				found = true;
				break;
			}
			found = search(node, val);
		}
		return found;
	}
	
	/* Delete value k from the tree */
	public void delete(int k) {
		if(isEmpty()) {
			System.out.println("Nothing to delete. Tree is empty.");
		} else if(search(k) == false) {
			System.out.println("Value is not in tree.");
		} else {
			root = delete(root, k);
			System.out.println(k + " was deleted from the tree");
		}
	}
	
	/* Function to recursively delete value from the tree */
	public BSTNode delete(BSTNode root, int val) {
		BSTNode p, p2, node;
		/* Case 1:
		 * If we want to delete root.
		 * check if right and left subtrees are null.
		 * If either one is then set the other subtrees
		 * member to the root.
		 * If neither are null, then we need to figure a way
		 * to set the root.
		 * In this case, we can move the left subtree of the
		 * root to a new place. We pick this place by going to 
		 * the roots right subtree and going to the right's left
		 * most. Once we are there, we set the roots left subtree
		 * to that nodes left subtree and return a pointer to the
		 * right subtree. Now the right subtree is the root and original
		 * root is deleted.
		 */
		if(root.getVal() == val) {
			BSTNode ltree, rtree;
			ltree = root.getLeftSubtree();
			rtree = root.getRightSubtree();
			if(ltree == null && rtree == null) {
				return null;
			} else if(ltree == null) {
				p = rtree;
				return p;
			} else if(rtree == null) {
				p = ltree;
				return p;
			}
			else
			{
				p2 = rtree;
				p = rtree;
				while(p.getLeftSubtree() != null) {
					p = p.getLeftSubtree();
				}
				p.setLeftSubtree(ltree);
				return p2;
			}
		}
		/* Case 2:
		 * Our value falls in the left subtree.
		 * We then pass in the left subtree of the tree
		 * and recurse on it.
		 */
		if(val < root.getVal()) {
			node = delete(root.getLeftSubtree(), val);
			root.setLeftSubtree(node);
		}
		/* Case 3:
		 * Our value falls in the right subtree.
		 * We then pass in the right subtree of the tree
		 * and recurse on it.
		 */
		else
		{
			node = delete(root.getRightSubtree(), val);
			root.setRightSubtree(node);
		}
		return root;
	}
	
	/* In order traversal of the tree */
	public void inOrder() {
		inOrder(root);
	}
	
	/* Recursive in order traversal of the tree */
	public void inOrder(BSTNode r) {
		if(r != null) {
			inOrder(r.getLeftSubtree());
			System.out.println("Value: " + r.getVal());
			inOrder(r.getRightSubtree());
		}
	}
	
	/* Function for pre order traversal of tree */
	public void preOrder() {
		preOrder(root);
	}
	
	/* Function that produces pre order recursively */
	public void preOrder(BSTNode r) {
		if(r != null) {
			System.out.println("Value: " + r.getVal());
			preOrder(r.getLeftSubtree());
			preOrder(r.getRightSubtree());
		}
	}
	
	/* Post order function for a tree */
	public void postOrder() {
		postOrder(root);
	}
	
	/* Function that produces post order recursively */
	public void postOrder(BSTNode r) {
		if(r != null) {
			postOrder(r.getLeftSubtree());
			postOrder(r.getRightSubtree());
			System.out.println("Value: " + r.getVal());
		}
	}
}
