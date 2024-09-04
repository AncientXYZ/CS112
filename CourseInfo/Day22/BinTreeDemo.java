class IntTreeNode {
	int value;
	IntTreeNode left, right;
	
	public IntTreeNode(int n) {
		value = n;
		left = null;
		right = null;
	}
}

class IntTree {
	private IntTreeNode root = null;
	
	public void add(int n) {
		if (root == null) {
			root = new IntTreeNode(n);
			return;
		}
		// root is not null
		add(root, n);
	}
	
	private void add(IntTreeNode ptr, int n) {
		if (n < ptr.value) { // add on the left, else on the right
			if (ptr.left == null) {
				ptr.left = new IntTreeNode(n); // base case!
			} else {
				add(ptr.left, n); // recursive!
			}
		} else {
			if (ptr.right == null) {
				ptr.right = new IntTreeNode(n);
			} else {
				add(ptr.right, n);
			}
		}
	}
}
public class BinTreeDemo {

	public static void main(String[] args) {
		IntTree theTree = new IntTree();
		for (int count = 0; count < 35; count++) {
			theTree.add( (int) (1000*Math.random()));
		}

	}

}
