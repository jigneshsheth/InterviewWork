
public class BSTNode {

	private BSTNode left, right;
	private int val;
	
	public BSTNode() {
		left = null;
		right = null;
		val = 0;
	}
	
	public BSTNode(int n) {
		left = null;
		right = null;
		val = n;
	}
	
	public void setLeftSubtree(BSTNode l) {
		left = l;
	}
	
	public void setRightSubtree(BSTNode r) {
		right = r;
	}
	
	public BSTNode getLeftSubtree() {
		return left;
	}
	
	public BSTNode getRightSubtree() {
		return right;
	}
	
	public void setVal(int v) {
		val = v;
	}
	
	public int getVal() {
		return val;
	}
}
